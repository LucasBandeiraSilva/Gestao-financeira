package com.gestao.financeira.projeto.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.financeira.projeto.dto.InvestimentoDto;
import com.gestao.financeira.projeto.entidades.Cliente;
import com.gestao.financeira.projeto.entidades.Investimento;
import com.gestao.financeira.projeto.enums.TipoInvestimento;
import com.gestao.financeira.projeto.repositorios.ClienteRepository;
import com.gestao.financeira.projeto.repositorios.InvestimentoRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

@Service
public class InvestimentoService {

    @Autowired
    private InvestimentoRepository investimentoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContaBancariaService contaBancariaService;

    public Cliente findInvestimentoCliente(HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
        if (cliente != null) {
            Investimento investimento = investimentoRepository.findByClienteId(cliente.getId()).get();
            return investimento.getCliente();
        }
        return null;

    }

    public ModelAndView homeInvestimento(HttpSession session) {
        ModelAndView mv = new ModelAndView("investimento/home-investimento");
        Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
        if (cliente.getContaBancaria().isEmpty()) {
            mv.setViewName("banco/aviso-cadastrar-conta");
            return mv;
        }
        List<Investimento> investimentos = investimentoRepository.findAll();

        mv.addObject("investimentos", investimentos);
        mv.addObject("listaVazia", investimentos.isEmpty());
        BigDecimal saldo = contaBancariaService.getSaldoCliente(cliente.getId(), session);
        mv.addObject("saldo", saldo);

        return mv;
    }

    public ModelAndView novoInvestimento(HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
        ModelAndView mv = new ModelAndView();
        Boolean ehUmaContaExistente = contaBancariaService.exisitsContaBancariaCliente(session);
        if (cliente != null && ehUmaContaExistente) {
            mv.setViewName("investimento/novoInvestimento");
            mv.addObject("tiposInvestimentos", TipoInvestimento.values());
        } else
            mv.setViewName("cliente/login");

        return mv;

    }

    public ModelAndView fazerInvestimento(HttpSession session, String investimento) {
        String formattedInvestimento = investimento.replace("-", "_").toUpperCase();
        TipoInvestimento tipoInvestimento = TipoInvestimento.valueOf(formattedInvestimento);

        Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
        ModelAndView mv = new ModelAndView();
        if (cliente != null) {
            BigDecimal saldoCliente = contaBancariaService.getSaldoCliente(cliente.getId(), session);
            InvestimentoDto investimentoDto = new InvestimentoDto();
            investimentoDto.setTipoInvestimento(tipoInvestimento);
            session.setAttribute("tipoInvestimento", investimentoDto.getTipoInvestimento());
            mv.addObject("investimentoDto", investimentoDto);
            mv.addObject("investimento", tipoInvestimento);
            mv.addObject("saldoCliente", saldoCliente);
            mv.setViewName("investimento/" + tipoInvestimento);
        } else
            mv.setViewName("cliente/login");
        return mv;

    }

    @Transactional
    public ModelAndView investimentoRealizado(InvestimentoDto investimentoDto, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
        if (cliente != null) {
            Investimento investimento = new Investimento();
            TipoInvestimento tipoInvestimento = (TipoInvestimento) session.getAttribute("tipoInvestimento");

            investimento.setCliente(cliente);
            BeanUtils.copyProperties(investimentoDto, investimento);
            investimento.setTipoInvestimento(tipoInvestimento);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            investimento.setDataInvestimento(LocalDate.now().format(formatter));
            contaBancariaService.atualizarSaldoContaBancaria(investimento.getValorInicial(), session);
            investimentoRepository.save(investimento);
            cliente.getInvestimento().add(investimento);
            mv.setViewName("investimento/sucesso-aplicar-investimento");
        }
        return mv;
    }

    @Transactional
    public ModelAndView resgatarInvestimento(Long id, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
        TipoInvestimento tipoInvestimento = (TipoInvestimento) session.getAttribute("tipoInvestimento");

        Optional<Investimento> optionalInvestimento = investimentoRepository.findById(id);
        if (optionalInvestimento.isPresent()) {
            Investimento investimento = optionalInvestimento.get();
            BigDecimal valorInvestido = investimento.getValorInicial();
            BigDecimal porcentagemRetorno = tipoInvestimento.getPorcentagemRetorno();
            BigDecimal valorAumentado = valorInvestido.multiply(porcentagemRetorno);
            contaBancariaService.atualizarSaldoContaBancaria(investimento.getValorInicial().negate(), session);

            investimentoRepository.delete(investimento);
            contaBancariaService.atualizarSaldoComPorcentagem(valorAumentado, cliente);

            mv.setViewName("investimento/sucesso-resgate");
            return mv;
        }
        mv.setViewName("investimento/nao-encontrado");
        return mv;
    }

}

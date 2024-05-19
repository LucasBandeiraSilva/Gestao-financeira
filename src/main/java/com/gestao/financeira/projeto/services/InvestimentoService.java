package com.gestao.financeira.projeto.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public Cliente findInvestimentoCliente(HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
        if (cliente != null) {
            Investimento investimento = investimentoRepository.findByClienteId(cliente.getId()).get();
            return investimento.getCliente();
        }
        return null;

    }

    public ModelAndView homeInvestimento(HttpSession session){
        ModelAndView mv = new ModelAndView("investimento/investimento");
        Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
        if (cliente.getInvestimento() != null) {
            mv.addObject("investimentos", cliente.getInvestimento());
        }
        return mv;
    }

    public ModelAndView novoInvestimento(HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
        ModelAndView mv = new ModelAndView();
        if (cliente != null) {
            System.out.println("nao nulo");
            mv.setViewName("investimento/novoInvestimento");
            mv.addObject("tiposInvestimentos", TipoInvestimento.values());
        }
        System.out.println(" nulo");
        return mv;

    }

    public ModelAndView fazerInvestimento(HttpSession session, String investimento) {
        TipoInvestimento tipoInvestimento = TipoInvestimento.valueOf(investimento.toUpperCase());
        ModelAndView mv = new ModelAndView();
        InvestimentoDto investimentoDto = new InvestimentoDto();
        investimentoDto.setTipoInvestimento(tipoInvestimento);
        System.out.println("o investimento é: " + investimentoDto.getTipoInvestimento());
        session.setAttribute("tipoInvestimento", investimentoDto.getTipoInvestimento());
        mv.addObject("investimento", tipoInvestimento);
        mv.addObject("investimentoDto", investimentoDto);
        mv.setViewName("investimento/" + tipoInvestimento);
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
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            investimento.setDataInvestimento(LocalDate.now().format(formatter));
            cliente.getInvestimento().add(investimento);
            clienteRepository.save(cliente);
            investimentoRepository.save(investimento);
            mv.setViewName("cliente/tela-principal-logado");
        }
        return mv;
    }

}

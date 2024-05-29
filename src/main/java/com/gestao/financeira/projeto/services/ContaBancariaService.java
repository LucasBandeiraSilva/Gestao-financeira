package com.gestao.financeira.projeto.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.financeira.projeto.dto.ContaBancariaDto;
import com.gestao.financeira.projeto.entidades.Cliente;
import com.gestao.financeira.projeto.entidades.ContaBancaria;
import com.gestao.financeira.projeto.enums.TipoBanco;
import com.gestao.financeira.projeto.enums.TipoConta;
import com.gestao.financeira.projeto.repositorios.ClienteRepository;
import com.gestao.financeira.projeto.repositorios.ContaBancariaRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public ModelAndView cadastrarConta() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("tipoConta", TipoConta.values());
        mv.addObject("tipoBanco", TipoBanco.values());
        mv.addObject("contaBancaria", new ContaBancariaDto());
        mv.setViewName("banco/cadastro");
        return mv;
    }

    @Transactional
    public ModelAndView salvarConta(HttpSession session, ContaBancariaDto contaBancariaDto) {
        Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
        ModelAndView mv = new ModelAndView();

        ContaBancaria contaBancaria = new ContaBancaria();
        BeanUtils.copyProperties(contaBancariaDto, contaBancaria);
        contaBancaria.setCliente(cliente);
        cliente.getContaBancaria().add(contaBancaria);
        clienteRepository.save(cliente);
        contaBancariaRepository.save(contaBancaria);
        mv.setViewName("/cliente/tela-principal-logado");

        return mv;
    }

    public BigDecimal getSaldoCliente(Long id, HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
        if (cliente != null) {
            ContaBancaria contaBancaria = contaBancariaRepository.findByClienteId(cliente.getId()).get();
            return contaBancaria.getSaldo();
        }
        return null;
    }

    public Boolean exisitsContaBancariaCliente(HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
        if (cliente != null && cliente.getContaBancaria().isEmpty()) {
            return false;
        }
        return true;
    }

    @Transactional
    public BigDecimal atualizarSaldoContaBancaria(BigDecimal saldoRetirado, HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
        ContaBancaria contaBancaria = contaBancariaRepository.findByClienteId(cliente.getId()).get();
        contaBancaria.setSaldo(contaBancaria.getSaldo().subtract(saldoRetirado));
        System.out.println("saldo apos investir: " + contaBancaria.getSaldo());
        contaBancariaRepository.save(contaBancaria);
        return contaBancaria.getSaldo();
    }

    public void atualizarSaldoComPorcentagem(BigDecimal porcentagem, Long id, Cliente cliente) {

        ContaBancaria contaBancaria = contaBancariaRepository.findByClienteId(cliente.getId()).get();
        BigDecimal valorAumentado = contaBancaria.getSaldo().multiply(porcentagem);
        contaBancaria.setSaldo(contaBancaria.getSaldo().add(valorAumentado));
        System.out.println("novo saldo com porcentagem: " + contaBancaria.getSaldo().setScale(2, RoundingMode.HALF_UP));
        contaBancariaRepository.save(contaBancaria);

    }
}

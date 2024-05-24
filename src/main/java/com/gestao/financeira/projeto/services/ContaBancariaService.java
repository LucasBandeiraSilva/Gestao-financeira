package com.gestao.financeira.projeto.services;

import java.math.BigDecimal;
import java.util.Optional;

import javax.naming.Binding;

import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.financeira.projeto.dto.ContaBancariaDto;
import com.gestao.financeira.projeto.entidades.Cliente;
import com.gestao.financeira.projeto.entidades.ContaBancaria;
import com.gestao.financeira.projeto.repositorios.ClienteRepository;
import com.gestao.financeira.projeto.repositorios.ContaBancariaRepository;

import ch.qos.logback.core.net.server.Client;
import jakarta.servlet.http.HttpSession;

@Service
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public ModelAndView salvarConta(HttpSession session, ContaBancariaDto contaBancariaDto) {
        Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
        if (cliente != null) {
            System.out.println("entrando na pagina....");
        }

        ModelAndView mv = new ModelAndView();
        if (cliente == null) {
            mv.setViewName("/cliente/cadastro");
            return mv;
        } else {

            ContaBancaria contaBancaria = new ContaBancaria();
            BeanUtils.copyProperties(contaBancariaDto, contaBancaria);
            contaBancaria.setCliente(cliente);
            cliente.getContaBancaria().add(contaBancaria);
            clienteRepository.save(cliente);
            contaBancariaRepository.save(contaBancaria);
            System.out.println("saldo atual: " + contaBancaria.getSaldo());
            mv.setViewName("/cliente/tela-principal-logado");
        }
        return mv;
    }

    public BigDecimal getSaldoCliente(Long id, HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        if (cliente != null) {
            ContaBancaria contaBancaria = contaBancariaRepository.findByClienteId(cliente.getId()).get();
            return contaBancaria.getSaldo();
        }
        return null;
    }

    public Boolean exisitsContaBancariaCliente(HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
        if (cliente.getContaBancaria().isEmpty()) {
            return false;
        }
        return true;
    }
}

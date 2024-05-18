package com.gestao.financeira.projeto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.financeira.projeto.entidades.Cliente;
import com.gestao.financeira.projeto.entidades.Investimento;
import com.gestao.financeira.projeto.enums.TipoInvestimento;
import com.gestao.financeira.projeto.repositorios.InvestimentoRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class InvestimentoService {

    @Autowired
    private InvestimentoRepository investimentoRepository;

    public Cliente findInvestimentoCliente(HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
        if (cliente != null) {
            Investimento investimento = investimentoRepository.findByClienteId(cliente.getId()).get();
            return investimento.getCliente();
        }
        return null;

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

}

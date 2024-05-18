package com.gestao.financeira.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.financeira.projeto.entidades.Cliente;
import com.gestao.financeira.projeto.services.InvestimentoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/investimento")
public class InvestimentoController {
    @Autowired
    private InvestimentoService investimentoService;
    
    @GetMapping("")
    public ModelAndView homeInvestimento(HttpSession session){
        ModelAndView mv = new ModelAndView("investimento/investimento");
        return mv;
    }
    @GetMapping("/novo")
    public ModelAndView novoInvestimento(HttpSession session){
        return investimentoService.novoInvestimento(session);
    }
}

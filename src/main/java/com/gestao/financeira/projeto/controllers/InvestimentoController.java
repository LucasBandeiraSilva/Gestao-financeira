package com.gestao.financeira.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.financeira.projeto.dto.InvestimentoDto;
import com.gestao.financeira.projeto.services.InvestimentoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/investimento")
public class InvestimentoController {
    @Autowired
    private InvestimentoService investimentoService;
    
    @GetMapping("")
    public ModelAndView homeInvestimento(HttpSession session){
        return investimentoService.homeInvestimento(session);
    }
    @GetMapping("/novo")
    public ModelAndView novoInvestimento(HttpSession session){
        return investimentoService.novoInvestimento(session);
    }
    @GetMapping("/novo/{investimento}")
    public ModelAndView fazerInvestimento(HttpSession session, @PathVariable("investimento") String investimento){
        return investimentoService.fazerInvestimento(session, investimento);
    }
    @PostMapping("/realizado")
    public ModelAndView investimentoRealizado(@ModelAttribute("InvestimentoDto") InvestimentoDto investimentoDto,HttpSession session){
        return investimentoService.investimentoRealizado(investimentoDto,session);
    }
    @GetMapping("/resgatar/{id}")
    public ModelAndView resgatarInvestimento(@PathVariable("id") Long id,HttpSession session){
        return investimentoService.resgatarInvestimento(id,session);
    }
}

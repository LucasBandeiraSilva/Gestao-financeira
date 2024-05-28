package com.gestao.financeira.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.financeira.projeto.dto.PlanejamentoDto;
import com.gestao.financeira.projeto.services.PlanejamentoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/planejamento")
public class PlanejamentoController {

    @Autowired
    private PlanejamentoService planejamentoService;

    @GetMapping("")
    public ModelAndView homePlanejamento() {
        return planejamentoService.homePlanejamento();
    }

    @GetMapping("/novo")
    public ModelAndView adicionarPlanejamento(HttpSession session) {
        return planejamentoService.adicionarPlanejamento(session);
    }

    @PostMapping("/realizado")
    public ModelAndView planjeamentoRealizado(@ModelAttribute("planejamentoDto") PlanejamentoDto planejamentoDto,
            HttpSession session) {
        return planejamentoService.planjeamentoRealizado(planejamentoDto, session);
    }
    @GetMapping("/concluir/{id}")
    public ModelAndView concluirPlanejamento(@PathVariable Long id){
        return planejamentoService.concluirPlanejamento(id);
    }
}

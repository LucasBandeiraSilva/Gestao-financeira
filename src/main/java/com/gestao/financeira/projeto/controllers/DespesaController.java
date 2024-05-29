package com.gestao.financeira.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.financeira.projeto.dto.DespesasDto;
import com.gestao.financeira.projeto.services.DespesaService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/despesa")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @GetMapping("")
    public ModelAndView homeDespesa() {
        return despesaService.homeDespesas();
    }

    @GetMapping("/adicionar")
    public ModelAndView adicionarDespesa() {
        return despesaService.formAdicionaDespesa();
    }

    @PostMapping("/adicionada")
    public ModelAndView despesaAdicionada(@ModelAttribute("DespesaDto") DespesasDto despesasDto, HttpSession session) {
        return despesaService.despesaAdicionada(despesasDto, session);
    }
    @GetMapping("/excluir/{id}")
    public ModelAndView despesaExcluida(@PathVariable Long id) {
        return despesaService.despesaExcluida(id);
    }
}

package com.gestao.financeira.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.financeira.projeto.dto.ContaBancariaDto;
import com.gestao.financeira.projeto.services.ContaBancariaService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/banco")
public class ContaBancariaController {
    @Autowired
    private ContaBancariaService contaBancariaService;
    
    @GetMapping("/cadastro")
    public ModelAndView cadastrarConta(){
        return contaBancariaService.cadastrarConta();
    }
    @PostMapping("/cadastro")
    public ModelAndView salvarConta(  HttpSession session,  ContaBancariaDto contaBancariaDto){
        return contaBancariaService.salvarConta(session, contaBancariaDto);
    }
}

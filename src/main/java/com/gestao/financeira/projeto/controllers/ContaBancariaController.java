package com.gestao.financeira.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.financeira.projeto.dto.ContaBancariaDto;
import com.gestao.financeira.projeto.entidades.Cliente;
import com.gestao.financeira.projeto.enums.TipoBanco;
import com.gestao.financeira.projeto.enums.TipoConta;
import com.gestao.financeira.projeto.services.ContaBancariaService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/banco")
public class ContaBancariaController {
    @Autowired
    private ContaBancariaService contaBancariaService;
    
    @GetMapping("/cadastro")
    public ModelAndView cadastrarConta(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("tipoConta", TipoConta.values());
        mv.addObject("tipoBanco", TipoBanco.values());
        mv.addObject("contaBancaria", new ContaBancariaDto());
        mv.setViewName("banco/cadastro");
        return mv;
    }
    @PostMapping("/cadastro")
    public ModelAndView salvarConta(  HttpSession session, @Valid @ModelAttribute("contaBancaria") ContaBancariaDto contaBancariaDto, BindingResult bindingResult){
        return contaBancariaService.salvarConta(session, contaBancariaDto,bindingResult);
    }
}

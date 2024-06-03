package com.gestao.financeira.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.financeira.projeto.services.ClienteService;

@Controller
@RequestMapping("/")
public class ClienteNaoLogadoController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("")
    public ModelAndView telaPrinciapalNaoLogado(){
        return clienteService.telaPrinciapalNaoLogado();
    }
}

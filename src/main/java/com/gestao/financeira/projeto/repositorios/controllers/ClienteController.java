package com.gestao.financeira.projeto.repositorios.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


@Controller
//toda requisão do cliente sempre vai começar /cliente/alguma-coisa
@RequestMapping("/cliente")
public class ClienteController {
    
    @GetMapping("/login")
    public String getMethodName(HttpSession session) {
        session.invalidate(); // limpa a sessao para que o usuario possa logar novamente
        return "cliente/login";
    }
    
}

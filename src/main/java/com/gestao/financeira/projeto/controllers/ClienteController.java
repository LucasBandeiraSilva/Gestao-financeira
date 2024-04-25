package com.gestao.financeira.projeto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.financeira.projeto.dto.ClienteDto;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
// toda requisão do cliente sempre vai começar /cliente/alguma-coisa
@RequestMapping("/cliente")
public class ClienteController {

    @GetMapping("/login")
    public String login(HttpSession session) {
        session.invalidate(); // limpa a sessao para que o usuario possa logar novamente
        return "cliente/login";
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastro() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cliente/cadastro");
        mv.addObject("clienteDto", new ClienteDto());
        return mv;
    }

    @PostMapping("/cadastro")
    public ModelAndView validaCadastro(@ModelAttribute("clienteDto") @Valid ClienteDto clienteDto,
            BindingResult result) {
        ModelAndView mv = new ModelAndView();
        if (result.hasErrors()) {

            mv.setViewName("cliente/cadastro");
            System.out.println("existe erros aqui");
            return mv;
        }
        return mv;
    }

}

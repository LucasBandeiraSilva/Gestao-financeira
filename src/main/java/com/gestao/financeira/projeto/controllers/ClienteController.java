package com.gestao.financeira.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestao.financeira.projeto.dto.ClienteDto;
import com.gestao.financeira.projeto.services.ClienteService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
// toda requisão do cliente sempre vai começar /cliente/alguma-coisa
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/login")
    public String login(HttpSession session) {
        return "cliente/login";
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastro() {
        return clienteService.cadastro();
    }

    @PostMapping("/cadastro")
    public ModelAndView validaCadastro(@ModelAttribute("clienteDto") @Valid ClienteDto clienteDto,
            BindingResult result) {
        return clienteService.saveCliente(clienteDto, result);
    }

    @PostMapping("/login")
    public ModelAndView autenticacaoLogin(@RequestParam("email") String email, @RequestParam("senha") String senha,
            RedirectAttributes attributes, HttpSession session) {
        return clienteService.autenticacaoLogin(email, senha, attributes, session);

    }

    @GetMapping("/logado")
    public ModelAndView telaLogado() {
        return clienteService.telaPrincipalLogado();
    }

    @GetMapping("/esqueci/senha")
    public ModelAndView esqueciSenha() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cliente/esqueceu-a-senha");
        return mv;
    }

    @PostMapping("/email")
    public ModelAndView recuperarSenha(String email, RedirectAttributes redirectAttributes, HttpSession session) {
        return clienteService.recuperarSenha(email, redirectAttributes, session);
    }

    @PostMapping("/redefinir/senha")
    public ModelAndView novaSenha(String senha, HttpSession session) {
        return clienteService.novaSenha(senha, session);
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        return clienteService.logout(session);
    }
}

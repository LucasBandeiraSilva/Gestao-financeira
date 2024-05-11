package com.gestao.financeira.projeto.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestao.financeira.projeto.dto.ClienteDto;
import com.gestao.financeira.projeto.entidades.Cliente;
import com.gestao.financeira.projeto.repositorios.ClienteRepository;
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
        return clienteService.saveCliente(clienteDto, result);
    }

    @PostMapping("/login")
    public ModelAndView autenticacaoLogin(@RequestParam("email") String email, @RequestParam("senha") String senha,
            RedirectAttributes attributes, HttpSession session) {
        return clienteService.autenticacaoLogin(email, senha, attributes,session);

    }
    @GetMapping("/logado")
    public ModelAndView telaLogado(HttpSession session, Cliente cliente){
        ModelAndView mv = new ModelAndView();
        session.setAttribute("usuario", cliente);
        mv.setViewName("cliente/tela-principal-logado");
        return mv;
    }
    

}

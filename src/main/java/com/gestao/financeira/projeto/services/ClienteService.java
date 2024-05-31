package com.gestao.financeira.projeto.services;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestao.financeira.projeto.dto.ClienteDto;
import com.gestao.financeira.projeto.entidades.Cliente;
import com.gestao.financeira.projeto.repositorios.ClienteRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public ModelAndView telaPrinciapalNaoLogado(){
        return new ModelAndView("cliente/tela-principal-nao-logado");
    }

    public ModelAndView cadastro(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cliente/cadastro");
        mv.addObject("clienteDto", new ClienteDto());
        return mv;
    }

    public ModelAndView telaPrincipalLogado(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cliente/tela-principal-nao-logado");
        return mv;
    }

    public ModelAndView saveCliente(ClienteDto clienteDto,
            BindingResult result) {
        ModelAndView mv = new ModelAndView();
        if (result.hasErrors()) {
            System.out.println("existe erros aqui");
            mv.setViewName("/cliente/cadastro");
            return mv;

        }
        if (clienteRepository.existsByCpf(clienteDto.getCpf())) {
            System.out.println("duplo cpf");
            mv.addObject("cpf", "O cpf ja existe no sistema!");
            mv.setViewName("/cliente/cadastro");
            return mv;
        }
        var cliente = new Cliente();
        String senhaCriptografada = encoder.encode(clienteDto.getSenha());
        clienteDto.setData_criacao(LocalDateTime.now());
        clienteDto.setSenha(senhaCriptografada);
        BeanUtils.copyProperties(clienteDto, cliente);
        clienteRepository.save(cliente);
        mv.setViewName("redirect:/cliente/login");
        return mv;
    }

    public ModelAndView autenticacaoLogin(String email, String senha, RedirectAttributes attributes,
            HttpSession session) {
        ModelAndView mv = new ModelAndView();

        Cliente cliente = clienteRepository.findByEmail(email);
        if (cliente != null && encoder.matches(senha, cliente.getSenha())) {
            mv.addObject("nomeCliente", cliente.getNome());
            session.setAttribute("clienteLogado", cliente);
            mv.setViewName("/cliente/tela-principal-logado");
            System.out.println("compativel");
        } else {
            attributes.addFlashAttribute("erro", "e-mail e/ou senha incorreta! Tente novamente.");
            mv.setViewName("redirect:/cliente/login");
        }

        return mv;

    }

    public ModelAndView recuperarSenha(String email, RedirectAttributes redirectAttributes, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Cliente cliente = clienteRepository.findByEmail(email);
        if (cliente != null) {
            mv.setViewName("cliente/redefinir-senha");
            session.setAttribute("cliente", cliente);
        } else {
            redirectAttributes.addFlashAttribute("erro", "Não existe um cadastro deste e-mail.");
            mv.setViewName("redirect:/cliente/esqueci/senha");
        }
        return mv;
    }

    public ModelAndView novaSenha(String senha, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        if (cliente != null) {
            String senhaCriptografada = encoder.encode(senha);
            cliente.setSenha(senhaCriptografada);
            clienteRepository.save(cliente);
            mv.setViewName("redirect:/cliente/login");
        }
        return mv;
    }

    public ModelAndView logout(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        session.invalidate();
        mv.setViewName("redirect:/cliente/login");
        return mv;
    }

    
}

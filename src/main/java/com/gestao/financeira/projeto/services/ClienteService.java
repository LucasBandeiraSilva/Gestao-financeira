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

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

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
        System.out.println(cliente.toString());
        System.out.println("senha: " + cliente.getSenha());
        clienteRepository.save(cliente);

        mv.setViewName("redirect:/cliente/login");
        return mv;
    }

    public ModelAndView autenticacaoLogin(String email,  String senha){
        ModelAndView mv = new ModelAndView();
        Cliente cliente = clienteRepository.findByEmail(email);
        if (cliente != null && encoder.matches(senha, cliente.getSenha())) {
            System.out.println("compativel");
        }else{
            System.out.println("não compativel");
        }
        return mv;

    }
}

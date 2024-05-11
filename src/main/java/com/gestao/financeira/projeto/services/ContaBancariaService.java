package com.gestao.financeira.projeto.services;

import javax.naming.Binding;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.financeira.projeto.dto.ContaBancariaDto;
import com.gestao.financeira.projeto.entidades.Cliente;
import com.gestao.financeira.projeto.entidades.ContaBancaria;
import com.gestao.financeira.projeto.repositorios.ClienteRepository;
import com.gestao.financeira.projeto.repositorios.ContaBancariaRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public ModelAndView salvarConta(HttpSession session, ContaBancariaDto contaBancariaDto) {
        Cliente cliente = (Cliente) session.getAttribute("usuario");
        ModelAndView mv = new ModelAndView();
        if (cliente == null) {
                mv.setViewName("/cliente/cadastro");
                return mv;
            } 
            ContaBancaria contaBancaria = new ContaBancaria();
            BeanUtils.copyProperties(contaBancariaDto, contaBancaria);
            contaBancaria.setCliente(cliente);
            cliente.getContaBancaria().add(contaBancaria);
            clienteRepository.save(cliente);
            contaBancariaRepository.save(contaBancaria);
        mv.setViewName("redirect:/cliente/logado");
        return mv;
    }
}

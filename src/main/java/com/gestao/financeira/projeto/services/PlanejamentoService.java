package com.gestao.financeira.projeto.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.financeira.projeto.dto.PlanejamentoDto;
import com.gestao.financeira.projeto.entidades.Cliente;
import com.gestao.financeira.projeto.entidades.Planejamento;
import com.gestao.financeira.projeto.enums.TipoPlanejamento;
import com.gestao.financeira.projeto.repositorios.PlanejamentoRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class PlanejamentoService {

    @Autowired
    private PlanejamentoRepository planejamentoRepository;

    @Autowired

    public ModelAndView homePlanejamento() {
        ModelAndView mv = new ModelAndView("planejamento/home-Planejamento");
        mv.addObject("planejamentos", planejamentoRepository.findAll());
        
        return mv;
    }

    public ModelAndView adicionarPlanejamento(HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
        ModelAndView mv = new ModelAndView();
        if (cliente != null) {
            mv.setViewName("planejamento/form-planejamento");
            mv.addObject("planejamentoDto", new PlanejamentoDto());
            
            mv.addObject("tipoPlanejamento", TipoPlanejamento.values());
        }
        return mv;

    }

    public ModelAndView planjeamentoRealizado(PlanejamentoDto planejamentoDto, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Cliente cliente = (Cliente) session.getAttribute("clienteLogado");
        Planejamento planejamento = new Planejamento();
        planejamento.setCliente(cliente);
        planejamento.setDataTermino(planejamentoDto.getDataTermino());
        BeanUtils.copyProperties(planejamentoDto, planejamento);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        planejamento.setDataInicio(LocalDate.now().format(formatter));
        planejamentoRepository.save(planejamento);
        mv.setViewName("redirect:/planejamento");

        return mv;
    }

    public ModelAndView concluirPlanejamento(Long id){
        ModelAndView mv = new ModelAndView();
        Planejamento planejamento = planejamentoRepository.findById(id).get();
        planejamentoRepository.deleteById(planejamento.getId());
        mv.setViewName("/planejamento/planejamento-concluido");
        return mv;
    }
}

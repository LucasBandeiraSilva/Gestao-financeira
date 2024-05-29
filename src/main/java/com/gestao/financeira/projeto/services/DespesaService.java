package com.gestao.financeira.projeto.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.financeira.projeto.dto.DespesasDto;
import com.gestao.financeira.projeto.entidades.Cliente;
import com.gestao.financeira.projeto.entidades.Despesa;
import com.gestao.financeira.projeto.enums.TipoDespesas;
import com.gestao.financeira.projeto.repositorios.DespesasRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class DespesaService {

    @Autowired
    private DespesasRepository despesaRepository;

    public ModelAndView homeDespesas() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("despesa/home-despesa");
        List<Despesa> despesas = despesaRepository.findAll();
        mv.addObject("despesas", despesas);
        mv.addObject("listaVazia",despesas.isEmpty());
        BigDecimal totalDespesas = new BigDecimal(0.00);
        for(Despesa despesa: despesas){
            totalDespesas = totalDespesas.add(despesa.getValorDespesa());
        }
        System.out.println("A soma das suas despesas é de: " + totalDespesas);
        mv.addObject("totalDespesas", totalDespesas);
        return mv;
    }

    public ModelAndView formAdicionaDespesa() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("despesa/form-despesa");
        mv.addObject("tipoDespesa", TipoDespesas.values());
        mv.addObject("despesaDto", new DespesasDto());
        return mv;
    }

    public ModelAndView despesaAdicionada(DespesasDto despesasDto, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Cliente cliente = (Cliente) session.getAttribute("clienteLogado");

        Despesa despesa = new Despesa();
        despesa.setCliente(cliente);
        BeanUtils.copyProperties(despesasDto, despesa);
        despesa.setDataDespesaAdicionada(LocalDate.now());
        System.out.println("data despesa: " + despesa.getDataDespesaAdicionada());
        despesaRepository.save(despesa);
        mv.setViewName("despesa/sucesso-cadastro-despesa");

        return mv;

    }

    public ModelAndView despesaExcluida(Long id) {
        ModelAndView mv = new ModelAndView();
        Despesa despesa = despesaRepository.findById(id).get();
        despesaRepository.deleteById(despesa.getId());
        mv.setViewName("despesa/sucesso-exclusao-despesa");
        return mv;
    }
}

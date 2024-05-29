package com.gestao.financeira.projeto.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.gestao.financeira.projeto.enums.TipoDespesas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DespesasDto {
    private TipoDespesas tipoDespesa;
    private BigDecimal valorDespesa;
    private String nome;
    private LocalDate dataDespesaAdicionada;

}

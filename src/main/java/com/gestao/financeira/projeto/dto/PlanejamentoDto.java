package com.gestao.financeira.projeto.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.gestao.financeira.projeto.enums.TipoPlanejamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlanejamentoDto {
    private String titulo;
    private BigDecimal meta;
    private Boolean status;
    private String descricao;
    private TipoPlanejamento tipoPlanejamento;
    private BigDecimal valor;
    private LocalDate datainicio;
    private LocalDate dataTermino;

    

}

package com.gestao.financeira.projeto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusInvestimento {
    ATIVO("ativo"),CANCELADO("cancelado"),RETIRADO("retirado");

    private String nome;

}

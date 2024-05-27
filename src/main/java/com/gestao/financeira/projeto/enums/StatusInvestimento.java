package com.gestao.financeira.projeto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum StatusInvestimento {
    RENDENDO("ativo"),RETIRADO("retirado");

    private String nome;

}

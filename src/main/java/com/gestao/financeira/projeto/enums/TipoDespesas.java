package com.gestao.financeira.projeto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoDespesas {
    ALIMENTACAO("Alimentação"), CONTAS("Contas"), AGUA("Agua"), LUZ("Luz"), DIVERSOS("Diversos");

    private String descricao;
}

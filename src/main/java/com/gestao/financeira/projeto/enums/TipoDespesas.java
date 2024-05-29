package com.gestao.financeira.projeto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoDespesas {
    ALIMENTACAO("Alimentação"), CONTAS("Contas"), AGUA("Água"), LUZ("Luz"),
    SAUDE("Saúde"), TRANSPORTE("Transporte"), MORADIA("Moradia"),
    EDUCACAO("Educação"), LIVROS("Livros"), CULTURA("Cultura"), LAZER("Lazer"),
    OUTROS("Outros"), INVESTIMENTO("Investimento"), IMPREVISTOS("Impreistos");

    private String descricao;
}

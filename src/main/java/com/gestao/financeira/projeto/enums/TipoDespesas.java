package com.gestao.financeira.projeto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoDespesas {
    ALIMENTACAO("Alimentação"), CONTAS("Contas"), AGUA("Água"), LUZ("Luz"),
    SAUDE("Saúde"), TRANSPORTE("Transporte"), MORADIA("Moradia"),
    EDUCACAO("Educação"), LIVROS("Livros"), CULTURA("Cultura"), LAZER("Lazer"),
    OUTROS("Outros"), INVESTIMENTO("Investimento"), IMPREVISTOS("Imprevistos"),
    FERIADOS("Feriados"), FESTAS("Festas"), CASAMENTO("Casamento");
    private String descricao;
}

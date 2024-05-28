package com.gestao.financeira.projeto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoPlanejamento {

    VIAGEM("Viagem"), INVESTIMENTOS("Investimentos"), PAGAMENTO_CONTAS("pagamento de contas"), LAZER("Lazer"),
    ALIMENTACAO("Alimentação"), SAUDE("Saúde"), EDUCACAO("Educação"),
    MORADIA("Moradia"), OUTROS("Outros");

    private String nome;

}

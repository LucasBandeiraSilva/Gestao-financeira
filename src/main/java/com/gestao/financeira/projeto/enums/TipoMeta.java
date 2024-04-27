package com.gestao.financeira.projeto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoMeta {

    VIAGEM("viagem"), INVESTIMENTOS("investimentos"), PAGAMENTO_CONTAS("pagamento de contas"), LAZER("Lazer"),
    OUTROS("Outros");

    private String nome;

}

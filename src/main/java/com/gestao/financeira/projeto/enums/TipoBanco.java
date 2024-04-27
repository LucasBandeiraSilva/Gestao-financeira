package com.gestao.financeira.projeto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoBanco {
    BANCO_DO_BRASIL("Banco do Brasil"),
    ITAU("Itaú"),
    BRADESCO("Bradesco"),
    SANTANDER("Santander"),
    INTER("Inter"), 
    CAIXA("Caixa Econômica Federal"),
    NUBANK("Nubank"),
    C6_BANK("C6 Bank");

    private String nome;
}

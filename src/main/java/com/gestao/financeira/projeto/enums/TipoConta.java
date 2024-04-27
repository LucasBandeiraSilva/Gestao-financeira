package com.gestao.financeira.projeto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoConta {
    
    CONTA_CORRENTE("Conta Corrente"), 
    CONTA_POUPANCA("Conta Poupança");
    private String nome;
}

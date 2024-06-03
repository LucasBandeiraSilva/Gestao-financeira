package com.gestao.financeira.projeto.enums;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoInvestimento {

        CDB("CDB",
                        "Segurança e rentabilidade, sem dor de cabeça", "CDB",BigDecimal.valueOf(0.75)),
        TESTOURO_DIRETO("Testouro-direto",
                        "Seja parte do crescimento do país e faça seu dinheiro render", "Tesouro Direto",BigDecimal.valueOf(0.80)),
        TESOURO_SELIC("Tesouro-selic",
                        "A solução ideal para quem busca rentabilidade e segurança sem complicações", "Tesouro Selic",BigDecimal.valueOf(0.85));

        private String nome;
        private String descricao;
        private String titulo;
        private BigDecimal porcentagemRetorno;

}

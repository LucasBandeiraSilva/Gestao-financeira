package com.gestao.financeira.projeto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoInvestimento {

        CDB("CDB",
                        "Segurança e rentabilidade, sem dor de cabeça", "CDB",0.05),
        TESTOURO_DIRETO("Testouro-direto",
                        "Seja parte do crescimento do país e faça seu dinheiro render", "Tesouro Direto",0.10),
        TESOURO_SELIC("Tesouro-selic",
                        "A solução ideal para quem busca rentabilidade e segurança sem complicações", "Tesouro Selic",0.15);

        private String nome;
        private String descricao;
        private String titulo;
        private Double porcentagemRetorno;

}

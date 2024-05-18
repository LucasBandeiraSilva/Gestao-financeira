package com.gestao.financeira.projeto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoInvestimento {

        CDB("CDB",
                        "Segurança e rentabilidade, sem dor de cabeça", "CDB"),
        TESTOURO_DIRETO("Testouro-direto",
                        "Seja parte do crescimento do país e faça seu dinheiro render", "Tesouro Direto"),
        TESOURO_SELIC("Tesouro-selic",
                        "A solução ideal para quem busca rentabilidade e segurança sem complicações", "Tesouro Selic");

        private String nome;
        private String descricao;
        private String titulo;

}

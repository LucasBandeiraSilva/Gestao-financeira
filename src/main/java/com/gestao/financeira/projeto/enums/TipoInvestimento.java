package com.gestao.financeira.projeto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoInvestimento {

    CDB("CDB",
            "O CDB (Certificado de Depósito Bancário) é um investimento de renda fixa emitido por bancos, oferecendo rentabilidade a partir do valor investido, com garantia do FGC (Fundo Garantidor de Créditos)"),
    TESTOURO_DIRETO("Testouro direto",
            "O Tesouro Direto é uma plataforma do governo que permite investir em títulos públicos, proporcionando segurança e rentabilidade, acessível a partir de pequenos valores e com diversas opções de prazos e rentabilidades"),
    TESOURO_SELIC("Tesouro selic",
            "O Tesouro Selic é um título público do Tesouro Direto atrelado à taxa básica de juros da economia (Selic), ideal para quem busca segurança e liquidez, com rendimento diário e baixo risco");

    private String nome;
    private String descricao;

}

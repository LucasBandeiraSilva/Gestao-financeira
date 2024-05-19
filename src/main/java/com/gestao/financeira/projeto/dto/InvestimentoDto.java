package com.gestao.financeira.projeto.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.gestao.financeira.projeto.enums.TipoInvestimento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InvestimentoDto {
    private TipoInvestimento tipoInvestimento;
    private BigDecimal valorInicial;
    private LocalDateTime data_retirada;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tipoInvestimento == null) ? 0 : tipoInvestimento.hashCode());
        result = prime * result + ((valorInicial == null) ? 0 : valorInicial.hashCode());
        result = prime * result + ((data_retirada == null) ? 0 : data_retirada.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InvestimentoDto other = (InvestimentoDto) obj;
        if (tipoInvestimento != other.tipoInvestimento)
            return false;
        if (valorInicial == null) {
            if (other.valorInicial != null)
                return false;
        } else if (!valorInicial.equals(other.valorInicial))
            return false;
        if (data_retirada == null) {
            if (other.data_retirada != null)
                return false;
        } else if (!data_retirada.equals(other.data_retirada))
            return false;
        return true;
    }

}

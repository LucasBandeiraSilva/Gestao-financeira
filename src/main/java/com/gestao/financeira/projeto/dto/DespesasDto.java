package com.gestao.financeira.projeto.dto;

import java.math.BigDecimal;

import com.gestao.financeira.projeto.enums.TipoDespesas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DespesasDto {
    private TipoDespesas TipoDespesas;
    private BigDecimal valorDespesa;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((TipoDespesas == null) ? 0 : TipoDespesas.hashCode());
        result = prime * result + ((valorDespesa == null) ? 0 : valorDespesa.hashCode());
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
        DespesasDto other = (DespesasDto) obj;
        if (TipoDespesas != other.TipoDespesas)
            return false;
        if (valorDespesa == null) {
            if (other.valorDespesa != null)
                return false;
        } else if (!valorDespesa.equals(other.valorDespesa))
            return false;
        return true;
    }

}

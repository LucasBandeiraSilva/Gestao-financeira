package com.gestao.financeira.projeto.dto;

import java.math.BigDecimal;

import com.gestao.financeira.projeto.enums.TipoBanco;
import com.gestao.financeira.projeto.enums.TipoConta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContaBancariaDto {
    private BigDecimal saldo;
    private TipoConta tipoConta;
    private int numero_conta;
    private TipoBanco tipoBanco;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
        result = prime * result + ((tipoConta == null) ? 0 : tipoConta.hashCode());
        result = prime * result + numero_conta;
        result = prime * result + ((tipoBanco == null) ? 0 : tipoBanco.hashCode());
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
        ContaBancariaDto other = (ContaBancariaDto) obj;
        if (saldo == null) {
            if (other.saldo != null)
                return false;
        } else if (!saldo.equals(other.saldo))
            return false;
        if (tipoConta != other.tipoConta)
            return false;
        if (numero_conta != other.numero_conta)
            return false;
        if (tipoBanco != other.tipoBanco)
            return false;
        return true;
    }

}

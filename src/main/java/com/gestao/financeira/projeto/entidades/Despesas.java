package com.gestao.financeira.projeto.entidades;

import java.math.BigDecimal;

import com.gestao.financeira.projeto.enums.TipoDespesas;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_despesas") // se quiser mudar o nome
public class Despesas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoDespesas TipoDespesas;
    private BigDecimal valorDespesa;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Despesas other = (Despesas) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
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

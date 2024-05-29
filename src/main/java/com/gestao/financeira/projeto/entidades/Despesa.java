package com.gestao.financeira.projeto.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.gestao.financeira.projeto.enums.TipoDespesas;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Despesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoDespesas tipoDespesa;
    private BigDecimal valorDespesa;
    private LocalDate dataDespesaAdicionada;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((tipoDespesa == null) ? 0 : tipoDespesa.hashCode());
        result = prime * result + ((valorDespesa == null) ? 0 : valorDespesa.hashCode());
        result = prime * result + ((dataDespesaAdicionada == null) ? 0 : dataDespesaAdicionada.hashCode());
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
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
        Despesa other = (Despesa) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (tipoDespesa != other.tipoDespesa)
            return false;
        if (valorDespesa == null) {
            if (other.valorDespesa != null)
                return false;
        } else if (!valorDespesa.equals(other.valorDespesa))
            return false;
        if (dataDespesaAdicionada == null) {
            if (other.dataDespesaAdicionada != null)
                return false;
        } else if (!dataDespesaAdicionada.equals(other.dataDespesaAdicionada))
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        return true;
    }

   

}

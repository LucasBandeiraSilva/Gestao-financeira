package com.gestao.financeira.projeto.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.gestao.financeira.projeto.enums.StatusInvestimento;
import com.gestao.financeira.projeto.enums.TipoInvestimento;

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
@Table(name = "tb_investimento") // se quiser mudar o nome
public class Investimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoInvestimento tipoInvestimento;
    private BigDecimal valorInicial;
    private LocalDate dataRetirada;
    private String dataInvestimento;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((tipoInvestimento == null) ? 0 : tipoInvestimento.hashCode());
        result = prime * result + ((valorInicial == null) ? 0 : valorInicial.hashCode());
        result = prime * result + ((dataRetirada == null) ? 0 : dataRetirada.hashCode());
        result = prime * result + ((dataInvestimento == null) ? 0 : dataInvestimento.hashCode());
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
        Investimento other = (Investimento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (tipoInvestimento != other.tipoInvestimento)
            return false;
        if (valorInicial == null) {
            if (other.valorInicial != null)
                return false;
        } else if (!valorInicial.equals(other.valorInicial))
            return false;
        if (dataRetirada == null) {
            if (other.dataRetirada != null)
                return false;
        } else if (!dataRetirada.equals(other.dataRetirada))
            return false;
        if (dataInvestimento == null) {
            if (other.dataInvestimento != null)
                return false;
        } else if (!dataInvestimento.equals(other.dataInvestimento))
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Investimento [id=" + id + ", tipoInvestimento=" + tipoInvestimento + ", valorInicial=" + valorInicial
                + ", dataRetirada=" + dataRetirada + ", dataInvestimento=" + dataInvestimento + ", cliente=" + cliente
                + "]";
    }

}

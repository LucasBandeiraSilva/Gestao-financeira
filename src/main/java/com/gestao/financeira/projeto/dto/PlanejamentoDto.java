package com.gestao.financeira.projeto.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.gestao.financeira.projeto.enums.TipoMeta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlanejamentoDto {
    private BigDecimal meta;
    private Boolean status;
    private String descricao;
    private TipoMeta tipoMeta;
    private LocalDateTime data_inicio;
    private LocalDateTime data_termino;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((meta == null) ? 0 : meta.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((tipoMeta == null) ? 0 : tipoMeta.hashCode());
        result = prime * result + ((data_inicio == null) ? 0 : data_inicio.hashCode());
        result = prime * result + ((data_termino == null) ? 0 : data_termino.hashCode());
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
        PlanejamentoDto other = (PlanejamentoDto) obj;
        if (meta == null) {
            if (other.meta != null)
                return false;
        } else if (!meta.equals(other.meta))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (tipoMeta != other.tipoMeta)
            return false;
        if (data_inicio == null) {
            if (other.data_inicio != null)
                return false;
        } else if (!data_inicio.equals(other.data_inicio))
            return false;
        if (data_termino == null) {
            if (other.data_termino != null)
                return false;
        } else if (!data_termino.equals(other.data_termino))
            return false;
        return true;
    }

}

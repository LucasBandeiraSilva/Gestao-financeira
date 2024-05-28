package com.gestao.financeira.projeto.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.gestao.financeira.projeto.enums.TipoPlanejamento;

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
@Table(name = "tb_planejamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Planejamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Boolean status;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private TipoPlanejamento tipoPlanejamento;
    private BigDecimal valor;
    private String dataInicio;
    private LocalDate dataTermino;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    

}

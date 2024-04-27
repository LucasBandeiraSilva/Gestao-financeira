package com.gestao.financeira.projeto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.financeira.projeto.entidades.Planejamento;

public interface PlanejamentoRepository extends JpaRepository<Planejamento, Long> {

}

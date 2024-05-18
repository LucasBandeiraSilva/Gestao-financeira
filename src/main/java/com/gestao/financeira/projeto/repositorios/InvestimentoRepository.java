package com.gestao.financeira.projeto.repositorios;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.financeira.projeto.entidades.Investimento;


public interface InvestimentoRepository extends JpaRepository<Investimento,Long> {
    Optional<Investimento> findByClienteId(Long id);
}

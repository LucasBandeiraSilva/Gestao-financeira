package com.gestao.financeira.projeto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.financeira.projeto.entidades.Despesa;

public interface DespesasRepository extends JpaRepository<Despesa,Long> {
    
}

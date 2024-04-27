package com.gestao.financeira.projeto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.financeira.projeto.entidades.Despesas;

public interface DespesasRepositoy extends JpaRepository<Despesas,Long> {
    
}

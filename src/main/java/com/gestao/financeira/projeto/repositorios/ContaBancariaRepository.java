package com.gestao.financeira.projeto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.financeira.projeto.entidades.ContaBancaria;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {
    
}

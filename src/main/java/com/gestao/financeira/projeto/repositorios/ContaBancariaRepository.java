package com.gestao.financeira.projeto.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.financeira.projeto.entidades.Cliente;
import com.gestao.financeira.projeto.entidades.ContaBancaria;


public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {
    Optional<ContaBancaria> findByClienteId(Long clienteId);
   
}

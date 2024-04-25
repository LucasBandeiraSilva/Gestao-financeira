package com.gestao.financeira.projeto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.financeira.projeto.entidades.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}

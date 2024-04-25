package com.gestao.financeira.projeto.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.financeira.projeto.entidades.Cliente;
import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByCpf(String cpf);
}

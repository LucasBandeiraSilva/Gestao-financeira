package com.gestao.financeira.projeto.dto;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
    @NotBlank(message = "O nome não deve ser nulo")
    private String nome;
    @NotBlank
    @Email(message = "Email invalido")
    private String email;
    @CPF(message = "CPF invalido")
    private String cpf;
    private String senha;
    private LocalDateTime data_criacao;
    private LocalDateTime data_atualizacao;
}

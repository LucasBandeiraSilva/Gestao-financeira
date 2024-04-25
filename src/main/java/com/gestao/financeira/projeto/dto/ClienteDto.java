package com.gestao.financeira.projeto.dto;

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
    String nome;
    @NotBlank
    @Email(message = "Email invalido")
    String email;
    @NotBlank(message = "O Cpf não deve ser nulo")
    @CPF(message = "CPF invalido")
    String cpf;
}

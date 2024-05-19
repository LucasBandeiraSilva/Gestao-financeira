package com.gestao.financeira.projeto.entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_cliente") // se quiser mudar o nome
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String senha;
    private LocalDateTime data_criacao;
    private LocalDateTime data_atualizacao;
    @OneToMany(mappedBy = "cliente",fetch = FetchType.EAGER)
    private List<Planejamento> planejamentos = new ArrayList<>();
    @OneToMany(mappedBy = "cliente",fetch = FetchType.EAGER)
    private List<Investimento> investimento = new ArrayList<>();
    @OneToMany(mappedBy = "cliente")
    private List<Despesas> despesas = new ArrayList<>();
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<ContaBancaria> contaBancaria = new ArrayList<>();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((senha == null) ? 0 : senha.hashCode());
        result = prime * result + ((data_criacao == null) ? 0 : data_criacao.hashCode());
        result = prime * result + ((data_atualizacao == null) ? 0 : data_atualizacao.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (senha == null) {
            if (other.senha != null)
                return false;
        } else if (!senha.equals(other.senha))
            return false;
        if (data_criacao == null) {
            if (other.data_criacao != null)
                return false;
        } else if (!data_criacao.equals(other.data_criacao))
            return false;
        if (data_atualizacao == null) {
            if (other.data_atualizacao != null)
                return false;
        } else if (!data_atualizacao.equals(other.data_atualizacao))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", senha=" + senha
                + ", data_criacao=" + data_criacao + ", data_atualizacao=" + data_atualizacao + ", planejamentos="
                + planejamentos + ", investimento=" + investimento + ", despesas=" + despesas + ", contaBancaria="
                + contaBancaria + "]";
    }

    

}

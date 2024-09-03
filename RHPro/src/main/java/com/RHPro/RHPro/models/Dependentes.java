package com.RHPro.RHPro.models;


import jakarta.persistence.*;

@Entity
public class Dependentes {



    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String cpf;

    private String nome;
    private String dataNascimento;

    @ManyToOne
    private Funcionario funcionario;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}

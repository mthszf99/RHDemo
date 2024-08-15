package com.RHDemo.RHDemo.models;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import jakarta.validation.constraints.NotEmpty;

@Entity
public class Vaga implements Serializable {

    private static final long serialversionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String descricao;

    @NotEmpty
    private String data;

    @NotEmpty
    private String salario;

    //excluir todos os candidatos quando excluir a vaga
    @OneToMany (mappedBy = "vaga", cascade = CascadeType.REMOVE)
    private List <Candidato> candidatos;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public @NotEmpty String getNome() {
        return nome;
    }

    public void setNome(@NotEmpty String nome) {
        this.nome = nome;
    }

    public @NotEmpty String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotEmpty String descricao) {
        this.descricao = descricao;
    }

    public @NotEmpty String getData() {
        return data;
    }

    public void setData(@NotEmpty String data) {
        this.data = data;
    }

    public @NotEmpty String getSalario() {
        return salario;
    }

    public void setSalario(@NotEmpty String salario) {
        this.salario = salario;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }
}

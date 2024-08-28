package com.RHPro.RHPro.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Candidato {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //para não haver rg repetido
    @Column(unique = true)
    private String rg;

    @NotEmpty
    private String nomeCandidato;

    @NotEmpty
    private String email;

    //muitos candidatos pra uma vaga
    @ManyToOne
    private Vaga vaga;

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public @NotEmpty String getNomeCandidato() {
        return nomeCandidato;
    }

    public void setNomeCandidato(@NotEmpty String nomeCandidato) {
        this.nomeCandidato = nomeCandidato;
    }

    public @NotEmpty String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty String email) {
        this.email = email;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
}

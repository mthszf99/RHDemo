package com.RHDemo.RHDemo.repository;

import com.RHDemo.RHDemo.models.Candidato;
import org.springframework.data.repository.CrudRepository;
import com.RHDemo.RHDemo.models.Vaga;

import java.util.List;

public interface CandidatoRepository extends CrudRepository<Candidato, String> {

    Iterable<Candidato>findByVaga(Vaga vaga);

    Candidato findByRg(String rg);

    Candidato findById(long id);

    List<Candidato>findByNomeCandidato(String nomeCandidato);
}

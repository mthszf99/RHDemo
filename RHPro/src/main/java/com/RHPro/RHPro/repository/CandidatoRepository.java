package com.RHPro.RHPro.repository;

import com.RHPro.RHPro.models.Candidato;
import com.RHPro.RHPro.models.Vaga;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CandidatoRepository extends CrudRepository<Candidato, String> {

    Iterable<Candidato>findByVaga(Vaga vaga);

    Candidato findByRg(String rg);

    Candidato findById(long id);

    List<Candidato>findByNomeCandidato(String nomeCandidato);
}

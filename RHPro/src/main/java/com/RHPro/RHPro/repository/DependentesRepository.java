package com.RHPro.RHPro.repository;

import com.RHPro.RHPro.models.Dependentes;
import com.RHPro.RHPro.models.Funcionario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DependentesRepository extends CrudRepository<Dependentes, String> {

    Iterable<Dependentes> findByFuncionario(Funcionario funcionario);

    Dependentes findByCpf(String cpf);
    Dependentes findById(long id);

    List<Dependentes> findByNome(String nome);
}

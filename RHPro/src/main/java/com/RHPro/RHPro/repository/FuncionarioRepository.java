package com.RHPro.RHPro.repository;

import com.RHPro.RHPro.models.Funcionario;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, String> {

    Funcionario findById(long id);

    //busca por nome
    Funcionario findByNome(String nome);
}

package br.com.fatec.frete.repository;

import br.com.fatec.frete.entity.Frete;

import java.util.List;

public interface FreteRepository {
    Frete save(Frete frete);

    Frete findById(String id);

    List<Frete> findByIdUser(String idUser);
}

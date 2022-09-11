package br.com.tcs.exerciciossb.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.tcs.exerciciossb.model.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    
}


package com.miniblog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miniblog.models.PersonaModel;

@Repository
public interface  PersonaRepository extends CrudRepository<PersonaModel, Long>{
}

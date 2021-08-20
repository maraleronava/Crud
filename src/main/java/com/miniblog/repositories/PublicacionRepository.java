package com.miniblog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miniblog.models.PublicacionModel;

@Repository
public interface PublicacionRepository extends CrudRepository<PublicacionModel, Long>{

}

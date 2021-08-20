package com.miniblog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.miniblog.models.UsuarioModel;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{

}

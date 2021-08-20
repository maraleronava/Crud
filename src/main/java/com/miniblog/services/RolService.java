package com.miniblog.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniblog.models.RolModel;
import com.miniblog.repositories.RolRepository;

@Service
public class RolService {
	@Autowired
	RolRepository rolRepository;
	public ArrayList<RolModel> obtenerRoles(){
		return (ArrayList<RolModel>) rolRepository.findAll();
	}
	public RolModel guardarRol(RolModel rol) {
		return rolRepository.save(rol);
	}
	public Optional<RolModel> obtenerRol(Long id){
		return rolRepository.findById(id);
	}
	public boolean eliminarRol(Long id) {
		try {
			rolRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}

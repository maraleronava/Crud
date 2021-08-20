package com.miniblog.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniblog.models.PersonaModel;
import com.miniblog.repositories.PersonaRepository;

@Service
public class PersonaService {
	@Autowired
	PersonaRepository personaRepository;
	public ArrayList<PersonaModel> obtenerPersonas(){
		return (ArrayList<PersonaModel>) personaRepository.findAll();
	}
	public PersonaModel guardarPersona(PersonaModel usuario) {
		return personaRepository.save(usuario);
	}
	public Optional<PersonaModel> obtenerPersona(Long id){
		return personaRepository.findById(id);
	}
	public boolean eliminarPersona(Long id) {
		try {
			personaRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
}

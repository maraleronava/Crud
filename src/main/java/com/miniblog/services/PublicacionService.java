package com.miniblog.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniblog.models.PublicacionModel;
import com.miniblog.repositories.PublicacionRepository;

@Service
public class PublicacionService {
	@Autowired
	PublicacionRepository publicacionRepository;
	public ArrayList<PublicacionModel> obtenerPublicaciones(){
		return (ArrayList<PublicacionModel>) publicacionRepository.findAll();
	}
	public PublicacionModel guardarPublicacion(PublicacionModel publicacion) {
		return publicacionRepository.save(publicacion);
	}
	public Optional<PublicacionModel> obtenerPublicacion(Long id){
		return publicacionRepository.findById(id);
	}
	public boolean eliminarPublicacion(Long id) {
		try {
			publicacionRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}

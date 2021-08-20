package com.miniblog.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniblog.models.UsuarioModel;
import com.miniblog.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioReposity;
	public ArrayList<UsuarioModel> obtenerUsuarios(){
		return (ArrayList<UsuarioModel>) usuarioReposity.findAll();
	}
	public UsuarioModel guardarUsuario(UsuarioModel rol) {
		return usuarioReposity.save(rol);
	}
	public Optional<UsuarioModel> obtenerUsuario(Long id){
		return usuarioReposity.findById(id);
	}
	public boolean EliminarUsuario(Long id) {
		try {
			usuarioReposity.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}

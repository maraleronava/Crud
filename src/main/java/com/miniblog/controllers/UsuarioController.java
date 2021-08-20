package com.miniblog.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniblog.models.UsuarioModel;
import com.miniblog.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	@GetMapping()
	public ArrayList<UsuarioModel> obtenerPersonas(){
		return usuarioService.obtenerUsuarios();
	}
	@PostMapping()
	public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
		return this.usuarioService.guardarUsuario(usuario);
	}
	@GetMapping(path = "/{id}")
	public Optional<UsuarioModel> obtenerRol(@PathVariable("id") Long id){
		return this.usuarioService.obtenerUsuario(id);
	}
	@DeleteMapping("/{id}")
	public String eliminarUsuario(@PathVariable("id") Long id) {
			boolean ok = this.usuarioService.EliminarUsuario(id);
			if(ok) {
				return "Usuario Eliminado Correctamente";
			}
			else {
				return "Error al eliminar este Usuario";
			}
	}

}

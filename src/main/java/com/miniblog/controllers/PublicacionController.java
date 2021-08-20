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

import com.miniblog.models.PublicacionModel;
import com.miniblog.services.PublicacionService;

@RestController
@RequestMapping("/publicacion")
public class PublicacionController {
	@Autowired
	PublicacionService publicacionService;
	@GetMapping()
	public ArrayList<PublicacionModel> obtenerPublicaciones(){
		return publicacionService.obtenerPublicaciones();
	}
	@PostMapping()
	public PublicacionModel guardarPublicacion(@RequestBody PublicacionModel publicacion) {
		return this.publicacionService.guardarPublicacion(publicacion);
	}
	@GetMapping(path = "/{id}")
	public Optional<PublicacionModel> obtenerPublicacion(@PathVariable("id") Long id){
		return this.publicacionService.obtenerPublicacion(id);
	}
	@DeleteMapping("/{id}")
	public String eliminarPublicaciones(@PathVariable("id") Long id) {
			boolean ok = this.publicacionService.eliminarPublicacion(id);
			if(ok) {
				return "Publicación Eliminada Correctamente";
			}
			else {
				return "Error al eliminar esta publicación";
			}
	}

}

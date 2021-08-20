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

import com.miniblog.models.PersonaModel;
import com.miniblog.services.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	@Autowired
	PersonaService personaService;
	@GetMapping()
	public ArrayList<PersonaModel> obtenerPersonas(){
		return personaService.obtenerPersonas();
	}
	@PostMapping()
	public PersonaModel guardarPersona(@RequestBody PersonaModel usuario) {
		return this.personaService.guardarPersona(usuario);
	}
	@GetMapping(path = "/{id}")
	public Optional<PersonaModel> obtenerPersona(@PathVariable("id") Long id){
		return this.personaService.obtenerPersona(id);
	}
	@DeleteMapping("/{id}")
	public String eliminarPersona(@PathVariable("id") Long id) {
			boolean ok = this.personaService.eliminarPersona(id);
			if(ok) {
				return "Persona Eliminada Correctamente";
			}
			else {
				return "Error al eliminar a esta persona";
			}
	}
	

}

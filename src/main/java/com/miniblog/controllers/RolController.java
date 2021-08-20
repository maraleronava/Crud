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

import com.miniblog.models.RolModel;
import com.miniblog.services.RolService;

@RestController
@RequestMapping("/rol")
public class RolController {
	@Autowired
	RolService rolService;
	@GetMapping()
	public ArrayList<RolModel> obtenerPersonas(){
		return rolService.obtenerRoles();
	}
	@PostMapping()
	public RolModel guardarUsuario(@RequestBody RolModel rol) {
		return this.rolService.guardarRol(rol);
	}
	@GetMapping(path = "/{id}")
	public Optional<RolModel> obtenerRol(@PathVariable("id") Long id){
		return this.rolService.obtenerRol(id);
	}
	@DeleteMapping("/{id}")
	public String eliminaRol(@PathVariable("id") Long id) {
			boolean ok = this.rolService.eliminarRol(id);
			if(ok) {
				return "Rol Eliminado Correctamente";
			}
			else {
				return "Error al eliminar este Rol";
			}
	}
}

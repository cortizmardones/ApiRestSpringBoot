package com.example.demo.RestControllers;

import java.util.HashMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	
	private HashMap<String,String> listaUsuarios = new HashMap<String,String>();
		
	@GetMapping("/listar")
	public HashMap<String,String> listar() {
		return listaUsuarios;
	}
	
	@PostMapping("/agregar/{usuario}/{lenguaje}")
	public String agregar(@PathVariable String usuario, @PathVariable String lenguaje) {
		
		usuario = usuario.toLowerCase().trim();
		lenguaje = lenguaje.toLowerCase().trim();
		
		if(listaUsuarios.containsKey(usuario)) {
			return "Usuario ya existe en los registros anteriores";
		} else {
			listaUsuarios.put(usuario, lenguaje);
			return "Usuario "+ usuario + " agregado";
		}
		
	}
	
	@PutMapping("/actualizar/{usuario}/{lenguaje}")
	public String actualizar(@PathVariable String usuario, @PathVariable String lenguaje) {
		
		usuario = usuario.toLowerCase().trim();
		lenguaje = lenguaje.toLowerCase().trim();
		
		if(listaUsuarios.containsKey(usuario)){
			listaUsuarios.replace(usuario, lenguaje);
			return "Usuario "+ usuario + " actualizado";
		} else {
			return "Usuario "+ usuario + " no existe dentro de los registros";
		}

	}
	
	@DeleteMapping("/eliminar/{usuario}")
	public String agregar(@PathVariable String usuario) {
		
		usuario = usuario.toLowerCase().trim();
		
		if(listaUsuarios.containsKey(usuario)) {
			listaUsuarios.remove(usuario);
			return "Usuario "+ usuario + " eliminado";
		} else {
			return "Usuario "+ usuario + " no existe dentro de los registros";
		}

	}
		
}

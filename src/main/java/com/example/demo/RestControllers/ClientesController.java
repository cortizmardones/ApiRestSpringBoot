package com.example.demo.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entity.Cliente;
import com.example.demo.model.entity.ClienteDAO;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	private ClienteDAO clienteDAO;

	@Autowired
	private Cliente cliente;
	
	//CREATE
	@PostMapping("/createClient/{nombre}/{apellido}/{profesion}/{edad}")
	public ResponseEntity<?> createClient(@PathVariable String nombre, @PathVariable String apellido, @PathVariable String profesion, @PathVariable String edad) {
		cliente.setNombre(nombre);
		cliente.setApellido(apellido);
		cliente.setProfesion(profesion);
		cliente.setEdad(Integer.parseInt(edad));
		clienteDAO.persist(cliente);
		return ResponseEntity.status(HttpStatus.OK).body("Usuario registrado exitosamente");
	}

	//READ
	@GetMapping("/readAllClients")
	public ResponseEntity<?> readAllClients() {
		return clienteDAO.findAll();
	}

	@GetMapping("/readOneClient/{id}")
	public ResponseEntity<?> readOneClient(@PathVariable String id) {
		return clienteDAO.find(Integer.parseInt(id));
	}
	
	//UPDATE
	@PutMapping("/updateClient/{id}/{nombre}/{apellido}/{profesion}/{edad}")
	public ResponseEntity<?> updateClient(@PathVariable String id, @PathVariable String nombre, @PathVariable String apellido, @PathVariable String profesion, @PathVariable String edad) {
		cliente.setId(Integer.parseInt(id));
		cliente.setNombre(nombre);
		cliente.setApellido(apellido);
		cliente.setProfesion(profesion);
		cliente.setEdad(Integer.parseInt(edad));
		return clienteDAO.merge(cliente);
	}
	
	//DELETE
	@DeleteMapping("/deleteClient/{id}")
	public ResponseEntity<?> deleteClient(@PathVariable String id) {
		return clienteDAO.Delete(Integer.parseInt(id));
	}

}

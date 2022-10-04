package com.example.demo.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("/listarClientes")
	public List<Cliente> listarClientes() {
		return clienteDAO.findAll();
	}

	@PostMapping("/agregarCliente/{nombre}/{apellido}/{profesion}/{edad}")
	public String agregarCliente(@PathVariable String nombre, @PathVariable String apellido, @PathVariable String profesion, @PathVariable String edad) {
		cliente.setNombre(nombre);
		cliente.setApellido(apellido);
		cliente.setProfesion(profesion);
		cliente.setEdad(Integer.parseInt(edad));
		clienteDAO.Save(cliente);
		return "Usuario registrado exitosamente";
	}
	
	@GetMapping("/buscarClientes/{id}")
	public Cliente buscarClientes(@PathVariable String id) {
		return clienteDAO.findOne(Integer.parseInt(id));
	}

}

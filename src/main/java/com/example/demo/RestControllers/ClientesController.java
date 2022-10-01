package com.example.demo.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entity.Cliente;
import com.example.demo.model.entity.ClienteDAO;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

	@Autowired
	private ClienteDAO clienteDAO;

	@GetMapping("/listarClientes")
	public List<Cliente> listarClientes() {
		return clienteDAO.findAll();
	}

}

package com.example.demo.ViewControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.entity.Cliente;
import com.example.demo.model.entity.ClienteDAO;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	ClienteDAO clienteDAO;
	
	@GetMapping("/home")
	public String home(Model model) {
		
		List<Cliente> listaClientes = clienteDAO.findAll();
		model.addAttribute("listaClientes", listaClientes);
		model.addAttribute("titulo", "Home Page");
		
		return "home";
	}

}


//@RequestMapping(value = "/home" , method = RequestMethod.GET)
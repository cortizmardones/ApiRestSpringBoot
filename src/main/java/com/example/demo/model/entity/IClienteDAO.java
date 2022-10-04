package com.example.demo.model.entity;

import java.util.List;

public interface IClienteDAO {
	
	public List<Cliente> findAll();
	
	public void Save(Cliente cliente);
	
	public Cliente findOne(int id); 

}

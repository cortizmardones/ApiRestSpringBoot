package com.example.demo.model.entity;

import java.util.List;

public interface IClienteDAO {

	//CREATE
	public void Save(Cliente cliente);
	
	//READ
	public List<Cliente> findAll();
	public Cliente findOne(int id);
	
	//UPDATE
	public String Update(Cliente cliente);
	
	//DELETE
	public String Delete(int id);

}

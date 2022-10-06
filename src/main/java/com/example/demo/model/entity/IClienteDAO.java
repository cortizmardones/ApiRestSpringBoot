package com.example.demo.model.entity;

import org.springframework.http.ResponseEntity;

public interface IClienteDAO {

	//CREATE
	public void persist(Cliente cliente);
	
	//READ
	public ResponseEntity<?> findAll();
	public ResponseEntity<?> find(int id);
	
	//UPDATE
	public ResponseEntity<?> merge(Cliente cliente);
	
	//DELETE
	public ResponseEntity<?> Delete(int id);

}

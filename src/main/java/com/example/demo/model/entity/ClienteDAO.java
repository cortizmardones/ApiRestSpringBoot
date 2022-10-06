package com.example.demo.model.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ClienteDAO implements IClienteDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	Cliente cliente;
	
	//CREATE
	@Override
	@Transactional
	public void persist(Cliente cliente) {
		entityManager.persist(cliente);
	}

	//READ
	@Transactional(readOnly = true)
	@Override
	public ResponseEntity<?> findAll() {
		String query = "SELECT a FROM Cliente a ORDER BY id ASC"; 
		return ResponseEntity.status(HttpStatus.OK).body(entityManager.createQuery(query).getResultList());
	}
	
	@Override
	@Transactional
	public ResponseEntity<?> find(int id) {
		return ResponseEntity.status(HttpStatus.OK).body(entityManager.find(Cliente.class, id));
	}
	
	//UPDATE
	@Override
	@Transactional
	public ResponseEntity<?> merge(Cliente cliente) {
		Cliente clienteOld = entityManager.find(Cliente.class, cliente.getId());
		if(clienteOld != null) {
			entityManager.merge(cliente);
			return ResponseEntity.status(HttpStatus.OK).body("Usuario actualizado exitosamente");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado en bdd");
		}
	}
	
	//DELETE
	@Override
	@Transactional
	public ResponseEntity<?> Delete(int id) {
		cliente = entityManager.find(Cliente.class, id);
		if(cliente != null) {
			entityManager.remove(cliente);
			return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado exitosamente");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado en bdd");
		}
	}



}

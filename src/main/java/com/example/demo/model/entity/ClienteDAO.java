package com.example.demo.model.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
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
	public void Save(Cliente cliente) {
		entityManager.persist(cliente);
	}

	//READ
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() {
		String query = "SELECT a FROM Cliente a ORDER BY id ASC";  
		return entityManager.createQuery(query).getResultList();
	}
	
	@Override
	@Transactional
	public Cliente findOne(int id) {
		return entityManager.find(Cliente.class, id);
	}
	
	//UPDATE
	@Override
	@Transactional
	public String Update(Cliente cliente) {
		Cliente clienteOld = entityManager.find(Cliente.class, cliente.getId());
		if(clienteOld != null) {
			entityManager.merge(cliente);
			return "Usuario actualizado exitosamente";
		} else {
			return "Usuario no encontrado en bdd";
		}
	}
	
	//DELETE
	@Override
	@Transactional
	public String Delete(int id) {
		cliente = entityManager.find(Cliente.class, id);
		if(cliente != null) {
			entityManager.remove(cliente);
			return "Usuario eliminado exitosamente";
		} else {
			return "Usuario no encontrado en bdd";
		}
	}



}

package com.example.demo.model.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ClienteDAO implements IClienteDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() {
		return entityManager.createQuery("from Cliente").getResultList();
	}

	@Override
	@Transactional
	public void Save(Cliente cliente) {
		entityManager.persist(cliente);
	}
	
	@Override
	@Transactional
	public Cliente findOne(int id) {
		return entityManager.find(Cliente.class, id);
	}
	
}

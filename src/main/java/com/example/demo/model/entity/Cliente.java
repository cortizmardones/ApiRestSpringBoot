package com.example.demo.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
	
	//Serializar: Convertir un objeto a una secuencia de bits
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "nombre_cliente" , nullable = false)
	private String nombre;
	
	@Column(name = "apellido_cliente" , nullable = false)
	private String apellido;
	
	@Column(name = "profesion_cliente" , nullable = false)
	private String profesion;
	
	@Column(name = "edad_cliente" , nullable = false)
	private int edad;
	
	
	public Cliente() {
	}
	
	public Cliente(int id, String nombre, String apellido, String profesion, int edad) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.profesion = profesion;
		this.edad = edad;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getProfesion() {
		return profesion;
	}
	
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
	
	
	
	
	

}

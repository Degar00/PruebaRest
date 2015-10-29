package com.ipartek.formacion.pruebarest.pojo;

public class Perro {

	private String nombre;
	private String raza;

	/**
	 * @param nombre
	 * @param raza
	 */
	public Perro(String nombre, String raza) {
		super();
		this.nombre = nombre;
		this.raza = raza;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the raza
	 */
	public String getRaza() {
		return this.raza;
	}

	/**
	 * @param raza
	 *            the raza to set
	 */
	public void setRaza(String raza) {
		this.raza = raza;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Perro [nombre=" + this.nombre + ", raza=" + this.raza + "]";
	}

}

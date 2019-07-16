package logic;

import java.util.ArrayList;

public class Dia {
	/**
	 * esta clase permite determinar cuantas jornadas y cuantas personas llegan en un solo dia de trabajo.
	 */
	
	private double jornada;
	private ArrayList<ArrayList<Cliente>> clientes;
	private int id;

	public Dia(int id) {
		super();
		this.id=id;
		this.clientes=new ArrayList<>();
		this.jornada = 10;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<ArrayList<Cliente>> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<ArrayList<Cliente>> clientes) {
		this.clientes = clientes;
	}

	public double getJornada() {
		return jornada;
	}
	
	public void setJornada(int jornada) {
		this.jornada = jornada;
	}





}


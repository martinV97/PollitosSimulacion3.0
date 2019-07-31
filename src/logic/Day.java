package logic;

import java.util.ArrayList;

public class Day {
	private double jornada;
	private ArrayList<ArrayList<Client>> clientes;
	private int id;

	public Day(int id) {
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

	public ArrayList<ArrayList<Client>> getClients() {
		return clientes;
	}

	public void setClientes(ArrayList<ArrayList<Client>> clientes) {
		this.clientes = clientes;
	}

	public double getJornada() {
		return jornada;
	}
	
	public void setJornada(int jornada) {
		this.jornada = jornada;
	}





}


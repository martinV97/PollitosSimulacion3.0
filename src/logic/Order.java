package logic;


import java.util.ArrayList;
public class Order {
	public static int id=1;
	private int idPedido;
	
	private int tiempoAtencion;
	private int prioridad; 

	private Dish fuertes;
	private Dish entradas;
	private ArrayList<Dish> postres;


	public Order(int prioridad) {
		postres= new ArrayList<>();
		this.prioridad= prioridad;
		idPedido=Order.id++;
	}

	public int getId() {
		return idPedido;
	}

	public void setIdPedido(int idpedido) {
		this.idPedido = idpedido;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public int getTiempoAtencion() {
		return tiempoAtencion;
	}



	public void setTiempoAtencion(int tiempoAtencion) {
		this.tiempoAtencion = tiempoAtencion;
	}

	public Dish getMainCourse() {
		return fuertes;
	}

	public void setFuertes(Dish fuertes) {
		this.fuertes = fuertes;
	}

	public Dish getEntrances() {
		return entradas;
	}

	public void setEntradas(Dish entradas) {
		this.entradas = entradas;
	}

	public ArrayList<Dish> getDesserts() {
		return postres;
	}

	public void setPostres(ArrayList<Dish> postres) {
		this.postres = postres;
	}
}

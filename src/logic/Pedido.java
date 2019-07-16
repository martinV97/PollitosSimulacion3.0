package logic;


import java.util.ArrayList;
/**
 * la clase pedido permite saber cuantos platos se piden en cada una de las mesas y cuales se pidieron
 * @author XIMENA
 *
 */
public class Pedido {
	public static int id=1;
	private int idPedido;
	
	private int tiempoAtencion;
	private int prioridad; 

	private Plato fuertes;
	private Plato entradas;
	private ArrayList<Plato> postres;


	public Pedido(int prioridad) {
		postres= new ArrayList<>();
		this.prioridad= prioridad;
		idPedido=Pedido.id++;
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



	public Plato getFuertes() {
		return fuertes;
	}



	public void setFuertes(Plato fuertes) {
		this.fuertes = fuertes;
	}



	public Plato getEntradas() {
		return entradas;
	}



	public void setEntradas(Plato entradas) {
		this.entradas = entradas;
	}



	public ArrayList<Plato> getPostres() {
		return postres;
	}



	public void setPostres(ArrayList<Plato> postres) {
		this.postres = postres;
	}




}

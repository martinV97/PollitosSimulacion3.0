package logic;

import java.util.ArrayList;

public class Plato {
	/**
	 * esta clase permite saber todas las caracteristicas necesarias para identifiocar unb plato
	 */
	private int id;
	private String nombre;
	private int precio;
	private double calificacion;
	private int tipo;  //entrada =1, fuerte=2, postre=3.
	private int tiempoConsumo;
	private int tiempoPreparacion;
	

	/**
	 * en el constructor solo se pedira un id y de acuerdo a este sabremos que plato se elijio
	 * @param id
	 */

	public Plato(int id, int tipo, int tiempoConsumo) {
		this.id = id;
		this.tipo=tipo;
		this.tiempoConsumo= tiempoConsumo;
		this.calificacion=0;
	nombrePlato();
	}

	/**
	 * metodo que permite saber el nombre, precio y utilidad solo con su id	
	 */
	private void nombrePlato() {
		if (tipo==1) {
			switch (id) {
			case 1:
				nombre= "Crema de champiñones";
				precio= 7000;
				tiempoPreparacion=900;
				break;
			case 2:
				nombre="Sopa de pollo";
				precio=5000;
				tiempoPreparacion=900;
				break;
			case 3:
				nombre="Crema de esparragos";
				precio=5000;			
				tiempoPreparacion=900;

				break;
			case 4:
				nombre="Ceviche de reineta";
				precio=7000;
				tiempoPreparacion=600;
				break;
			case 5:
				nombre="Ceviche de pulpo";
				precio=10000;
				tiempoPreparacion=600;
				break;
			default:
				break;
			}
		}else if(tipo==2) {
			switch (id) {
			case 1:
				nombre="Pechuga de pavo asada";
				precio= 10000;
				tiempoPreparacion=900;
				break;
			case 2:
				nombre="Muslitos de pollo agridulces";			
				precio=8000;
				tiempoPreparacion=1200;
				break;
			case 3:
				nombre="Lomo de cerdo marinado";
				precio=9500;
				tiempoPreparacion=900;
				break;
			case 4:
				nombre="Costillitas al horno";
				precio=12000;
				tiempoPreparacion=1200;
				break;
			case 5:
				nombre="Tallarines con albondigas";
				precio=8000;
				tiempoPreparacion=1200;
				break;
			default:
				break;
			}
		}else if(tipo==3) {
			switch (id) {
			case 1:
				nombre="Chesscake de fresa";
				precio= 1500;
				tiempoPreparacion=300;
				break;
			case 2:
				nombre="torta de manzana y nueces";			
				precio=1600;
				tiempoPreparacion=300;
				break;
			case 3:
				nombre="pie de almendras e higos";
				precio=2000;
				tiempoPreparacion=300;
				break;
			case 4:
				nombre="pie de frutos secos";
				precio=1500;
				tiempoPreparacion=300;
				break;
			case 5:
				nombre="Cupcake de crema de naranja";
				precio=1800;
				tiempoPreparacion=600;

				break;
			case 6:
				nombre="Alfajores de manjar";
				precio=2000;
				tiempoPreparacion=700;
				break;
			case 7:
				nombre="Corazones de guayaba";
				precio=1400;
				tiempoPreparacion=350;
				break;
			case 8:
				nombre="cake de banano";
				precio=1350;
				tiempoPreparacion=380;
				break;
			case 9:
				nombre="Tarta de macadamias y fruto0s rojos ";
				precio=1300;
				tiempoPreparacion=400;
				break;
			case 10:
				nombre="Croquetas de arroz con leche";
				precio=2000;
				tiempoPreparacion=600;
				break;
				
			default:
				break;
			}
		}
	}
	
	
	/**
	 * getters y setter de la clase plato
	 * @return
	 */

	

	public int getPrecio() {
		return precio;
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

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getTiempoConsumo() {
		return tiempoConsumo;
	}

	public void setTiempoConsumo(int tiempoConsumo) {
		this.tiempoConsumo = tiempoConsumo;
	}

	public int getTiempoPreparacion() {
		return tiempoPreparacion;
	}

	public void setTiempoPreparacion(int tiempoPreparacion) {
		this.tiempoPreparacion = tiempoPreparacion;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
}

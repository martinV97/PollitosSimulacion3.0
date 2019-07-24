package logic;

import java.util.ArrayList;

public class Dish {
	/**
	 * esta clase permite saber todas las caracteristicas necesarias para
	 * identifiocar unb plato
	 */
	private int id;
	private String nombre;
	private int precio;
	private double calificacion;
	private int tipo; // entrada =1, fuerte=2, postre=3.
	private int tiempoConsumo;
	private int tiempoPreparacion;

	public Dish(int id, int tipo, int tiempoConsumo) {
		this.id = id;
		this.tipo = tipo;
		this.tiempoConsumo = tiempoConsumo;
		this.calificacion = 0;
		setDishData();
	}

	private void setDishData() {
		if (tipo == 1) {
			switch (id) {
			case 1:
				nombre = "Papas fritas";
				precio = 7000;
				tiempoPreparacion = 900;
				break;
			case 2:
				nombre = "Papas a la francesa";
				precio = 5000;
				tiempoPreparacion = 900;
				break;
			case 3:
				nombre = "Papas criollas";
				precio = 5000;
				tiempoPreparacion = 900;

				break;
			case 4:
				nombre = "Queso apanado";
				precio = 7000;
				tiempoPreparacion = 600;
				break;
			case 5:
				nombre = "Camarones Apanados";
				precio = 10000;
				tiempoPreparacion = 600;
				break;
			default:
				break;
			}
		} else if (tipo == 2) {
			switch (id) {
			case 1:
				nombre = "Hamburguesa";
				precio = 10000;
				tiempoPreparacion = 900;
				break;
			case 2:
				nombre = "Pizza";
				precio = 8000;
				tiempoPreparacion = 1200;
				break;
			case 3:
				nombre = "Perro Caliente";
				precio = 9500;
				tiempoPreparacion = 900;
				break;
			case 4:
				nombre = "Taco";
				precio = 12000;
				tiempoPreparacion = 1200;
				break;
			case 5:
				nombre = "Burrito";
				precio = 8000;
				tiempoPreparacion = 1200;
				break;
			default:
				break;
			}
		} else if (tipo == 3) {
			switch (id) {
			case 1:
				nombre = "Torta de manzana";
				precio = 1500;
				tiempoPreparacion = 300;
				break;
			case 2:
				nombre = "Torta de fresa";
				precio = 1600;
				tiempoPreparacion = 300;
				break;
			case 3:
				nombre = "Torta de durazno";
				precio = 2000;
				tiempoPreparacion = 300;
				break;
			case 4:
				nombre = "Torta de manzana";
				precio = 1500;
				tiempoPreparacion = 300;
				break;
			case 5:
				nombre = "Torta de zanahoria";
				precio = 1800;
				tiempoPreparacion = 600;

				break;
			case 6:
				nombre = "Torta de calabaza";
				precio = 2000;
				tiempoPreparacion = 700;
				break;
			case 7:
				nombre = "Helado de fresa";
				precio = 1400;
				tiempoPreparacion = 350;
				break;
			case 8:
				nombre = "Helado de mora";
				precio = 1350;
				tiempoPreparacion = 380;
				break;
			case 9:
				nombre = "Helado de sandia";
				precio = 1300;
				tiempoPreparacion = 400;
				break;
			case 10:
				nombre = "Helado de banano";
				precio = 2000;
				tiempoPreparacion = 600;
				break;

			default:
				break;
			}
		}
	}


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

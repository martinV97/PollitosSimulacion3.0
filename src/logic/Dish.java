package logic;


public class Dish {

	private int id;
	private String name;
	private int price;
	private double score;
	private int dishType;
	private int timeOfConsumption;
	private int preparationTime;

	public Dish(int id, int tipo, int tiempoConsumo) {
		this.id = id;
		this.dishType = tipo;
		this.timeOfConsumption = tiempoConsumo;
		this.score = 0;
		setDishData();
	}

	private void setDishData() {
		if (dishType == 1) {
			switch (id) {
			case 1:
				name = "Papas fritas";
				price = 7000;
				preparationTime = 900;
				break;
			case 2:
				name = "Papas a la francesa";
				price = 5000;
				preparationTime = 900;
				break;
			case 3:
				name = "Papas criollas";
				price = 5000;
				preparationTime = 900;

				break;
			case 4:
				name = "Queso apanado";
				price = 7000;
				preparationTime = 600;
				break;
			case 5:
				name = "Camarones Apanados";
				price = 10000;
				preparationTime = 600;
				break;
			default:
				break;
			}
		} else if (dishType == 2) {
			switch (id) {
			case 1:
				name = "Hamburguesa";
				price = 10000;
				preparationTime = 900;
				break;
			case 2:
				name = "Pizza";
				price = 8000;
				preparationTime = 1200;
				break;
			case 3:
				name = "Perro Caliente";
				price = 9500;
				preparationTime = 900;
				break;
			case 4:
				name = "Taco";
				price = 12000;
				preparationTime = 1200;
				break;
			case 5:
				name = "Burrito";
				price = 8000;
				preparationTime = 1200;
				break;
			default:
				break;
			}
		} else if (dishType == 3) {
			switch (id) {
			case 1:
				name = "Torta de manzana";
				price = 1500;
				preparationTime = 300;
				break;
			case 2:
				name = "Torta de fresa";
				price = 1600;
				preparationTime = 300;
				break;
			case 3:
				name = "Torta de durazno";
				price = 2000;
				preparationTime = 300;
				break;
			case 4:
				name = "Torta de manzana";
				price = 1500;
				preparationTime = 300;
				break;
			case 5:
				name = "Torta de zanahoria";
				price = 1800;
				preparationTime = 600;

				break;
			case 6:
				name = "Torta de calabaza";
				price = 2000;
				preparationTime = 700;
				break;
			case 7:
				name = "Helado de fresa";
				price = 1400;
				preparationTime = 350;
				break;
			case 8:
				name = "Helado de mora";
				price = 1350;
				preparationTime = 380;
				break;
			case 9:
				name = "Helado de sandia";
				price = 1300;
				preparationTime = 400;
				break;
			case 10:
				name = "Helado de banano";
				price = 2000;
				preparationTime = 600;
				break;

			default:
				break;
			}
		}
	}


	public int getPrecio() {
		return price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return name;
	}

	public void setNombre(String nombre) {
		this.name = nombre;
	}

	public double getCalificacion() {
		return score;
	}

	public void setCalificacion(double calificacion) {
		this.score = calificacion;
	}

	public int getTipo() {
		return dishType;
	}

	public void setTipo(int tipo) {
		this.dishType = tipo;
	}

	public int getTiempoConsumo() {
		return timeOfConsumption;
	}

	public void setTiempoConsumo(int tiempoConsumo) {
		this.timeOfConsumption = tiempoConsumo;
	}

	public int getTiempoPreparacion() {
		return preparationTime;
	}

	public void setTiempoPreparacion(int tiempoPreparacion) {
		this.preparationTime = tiempoPreparacion;
	}

	public void setPrecio(int precio) {
		this.price = precio;
	}

}

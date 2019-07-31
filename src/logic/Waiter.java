package logic;


import model.MyQueue;

public class Waiter {
	
	private int id;
	private MyQueue<Table> listOfTables;
	private  double tips;
	private double score;
	private boolean available;


	public Waiter(int id) {
		super();
		this.id=id;
		this.listOfTables=new MyQueue<>();
		this.score =0;
		ocupado();
	}

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void ocupado() {
	if (listOfTables.size()==3) {
		available=true;
	}else
		available=false;
	}
	


	public MyQueue<Table> getTables() {
		return listOfTables;
	}



	public void setMesasAcargo(MyQueue<Table> mesasAcargo) {
		this.listOfTables = mesasAcargo;
	}

	public boolean isOcupado() {
		return available;
	}

	public void setOcupado(boolean ocupado) {
		this.available = ocupado;
	}

	public double getPropina() {
		return tips;
	}
	public void setType(double propina) {
		this.tips = propina;
	}
	public double getPromedioCalificacion() {
		return score;
	}
	public void setPromedioCalificacion(double promedioCalificacion) {
		this.score = promedioCalificacion;
	}

}

package logic;


import model.MyQueue;

public class Waiter {
	
	private int id;
	private MyQueue<Table> mesasAcargo;
	private  double propina;
	private double promedioCalificacion;
	private boolean ocupado;


	public Waiter(int id) {
		super();
		this.id=id;
		this.mesasAcargo=new MyQueue<>();
		this.promedioCalificacion =0;
		ocupado();
	}

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void ocupado() {
	if (mesasAcargo.size()==3) {
		ocupado=true;
	}else
		ocupado=false;
	}
	


	public MyQueue<Table> getMesasAcargo() {
		return mesasAcargo;
	}



	public void setMesasAcargo(MyQueue<Table> mesasAcargo) {
		this.mesasAcargo = mesasAcargo;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public double getPropina() {
		return propina;
	}
	public void setPropina(double propina) {
		this.propina = propina;
	}
	public double getPromedioCalificacion() {
		return promedioCalificacion;
	}
	public void setPromedioCalificacion(double promedioCalificacion) {
		this.promedioCalificacion = promedioCalificacion;
	}

}

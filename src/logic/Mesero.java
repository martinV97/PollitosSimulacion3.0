package logic;


import model.MyQueue;

public class Mesero {
	
	private int id;
	private MyQueue<Mesa> mesasAcargo;
	private  double propina;
	private double promedioCalificacion;
	private boolean ocupado;


	public Mesero(int id) {
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
	


	public MyQueue<Mesa> getMesasAcargo() {
		return mesasAcargo;
	}



	public void setMesasAcargo(MyQueue<Mesa> mesasAcargo) {
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

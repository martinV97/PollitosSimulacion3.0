package logic;

import model.MyQueue;

public class Caja {
	MyQueue<Cliente> pagoEfectivo; 
	MyQueue<Cliente> pagoTarjeta;
	public Caja() {
		pagoEfectivo=  new MyQueue<>();
		pagoTarjeta= new MyQueue<>();
	}

	public MyQueue<Cliente> getPagoEfectivo() {
		return pagoEfectivo;
	}
	public void setPagoEfectivo(MyQueue<Cliente> pagoEfectivo) {
		this.pagoEfectivo = pagoEfectivo;
	}
	public MyQueue<Cliente> getPagoTarjeta() {
		return pagoTarjeta;
	}
	public void setPagoTarjeta(MyQueue<Cliente> pagoTarjeta) {
		this.pagoTarjeta = pagoTarjeta;
	} 
	
	
	
}

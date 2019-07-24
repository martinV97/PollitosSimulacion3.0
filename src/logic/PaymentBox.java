package logic;

import model.MyQueue;

public class PaymentBox {
	MyQueue<Client> pagoEfectivo; 
	MyQueue<Client> pagoTarjeta;
	public PaymentBox() {
		pagoEfectivo=  new MyQueue<>();
		pagoTarjeta= new MyQueue<>();
	}

	public MyQueue<Client> getPagoEfectivo() {
		return pagoEfectivo;
	}
	public void setPagoEfectivo(MyQueue<Client> pagoEfectivo) {
		this.pagoEfectivo = pagoEfectivo;
	}
	public MyQueue<Client> getPagoTarjeta() {
		return pagoTarjeta;
	}
	public void setPagoTarjeta(MyQueue<Client> pagoTarjeta) {
		this.pagoTarjeta = pagoTarjeta;
	} 
	
	
	
}

package logic;

import model.MyQueue;

public class PaymentBox {
	MyQueue<Client> cashPay; 
	MyQueue<Client> cardPay;
	public PaymentBox() {
		cashPay=  new MyQueue<>();
		cardPay= new MyQueue<>();
	}

	public MyQueue<Client> getPagoEfectivo() {
		return cashPay;
	}
	public void setPagoEfectivo(MyQueue<Client> pagoEfectivo) {
		this.cashPay = pagoEfectivo;
	}
	public MyQueue<Client> getPagoTarjeta() {
		return cardPay;
	}
	public void setPagoTarjeta(MyQueue<Client> pagoTarjeta) {
		this.cardPay = pagoTarjeta;
	} 
	
	
	
}

package logic;

import java.util.ArrayList;

public class Client {
	private int tipoPago; //1 tarjeta, 0 efectivo
	private int cuenta;
	private Order pedidos;
	private int horaLlegada;
	
	
	public Client(Order pedidos, int horaLlegada, int tipopago) {
		super();
		this.pedidos=pedidos;
		this.horaLlegada=horaLlegada;
		this.tipoPago=tipopago;
	}

	public int getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(int tipoPago) {
		this.tipoPago = tipoPago;
	}

	public int getCuenta() {
		return cuenta;
	}

	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}

	public Order getPedidos() {
		return pedidos;
	}

	public void setPedidos(Order pedidos) {
		this.pedidos = pedidos;
	}

	public int getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(int horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	
	
	
	
	
}

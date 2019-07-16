package logic;

import java.util.ArrayList;

public class Cliente {
	private int tipoPago; //1 tarjeta, 0 efectivo
	private int cuenta;
	private Pedido pedidos;
	private int horaLlegada;
	
	
	public Cliente(Pedido pedidos, int horaLlegada, int tipopago) {
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

	public Pedido getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedido pedidos) {
		this.pedidos = pedidos;
	}

	public int getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(int horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	
	
	
	
	
}

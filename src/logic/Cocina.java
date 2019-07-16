package logic;

import model.MyQueue;

public class Cocina {
	MyQueue<Cocinero> filaCongelador;
	MyQueue<Pedido> pedidos;
	
	public Cocina() {
	pedidos= new MyQueue<>();
	filaCongelador= new MyQueue<>();
	
	}
	
	public MyQueue<Cocinero> getFilaCongelador() {
		return filaCongelador;
	}

	public void setFilaCongelador(MyQueue<Cocinero> filaCongelador) {
		this.filaCongelador = filaCongelador;
	}


}

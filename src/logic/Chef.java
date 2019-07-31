package logic;

import model.MyQueue;

public class Chef {
	private int id;
	private String kind;
	MyQueue<Dish> dishes; 


	public Chef(int id) {
		this.id=id;
		this.kind=seleccionarHabilidades();
		dishes= new MyQueue<>();
	}




	private String seleccionarHabilidades() {
		if (id==1) {
			return "postres";
		}else {
			return "entradas";
		}

	}




}
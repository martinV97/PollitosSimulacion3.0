package logic;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.MyQueue;

public class Cocinero {
	private int id;
	private String habilidades;
	MyQueue<Plato> platos; 


	public Cocinero(int id) {
		this.id=id;
		this.habilidades=seleccionarHabilidades();
		platos= new MyQueue<>();
	}




	private String seleccionarHabilidades() {
		if (id==1) {
			return "postres";
		}else {
			return "entradas";
		}

	}




}
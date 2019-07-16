package test;


import logic.Restaurante;
/**
 * clase que permite realizar pruebnas sin interfaz grafica, unicamente por consola
 * @author XIMENA
 *
 */
public class Test {
	public static void main(String[] args) {
		Restaurante restaurante= new Restaurante();
		restaurante.crearMesas();
		restaurante.imprimir();
	}
}

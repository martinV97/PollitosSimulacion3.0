package logic;


public class Uniforme {

	public Uniforme() {
		super();
	}
	
	/**
	 * metodo que permite generar numeros pseudoaleatorios con distribucion uniforme.
	 * @param a
	 * @param b
	 * @return
	 */
	public double pseudoaleatorios( Double a, Double b) {
		double pseudoaleatorio=a+(b-a)*Math.random()*1;
		return pseudoaleatorio;
	}
}







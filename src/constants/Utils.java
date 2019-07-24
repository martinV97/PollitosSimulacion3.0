package constants;


public class Utils {

	public Utils() {
		super();
	}
	
	/**
	 * Metodo que genera n[umeros pseudoaleatorios con distribucion uniforme.
	 */
	public static double getRandomNumber( Double a, Double b) {
		double pseudoaleatorio=a+(b-a)*Math.random()*1;
		return pseudoaleatorio;
	}
}







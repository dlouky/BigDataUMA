package org.uma.mbd.mdGenetico.genetico;
import java.util.Arrays;
import java.util.Random;

public class Cromosoma {
	/**
	 * Datos de un cromosoma, cada posición del array representa un gen del
	 * cromosoma.
	 */
	protected int[] datos;

	/**
	 * Variable de clase de tipo Random.
	 */
	protected static Random gna = new Random(100);

	/**
	 * Valor por defecto 0 para los genes.
	 */
	protected static int GEN_POR_DEFECTO = 0;

	/**
	 * Constructor de la clase Cromosoma
	 * 
	 * @param longitud
	 *            Número de genes que tiene el cromosoma.
	 * @param aleatorio
	 *            Valor booleano que indica si debe asignar de forma aleatoria
	 *            un valor 0 o 1 a cada gen, o inicializarlos con el valor por
	 *            defecto. Si true se asigna aleatoriamente.
	 * @throws RuntimeException
	 *             si longitud no positiva.
	 */
	public Cromosoma(int longitud, boolean aleatorio) {
		if(longitud <= 0) {
			throw new IllegalArgumentException("Longitud de cromosoma errónea: debe ser mayor a cero.");
		}
		datos = new int[longitud];
		for(int i= 0; i < longitud; i++) {
			datos[i] = aleatorio ? gna.nextInt(2) : GEN_POR_DEFECTO; //gna.nextInt(2) genera aleatoriamente 0 o 1. Es lo mismo que ( gna.nextBoolean() ? 1 : 0 )
		}
	}

	/**
	 * Consulta el gen en la posición indicada.
	 * 
	 * @param i
	 *            índice del gen que se consulta.
	 * @return Valor del gen en la posición indicada.
	 * @throws RuntimeException
	 *             si el índice está fuera del rango de valores válidos.
	 */
	public int gen(int i) {
		if(i<0 || i >= datos.length) {
			throw new IndexOutOfBoundsException("Indice de gen erróneo: debe ser entre 0 y la longitud del cromosoma.");
		}
		return datos[i];
	}

	/**
	 * Modifica el i-ésimo gen del cromosoma.
	 * 
	 * @param i
	 *            índice del gen a modificar.
	 * @param val
	 *            Nuevo valor para el gen.
	 * @throws RuntimeException
	 *             si i está fuera del rango de valores válidos o si val no es
	 *             un valor válido.
	 */
	public void gen(int i, int val) {
		if(i<0 || i >= datos.length) {
			throw new IndexOutOfBoundsException("Indice erróneo: debe ser entre 0 y la longitud del cromosoma.");
		}
		if(val != 0 && val != 1) {
			throw new IllegalArgumentException("Valor de gen erróneo: debe ser 0 o 1");
		}
		datos[i] = val;
	}

	/**
	 * Invierte los valores de los genes aleatoriamente.
	 * 
	 * @param probMutacion
	 *            Probabilidad de mutacion de cada gen.
	 * @throws RuntimeException
	 *             si la probabilidad indicada no es un valor válido.
	 */
	public void mutar(double probMutacion) {
		if(probMutacion < 0 || probMutacion > 1) {
			throw new IllegalArgumentException("Error en probabilidad de mutación: debe ser entre 0 y 1 inclusives.");
		}
		for(int i = 0; i < datos.length; i++) {
			datos[i] = (gna.nextDouble() < probMutacion) ? ( (datos[i] == 1) ? 0 : 1 ) : datos[i]; //gna.nextDouble() es un double aleatorio en el conjunto [0;1)
		}
	}

	/**
	 * Longitud del cromosoma.
	 * 
	 * @return int Longitud del cromosoma.
	 */
	public int longitud() {
		return datos.length;
	}

	/**
	 * Realiza una copia en profundidad del cromosoma.
	 * 
	 * @return Un objeto Cromosoma copia del objeto que recibe el mensaje.
	 */
	public Cromosoma copia() {
		Cromosoma c = new Cromosoma(this.longitud(), false);
		for(int i = 0; i < c.longitud(); i++) {
			c.gen(i, this.gen(i));
		}
		return c;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < datos.length - 1; i++) {
			s.append(datos[i]).append(", ");
		}
		return "Cromosoma(" + s + datos[datos.length - 1] + ")";
	}
}

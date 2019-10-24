package org.uma.mbd.mdGenetico.genetico;

public interface Problema {
	/**
	 * Devuelve el valor de fitness asociado a un cromosoma en el problema que
	 * representa.
	 * 
	 * @param cromosoma
	 *            Cromosoma para el que evaluar la aptitud.
	 * @return Valor que representa el fitness del cromosoma.
	 */
	double evalua(Cromosoma cromosoma);
}

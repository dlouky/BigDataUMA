package org.uma.mbd.mdGenetico.genetico;

public class Poblacion {
	private Individuo[] individuos;

	/**
	 * 
	 * @param tamaño
	 *            Número de individuos de la población.
	 * @param longitud
	 *            Tamaño de los cromosomas de los individuos de la población.
	 * @param problema
	 *            Problema a resolver.
	 * @throws RuntimeException
	 *             si el tamaño de la población o la longitud de los cromosomas
	 *             indicados no son válidos.
	 */
	public Poblacion(int tamaño, int longitud, Problema problema) {
		if(tamaño <= 0) {
			throw new IllegalArgumentException("Tamaño de población no válido: debe ser mayor a 0.");
		}
		individuos = new Individuo[tamaño];
		for(int i = 0; i < individuos.length; i++) {
			individuos[i] = new Individuo(longitud, problema); //la Exception de longitud se lanza en clase Cromosoma y la de problema en clase Individuo
		}
	}

	/**
	 * Devuelve el número de individuos.
	 * 
	 * @return Número de individuos en la población.
	 */
	public int numIndividuos() {
		return individuos.length;
	}

	/**
	 * Devuelve el individuo con fitness mayor de la población.
	 * 
	 * @return Individuo con mejor fitness.
	 */
	public Individuo mejorIndividuo() {
		Individuo mejor = individuos[0];
		for(int i = 1; i < individuos.length; i++) {//busco la posición donde se encuentra el mejor individuo de la población (el de mayor fitness)
			mejor = ( individuos[i].fitness() > mejor.fitness() ) ? individuos[i] : mejor;
		}
		return mejor;
	}

	/**
	 * Devuelve el i-ésimo individuo de la población.
	 * 
	 * @param i
	 *            Posición del individuo a devolver.
	 * @return Individuo en la posición i.
	 * @throws RuntimeException
	 *             si el índice está fuera del rango de valores válidos.
	 */
	public Individuo individuo(int i) {
		if(i<0 || i >= individuos.length) {
			throw new IndexOutOfBoundsException("Indice de individuo erróneo en población: debe ser entre 0 y la cantidad de individuos.");
		}
		return individuos[i];
	}

	/**
	 * Si el individuo que se pasa como argumento tienen mejor fitness que el
	 * peor de los individuos de la población, entonces el peor es sustituido
	 * por el que se pasa.
	 * 
	 * @param ind
	 *            Individuo con el que se sustituye el peor de los individuos si
	 *            este es mejor.
	 */
	public void reemplaza(Individuo ind) {
		if(ind == null) {
			throw new NullPointerException("Error en asignación del individuo a reemplazar en población.");
		}
		int pos=0;
		double minFit = individuos[0].fitness();
		for(int i = 1; i < individuos.length; i++){ //busco la posición donde se encuentra el peor individuo de la población (el de menor fitness)
			if(individuos[i].fitness() < minFit) {
				minFit = individuos[i].fitness();
				pos = i;
			}
		}
		individuos[pos] = ( ind.fitness() > individuos[pos].fitness() ) ? ind : individuos[pos]; //reemplazo al peor individuo si su fitness es menor que el de ind
	}
}

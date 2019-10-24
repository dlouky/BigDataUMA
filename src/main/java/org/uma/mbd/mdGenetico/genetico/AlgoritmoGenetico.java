package org.uma.mbd.mdGenetico.genetico;

public abstract class AlgoritmoGenetico {
	/**
	 * Población de soluciones tentativas.
	 */
	private Poblacion poblacion;

	/**
	 * Problema a resolver.
	 */
	private Problema problema;

	/**
	 * Número de pasos que debe realizar.
	 */
	private int pasos;

	/**
	 * Probabilidad de mutación de los genes de los individuos.
	 */
	private double probMutacion;

	/**
	 * 
	 * @param tPoblacion
	 *            Tamaño de la población que va a utilizar.
	 * @param longCromosoma
	 *            Longitud de los cromosomas de los individuos de dicha
	 *            población.
	 * @param pasos
	 *            Número de pasos del algoritmo (generaciones).
	 * @param probMutacion
	 *            Probabilidad de mutar un gen en el cromosoma.
	 * @param problema
	 *            Problema que se debe resolver.
	 */
	public AlgoritmoGenetico(int tPoblacion, int longCromosoma, int pasos,
			double probMutacion, Problema problema) {
		if(pasos <= 0) {
			throw new IllegalArgumentException("Número de pasos (generaciones) erróneo: debe ser mayor que cero.");
		}
		if(problema == null) {
			throw new NullPointerException("Mal asignado el método de cálculo del Fitness (interface Problema).");
		}
		this.poblacion = new Poblacion(tPoblacion, longCromosoma, problema); //la Exception de tPoblacion se lanza desde Poblacion, la de longCromosoma desde Cromosoma y la de problema desde Individuo
		this.pasos = pasos;
		this.probMutacion = probMutacion; //la Exception de probMutacion se lanza desde Cromosoma
		this.problema = problema;
	}

	/**
	 * Ejecuta la secuencia siguiente tantas veces como indique el número de
	 * pasos: seleccionar dos individuos de la población aleatoriamente, tomar
	 * sus cromosomas y recombinarlos usando el método abstracto recombinar(),
	 * mutar el resultado y, por último, crear un individuo con el cromosoma
	 * resultante que insertará en la población reemplazando al peor individuo
	 * siempre y cuando sea mejor que éste.
	 * 
	 * @return Mejor individuo de la población después de la terminación del
	 *         bucle.
	 */
	public Individuo ejecuta() {
		for (int i = 0; i < pasos; i++) {
			// Nos aseguramos de coger dos individuos distintos
			int a1 = Cromosoma.gna.nextInt(poblacion.numIndividuos()); //numero aleatorio entre 0 y numIndividuos();
			int a2;
			do {
				a2 = Cromosoma.gna.nextInt(poblacion.numIndividuos()); //numero aleatorio entre 0 y numIndividuos() distinto a a1;
			} while (a1 == a2);
			// Seguro que a1 es distinto de a2
			Cromosoma cHijo = recombinar(poblacion.individuo(a1).cromosoma(), poblacion.individuo(a2).cromosoma());
			cHijo.mutar(probMutacion);
			Individuo hijo = new Individuo(cHijo, problema);
			poblacion.reemplaza(hijo);
 		}
		return poblacion.mejorIndividuo();
	}

	/**
	 * Recombina los cromosomas pasados como argumento generando un tercer
	 * cromosoma.
	 * 
	 * Dado que el método es protected suponemos que siempre se llama con dos
	 * cromosomas de la misma longitud.
	 * 
	 * @param cromosoma1
	 *            Uno de los cromosoma a recombinar.
	 * @param cromosoma2
	 *            Uno de los cromosoma a recombinar.
	 * @return
	 * 			El cromosoma resultante de la recombinación
	 */
	protected abstract Cromosoma recombinar(Cromosoma cromosoma1,
											Cromosoma cromosoma2);
}


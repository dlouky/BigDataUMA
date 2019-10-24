package org.uma.mbd.mdGenetico.genetico;

public class AGUniforme extends AlgoritmoGenetico {

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
	public AGUniforme(int tPoblacion, int longCromosoma, int pasos,
			double probMutacion, Problema problema) {
		super(tPoblacion, longCromosoma, pasos, probMutacion, problema);
	}

	/**
	 * @see AlgoritmoGenetico#recombinar(Cromosoma, Cromosoma)
	 */
	@Override
	protected Cromosoma recombinar(Cromosoma cromosoma1, Cromosoma cromosoma2) { //Dado que el método recombinar es protected suponemos que siempre se llama con dos cromosomas de la misma longitud.
		Cromosoma cHijo = new Cromosoma(cromosoma1.longitud(), false); //cromosoma1.longitud() = cromosoma2.longitud() por lo dicho arriba
		for(int i = 0; i < cromosoma1.longitud(); i++){
			cHijo.gen(i, Cromosoma.gna.nextBoolean() ? cromosoma1.gen(i) : cromosoma2.gen(i) ); //se copia aleatoriamente los genes de cromosoma1 o cromosoma2
		}
		return cHijo;
	}

}

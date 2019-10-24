package org.uma.mbd.mdGenetico.genetico;

public class CeroMax implements Problema {

    /**
     * El fitness de un individuo es el número de ceros que tiene el cromosoma.
     * @see Problema#evalua(Cromosoma)
     */
    public double evalua(Cromosoma cromosoma) {
        if(cromosoma == null) {
            throw new NullPointerException("Error en asignación del cromosoma al problema CeroMax.");
        }
        int ceros = 0;
        for(int i= 0; i < cromosoma.longitud(); i++) {
            if(cromosoma.gen(i) == 0) {
                ceros++;
            }
        }
        return ceros;
    }
}

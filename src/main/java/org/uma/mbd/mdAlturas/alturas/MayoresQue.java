package org.uma.mbd.mdAlturas.alturas;

public class MayoresQue implements Seleccion {
    double alturaMin;

    public MayoresQue(double alturaMin) {
        this.alturaMin = alturaMin;
    }

    @Override
    public boolean test (Pais pais) {
        return pais.altura >= alturaMin;
    }
}

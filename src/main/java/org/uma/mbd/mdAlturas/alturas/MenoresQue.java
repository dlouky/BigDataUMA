package org.uma.mbd.mdAlturas.alturas;

public class MenoresQue implements Seleccion{
    double alturaMax;

    public MenoresQue(double alturaMax) {
        this.alturaMax = alturaMax;
    }

    @Override
    public boolean test (Pais pais) {
        return pais.altura < alturaMax;
    }

}

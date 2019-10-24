package org.uma.mbd.mdJarrasMezcla.jarrasMezcla;

public class JarraMezcla extends Jarra {
    double pureza;
    private static final int AGUA = 0;
    private static final int VINO = 100;

    public JarraMezcla(int capacidad) {
        super(capacidad);
        pureza = AGUA;
    }

    private double calculaPureza(int c1, double p1, int c2, double p2) {
        return (c1*p1+c2*p2)/(c1+c2);
    }

    @Override
    public void llena() { //la jarra se llena de agua
        pureza = calculaPureza(getContenido(), pureza, getCapacidad()-getContenido(), AGUA);
        super.llena();
    }

    public void llenaVino() {
        pureza = calculaPureza(getContenido(), pureza, getCapacidad()-getContenido(), VINO);
        super.llena();
    }

    public double getPureza() {
        return pureza;
    }

    @Override
    public void llenaDesde(Jarra jarra) {
        int agregado = Math.min(jarra.getContenido(), getCapacidad()-getContenido());
        pureza = calculaPureza(getContenido(), pureza, agregado, AGUA);
        super.llenaDesde(jarra); //si no llamo desde super se llama a si misma.
    }

    public void llenaDesde(JarraMezcla jarraM) {
        int agregado = Math.min(jarraM.getContenido(), getCapacidad()-getContenido());
        pureza = calculaPureza(getContenido(), pureza, agregado, jarraM.pureza);
        super.llenaDesde(jarraM); //si no llamo desde super se llama a si misma.
    }


    @Override
    public String toString() {
        return "J(" + getCapacidad() + ", " + getContenido() + ", " + pureza + ")";
    }
}

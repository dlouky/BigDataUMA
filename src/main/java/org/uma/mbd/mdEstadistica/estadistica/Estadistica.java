package org.uma.mbd.mdEstadistica.estadistica;

public class Estadistica {
    private int numElementos;
    private double sumaX;
    private double sumaX2;

    public void agrega(double d) {
        agrega(d,1);
    }

    public void agrega(double d, int n) {
        numElementos += n;
        sumaX += n*d;
        sumaX2 += n*d*d;
    }

    public double media() {
        return sumaX/numElementos;
    }

    public double varianza() {
        return sumaX2/numElementos - Math.pow(media(), 2);
    }

    public double desviacionTipica() {
        return Math.sqrt(varianza());
    }

}

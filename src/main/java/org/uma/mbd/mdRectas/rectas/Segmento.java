package org.uma.mbd.mdRectas.rectas;

public class Segmento {
    private Punto origen;
    private Punto extremo;

    public Segmento(double x1, double y1, double x2, double y2) {
        this(new Punto(x1,y1), new Punto(x2,y2)) ;
    }

    public Segmento(Punto origen, Punto extremo) {
        this.origen = origen;
        this.extremo = extremo;
    }

    public void trasladar(double x, double y) {
        origen.trasladar(x, y);
        extremo.trasladar(x, y);
    }

    public double longitud() {
        return origen.distancia(extremo);
    }

    @Override
    public String toString() {
        return "S( " + origen + ", " + extremo + " )";
    }
}

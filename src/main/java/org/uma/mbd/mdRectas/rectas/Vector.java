package org.uma.mbd.mdRectas.rectas;

public class Vector {
    private Punto extremo;

    public Vector(double x, double y) {
        extremo = new Punto(x, y);
    }

    public Vector(Punto extremo) {
        this.extremo = extremo;
    }

    public Vector(Punto origen, Punto extremo) {
        this.extremo = new Punto(extremo.getX()-origen.getX(), extremo.getY() - origen.getY() );
    }

    public double getComponenteX(){
        return extremo.getX();
    }

    public double getComponenteY() {
        return extremo.getY();
    }

    public double modulo() {
        return (new Segmento(new Punto(), extremo).longitud());
        //return extremo.distancia(new Punto());
    }

    public Vector ortogonal() { //giro ortogonal AH
        return new Vector (-extremo.getY(), extremo.getX());
    }

    public boolean paraleloA(Vector vector) {
        return extremo.getX() * vector.getComponenteY() == extremo.getY() * vector.getComponenteX();
    }

    public Punto extremoDesde (Punto origen) {
        return new Punto(extremo.getX() + origen.getX(), extremo.getY() + origen.getY());
        //return new Punto(origen.getX(), origen.getY()).trasladar(extremo.getX(), extremo.getY()); no funciona porque trasladar devuelve void.

        //origen.trasladar(extremo.getX(), extremo.getY()); //Ojo porque me modifica el punto que paso como parametro y no serviría hacer return.
        //return origen;
    }

    @Override
    public String toString() {
        return "V(" + extremo.getX() + ", " + extremo.getY() + " )";
    }
}

package org.uma.mbd.mdRectas.rectas;

public class Recta {
    private Vector direccion;
    private Punto punto;

    public Recta(Vector direccion, Punto punto) {
        this.direccion = direccion;
        this.punto = punto;
    }

    public Recta(Punto p1, Punto p2) {
        this(new Vector(p1,p2), p1);
    }

    public boolean pasaPor(Punto p) {
        return (new Vector(punto, p)).paraleloA(direccion);
    }

    public boolean paralelaA(Recta recta) {
        return direccion.paraleloA(recta.direccion);
    }

    public Recta paralelaPor(Punto p) {
        return new Recta(direccion,p);
    }

    public Recta perpendicularPor(Punto p) {
        return new Recta(direccion.ortogonal(), p);
    }

    public Punto interseccionCon(Recta recta) {
        if (this.paralelaA(recta)) { //if(d==0)
            throw new RuntimeException(this + " y " + recta + "son rectas paralelas");
        }

        double vx = direccion.getComponenteX();
        double vy = direccion.getComponenteY();
        double px = punto.getX();
        double py = punto.getY();

        double ux = recta.direccion.getComponenteX();
        double uy = recta.direccion.getComponenteY();
        double qx = recta.punto.getX();
        double qy = recta.punto.getY();

        double d = vx * uy - ux * vy;
        double d1 = vx * py - vy * px;
        double d2 = ux * qy - uy * qx;

        double ox = d1 * ux - d2 * vx;
        double oy = d1 * uy - d2 * vy;
        return new Punto(ox/d, oy/d);
    }

    public double distanciaDesde(Punto p) {
        return perpendicularPor(p).interseccionCon(this).distancia(p);
    }

    @Override
    public String toString () {
        return "R( " + direccion + ", " + punto + " )";
    }

}

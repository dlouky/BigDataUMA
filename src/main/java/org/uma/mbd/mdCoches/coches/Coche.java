package org.uma.mbd.mdCoches.coches;

public class Coche {
    private String nombre;
    private double precio;
    private static double PIVA = 0.16;

    public Coche(String n, double p) {
        nombre = n;
        precio = p;
    }

    public static void setPiva(double i) {
        Coche.PIVA = i;
    }

    public double precioTotal() {
        return precio + precio * PIVA;
    }

    @Override
    public String toString() {
        return nombre + "-> " + precioTotal();
    }
}

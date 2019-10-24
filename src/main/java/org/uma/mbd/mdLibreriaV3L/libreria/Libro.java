package org.uma.mbd.mdLibreriaV3L.libreria;

public class Libro {
    private String autor;
    private String titulo;
    private double precioBase;
    private static double IVA = 10;

    public Libro(String autor, String titulo, double precioBase) {
        this.autor = autor;
        this.titulo = titulo;
        this.precioBase = precioBase;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getPrecioFinal() {
        return precioBase + precioBase*IVA/100;
    }

    public static double getIVA() {
        return IVA;
    }

    public static void setIVA(double IVA) {
        Libro.IVA = IVA;
    }

    @Override
    public String toString() {
        return "(" + autor + "; " + titulo + "; " + precioBase + "; " + IVA + "; " + getPrecioFinal() + ")";
    }
}

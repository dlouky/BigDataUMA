package org.uma.mbd.mdLibreriaV2L.libreria;

public class LibroOferta extends Libro { //Se crea un libro pero en oferta, por eso tiene descuento
    private double descuento;

    public LibroOferta(String autor, String titulo, double precioBase, double d) {
        super(autor, titulo, precioBase);
        descuento = d;
    }

    public double getDescuento() {
        return descuento;
    }

    @Override
    public double getPrecioFinal() {
        double px = getPrecioBase() - getPrecioBase()*descuento/100; //getPrecioBase() se hereda de Libro y es un método de instancia
        return px + px*getIVA()/100; //getIVA() se hereda de Libro y es un método de clase
        //return super.getPrecioFinal() - super.getPrecioFinal()*descuento/100;
    }

    @Override
    public String toString() {
        return "("  + getAutor() + "; "
                    + getTitulo() + "; "
                    + getPrecioBase() + "; "
                    + getDescuento() + "%; "
                    + (getPrecioBase() - getPrecioBase()*descuento/100) + "; "
                    + getIVA() + "%; "
                    + getPrecioFinal() + ")";
    }


}

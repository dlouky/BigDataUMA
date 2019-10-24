package org.uma.mbd.mdLibreriaV2L.libreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria { //Se crea una lista de autores en oferta (no una lista de libros).
    private String[] oferta;
    private double descuento;

    public LibreriaOferta(double descuento, String[] autores) {
        super(); //si no lo pongo funciona igual ya que al ser heredada de Libreria, llama al constructor por defecto de Libreria
        setOferta(descuento, autores);
    }

    public void setOferta(double d, String[] auOf) {
        oferta = auOf;
        descuento = d;
    }

    public String getOferta() {
        return Arrays.toString(oferta);
    }

    public double getDescuento() {
        return descuento;
    }

    //////////////////////////////////// De acá para abajo copié y pegué.... rehacer!!! ////////////////////////////

    @Override
    public void addLibro(String aut, String tit, double pb) { //se redefine la clase public de libreria
        Libro libro; //tipo estatico de libro
        if(esAutorEnOferta(aut)) {
            libro = new LibroOferta(aut,tit,pb,descuento); //tipo dinámico de libro
        } else {
            libro = new Libro(aut,tit,pb); //tipo dinámico de libro
        }
        addLibro(libro); //clase protected de Libreria
    }

    private boolean esAutorEnOferta(String a) {
        int i=0;
        while(i < oferta.length && ! a.equalsIgnoreCase(oferta[i])) {
            i++;
        }
        return i < oferta.length;
    }

    @Override
    public String toString() {
        return descuento + "%;" + Arrays.toString(oferta) + super.toString();
    }

}

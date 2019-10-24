package org.uma.mbd.mdLibreriaV3L.libreria;

import java.util.Arrays;

public class OfertaAutor implements OfertaFlex {
    private String[] autores;
    private double porDescuento;

    public OfertaAutor(double porDescuento, String[] autores) {
        this.autores = autores;
        this.porDescuento = porDescuento;
    }

    @Override
    public double getDescuento(Libro libro) {
        return esAutorEnOferta(libro.getAutor()) ? porDescuento : 0;
    }

    private boolean esAutorEnOferta(String autor) {
        int i = 0;
        while(i < autores.length && !autor.equalsIgnoreCase(autores[i])) {
            i++;
        }
        return i < autores.length;
    }

   @Override
    public String toString() {
        return porDescuento + "%" + Arrays.toString(autores) + "\n";
    }

}

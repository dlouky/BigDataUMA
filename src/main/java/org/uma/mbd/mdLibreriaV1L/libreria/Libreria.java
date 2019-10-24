package org.uma.mbd.mdLibreriaV1L.libreria;

import java.util.ArrayList;
import java.util.List;

public class Libreria {
    private List<Libro> libros;

    public Libreria() {
        libros = new ArrayList<>();
    }

    public void addLibro(String autor, String titulo, double precioBase) {
        addLibro(new Libro(autor, titulo, precioBase));
    }

    private void addLibro(Libro libroNuevo) {
        int pos = posicionLibro(libroNuevo.getAutor(), libroNuevo.getTitulo());
        if(pos < 0) {
            libros.add(libroNuevo);
        } else {
            libros.set(pos, libroNuevo);
        }
    }

    private int posicionLibro(String autor, String titulo) {
        int pos = 0;
        while (pos < libros.size() && !(autor.equalsIgnoreCase(libros.get(pos).getAutor()) && titulo.equalsIgnoreCase(libros.get(pos).getTitulo()))) {
            pos++;
        }
        return (pos == libros.size()) ? -1 : pos;
    }


    public void remLibro(String autor, String titulo) {
        int pos = posicionLibro(autor, titulo);
        libros.remove(pos);
    }

    public double getPrecioBase(String autor, String titulo) {
        int pos = posicionLibro(autor, titulo);
        return (pos >= 0) ? libros.get(pos).getPrecioBase() : 0;
    }

    public double getPrecioFinal(String autor, String titulo) {
        int pos = posicionLibro(autor, titulo);
        return (pos >= 0) ? libros.get(pos).getPrecioFinal() : 0;
    }

    @Override
    public String toString() {
        return libros.toString();
    }
}

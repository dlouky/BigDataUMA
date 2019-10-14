package org.uma.mbd.mdLibreriaV1.libreria;

import java.util.Arrays;

public class Libreria {
    private Libro[] libros;
    private int numLibros;
    private static final int TAM_DEFECTO = 16;

    public Libreria() {
        this(TAM_DEFECTO);
    }

    public Libreria(int tam) {
        libros = new Libro[tam];
        //numLibros = 0;
    }

    private void aseguraQueCabe() {
        if(numLibros == libros.length) {
            libros = Arrays.copyOf(libros, numLibros+1);//Agranda el tamaño del array para que le entre un libro más
        }
    }

    public void addLibro(String autor, String titulo, double precioBase) {
        int pos = posicionLibro(autor, titulo);
        Libro libroNuevo = new Libro(autor, titulo, precioBase);
        if(pos < 0) {
            //addLibro(libroNuevo);
            aseguraQueCabe();
            libros[numLibros] = libroNuevo;
            numLibros++;
        } else {
           libros[pos] = libroNuevo;
        }
    }

    private int posicionLibro(String autor, String titulo) {
        int pos = 0;
        while (pos < numLibros && !(autor.equalsIgnoreCase(libros[pos].getAutor()) && titulo.equalsIgnoreCase(libros[pos].getTitulo()))) {
            pos++;
        }
        return (pos == numLibros) ? -1 : pos;
    }

    /*private void addLibro(Libro libroNuevo) {
        aseguraQueCabe();
        libros[numLibros] = libroNuevo;
        numLibros++;
    }*/

    public void remLibro(String autor, String titulo) {
        int pos = posicionLibro(autor, titulo);
        if(pos >= 0) {
            for(int i = pos + 1; i < numLibros; i++) {
                libros[i-1] = libros[i];
            }

            libros[numLibros-1] = null; //borra el ultimo libro para que al correr a la izquierda no quede duplicado.
            numLibros--;
        }
    }

    public double getPrecioBase(String autor, String titulo) {
        int pos = posicionLibro(autor, titulo);
        return (pos >= 0) ? libros[pos].getPrecioBase() : 0;
    }

    public double getPrecioFinal(String autor, String titulo) {
        int pos = posicionLibro(autor, titulo);
        return (pos >= 0) ? libros[pos].getPrecioFinal() : 0;
    }

    @Override
    public String toString() {
        String salida = "[";
        for(int i = 0; i < numLibros; i++) {
            salida += libros[i];
            if(i < numLibros - 1) {
                salida += ", "; //separador entre libros, salvo que sea el ultimo libro
            }
        }
        return salida += "]";
    }
}

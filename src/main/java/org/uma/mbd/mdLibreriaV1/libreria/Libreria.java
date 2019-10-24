package org.uma.mbd.mdLibreriaV1.libreria;

import java.util.Arrays; //se usa para el Arrays.copyOf del adeguraQueCabe()
import java.util.StringJoiner;

public class Libreria {
    private Libro[] libros;
    private int numLibros; //primera posicion libre en el array libros
    private static final int TAM_DEFECTO = 16;

    public Libreria() {
        this(TAM_DEFECTO);
    }

    public Libreria(int tam) {
        libros = new Libro[tam];
        numLibros = 0; //podría obviarse ya que por defecto int inicializa en 0
    }

    public int getLength() {
        return libros.length;
    }

    private void aseguraQueCabe() {
        if(numLibros == libros.length) {
            libros = Arrays.copyOf(libros, numLibros*2); //Duplica el tamaño del array para que le entren más libros
        }
    }

    public void addLibro(String autor, String titulo, double precioBase) {
        addLibro(new Libro(autor, titulo, precioBase));
    }

    private void addLibro(Libro libroNuevo) {
        aseguraQueCabe();
        int pos = posicionLibro(libroNuevo.getAutor(), libroNuevo.getTitulo());
        if(pos < 0) {
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


    public void remLibro(String autor, String titulo) {
        int pos = posicionLibro(autor, titulo);
        if(pos >= 0) {
            for(int i = pos + 1; i < numLibros; i++) {
                libros[i-1] = libros[i];
            }

            numLibros--;
            libros[numLibros] = null; //borra el ultimo libro para que al correr a la izquierda no quede duplicado.
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

        /*String salida = "[";
        for(int i = 0; i < numLibros; i++) {
            salida += libros[i];
            if(i < numLibros - 1) {
                salida += ", "; //separador entre libros, salvo que sea el ultimo libro
            }
        }
        return salida += "]"; */


      /*  StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < numLibros - 1; i++) {
            sb.append(libros[i]);
            sb.append(",");
        }
        if (libros.length > 0) {
            sb.append(libros[libros.length - 1]);
        }
        sb.append("]");
        return sb.toString();*/


        StringJoiner sj = new StringJoiner(",","[", "]");
        for (int i = 0; i < numLibros; i++) {
            sj.add(libros.toString());
        }
        return sj.toString();

    }/////////////////////////////


}

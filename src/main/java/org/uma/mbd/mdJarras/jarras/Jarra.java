package org.uma.mbd.mdJarras.jarras;

public class Jarra {
    private int capacidad;
    private int contenido;

    public Jarra(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad deber ser mayor que cero.");
        }
        this.capacidad = capacidad;
        this.contenido = 0;//si no coloco esta linea no pasa nada ya que int contenido por defecto se inicializa en cero.
    }

    public void llena() {
        contenido = capacidad;
    }

    public void vacia() {
        contenido = 0;
    }

    public void llenaDesde(Jarra jarra) {
        if(jarra.contenido <= (capacidad -  contenido)) {
            contenido += jarra.contenido;
            jarra.vacia();
        } else {
            jarra.contenido -= (capacidad - contenido);
            llena();
        }
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getContenido() {
        return contenido;
    }

    @Override
    public String toString() {
        return "J(" + capacidad + ", " + contenido + ")";
    }
}

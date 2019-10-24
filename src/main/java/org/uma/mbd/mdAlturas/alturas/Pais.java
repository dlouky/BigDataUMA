package org.uma.mbd.mdAlturas.alturas;

public class Pais {
    String nombre;
    String continente;
    double altura;

    public Pais(String nombre, String continente, double altura) {
        this.nombre = nombre;
        this.continente = continente;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContinente() {
        return continente;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public boolean equals(Object o){
        boolean res = o instanceof Pais;
        Pais pais = res ? (Pais)o : null;
        return res && (nombre.equalsIgnoreCase(pais.nombre));
    }

    @Override
    public int hashCode(){
        return nombre.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return "Pais(" + nombre + "," + continente + "," + altura + ")";
    }

}

package org.uma.mbd.mdAlturas.alturas;

public class Pais implements Comparable <Pais> {
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
        return res && (nombre.equalsIgnoreCase(pais.nombre) && altura == pais.altura);
    }

    @Override
    public int hashCode(){
        return nombre.toLowerCase().hashCode() + Double.hashCode(altura);
    }

    @Override
    public String toString() {
        return "Pais(" + nombre + "," + continente + "," + altura + ")";
    }

    @Override
    public int compareTo(Pais pa) {
        int res = continente.compareTo(pa.continente);
        if(res==0) {
            res = nombre.compareTo(pa.nombre);
        }
        return res;
    }


}

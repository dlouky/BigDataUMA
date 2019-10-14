package org.uma.mbd.mdRelojArena.reloj;

public class RelojArena {
    private int abajo; //cantidad de arena en la parte abajo = min totales que tiene el reloj si arriba es cero, sino es min transcurridos.
    private int arriba; //cantidad de arena en parte arriba = min restantes.
    
    public RelojArena(int abajo) {
        this.abajo = abajo;
    }
    
    public void gira() {
        int aux = abajo;
        abajo = arriba;
        arriba = aux;
    }
    
    public void pasaTiempo() {
        abajo += arriba;
        arriba = 0;
    }
    
    public int getTiempoRestante() {
        return arriba;
    }
    
    public void pasaTiempo(RelojArena reloj) {
        if(arriba > reloj.arriba) {
            arriba -= reloj.arriba;
            abajo += reloj.arriba;
            reloj.pasaTiempo();
        } else {
            this.pasaTiempo();
            reloj.pasaTiempo();
        }
    }

    @Override
    public String toString() {
        return "R(" + arriba + "/" + abajo + ")";
    }
}

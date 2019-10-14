package org.uma.mbd.mdRelojArena.reloj;

public class MedidorTiempo {
    RelojArena izdo;
    RelojArena drcho;
    int tiempo;

    public MedidorTiempo(int abajoIzdo, int abajoDrcho) {//abajoIzdo = tiempo total del reloj izdo
        izdo = new RelojArena(abajoIzdo);
        drcho = new RelojArena(abajoDrcho);
        tiempo = 0;
    }

    public void giraIzquierdo() {
        izdo.gira();
        pasaTiempo();
    }

    public void giraDerecho() {
        drcho.gira();
        pasaTiempo();
    }

    public void giraAmbos() {
        izdo.gira();
        drcho.gira();
        pasaTiempo();
    }

    public void pasaTiempo() {
        if(izdo.getTiempoRestante() == 0 || drcho.getTiempoRestante() == 0) {
            if(izdo.getTiempoRestante() == 0) {
                tiempo += drcho.getTiempoRestante();
                drcho.pasaTiempo();
            } else {
                tiempo += izdo.getTiempoRestante();
                izdo.pasaTiempo();
            }
        } else if(drcho.getTiempoRestante() < izdo.getTiempoRestante()) {
            tiempo += drcho.getTiempoRestante();
            izdo.pasaTiempo(drcho);
        } else {
            tiempo += izdo.getTiempoRestante();
            drcho.pasaTiempo(izdo);
        }
    }

    public int getTiempoTotal() {
        return tiempo;
    }

    @Override
    public String toString() {
        return "M( " + izdo + ", " + drcho + ", t = " + tiempo + " )";
    }

}

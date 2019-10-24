package org.uma.mbd.mdMasterMindL.mastermind;

public class Movimiento {
    private String cifras;
    private int colocadas;
    private int descolocadas;

    public Movimiento(String cifras, int colocadas, int descolocadas) {
        this.cifras = cifras;
        this.colocadas = colocadas;
        this.descolocadas = descolocadas;
    }

    public String getCifras() {
        return cifras;
    }

    public int getColocadas() {
        return colocadas;
    }

    public int getDescolocadas() {
        return descolocadas;
    }

    @Override
    public boolean equals(Object o){
        boolean res = o instanceof Movimiento;
        Movimiento mov = res ? (Movimiento)o : null;
        return res && (mov.cifras.equals(cifras));
    }

    @Override
    public int hashCode(){
        return cifras.hashCode();
    }

    @Override
    public String toString() {
        return "[" + cifras + ", " + colocadas + ", " + descolocadas + "]";
    }
}

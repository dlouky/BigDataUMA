package org.uma.mbd.mdBusV1L.buses;

import java.util.StringJoiner;

public class Bus {
    int codBus;
    String matricula;
    int codLinea;

    public Bus(int codBus, String matricula) {
        this.codBus = codBus;
        this.matricula = matricula;
    }

    public void setCodLinea(int codLinea) {
        this.codLinea = codLinea;
    }

    public int getCodBus() {
        return codBus;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getCodLinea() {
        return codLinea;
    }

    @Override
    public boolean equals(Object o){
        boolean res = o instanceof Bus;
        Bus bus = res ? (Bus) o : null;
        return res && matricula.equalsIgnoreCase(bus.getMatricula()) && getCodBus() == bus.getCodBus();
    }

    @Override
    public int hashCode(){
        return matricula.toLowerCase().hashCode() + Integer.hashCode(codBus);
    }

    @Override
    public String toString() {//No hacer muy verbosos los toString porque se pierden a la derecha de la pantalla!!!
       // StringJoiner sj = new StringJoiner(", ", "(", ")");
        //return "Bus" + sj.add(codBus+"").add(matricula).add(codLinea+"").toString();
        return "Bus(" + codBus + ", " + matricula + "," + codLinea + ")";
    }
}

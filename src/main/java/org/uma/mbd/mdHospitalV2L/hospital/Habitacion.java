package org.uma.mbd.mdHospitalV2L.hospital;

import java.util.ArrayList;
import java.util.List;

public class Habitacion {
    private List<Cama> camas = new ArrayList<>();
    private String codigo;
    private int numCamas;

    public Habitacion(int numCamas, String codigo) {
        this.codigo = codigo;
        for(int i = 0; i < numCamas; i++) {
            camas.add(new Cama(codigo + "C" + i));
        }
    }

    public Cama getCama(int i) {
        return camas.get(i);
    }

    public int numCamas() {
        return camas.size();
    }

    public boolean hayCamaLibre() {
        int i= 0;
        while(i<camas.size() && !camas.get(i).estaLibre()) {
            i++;
        }
        return i < camas.size();
    }

    public Cama camaLibre() {
        if (!hayCamaLibre()) {
            return null;
        } else {
            int i= 0;
            while(!camas.get(i).estaLibre()) {
                i++;
            }
            return camas.get(i);
        }
    }

    public String toString() {
        return "Habitación: " + codigo + ", camas : " + camas.toString() + ", camas libres: " + camaLibre() + "\n";
    }




}

package org.uma.mbd.mdHospitalV2L.hospital;

import java.util.ArrayList;
import java.util.List;

public class Planta {
    private List<Habitacion> habitaciones = new ArrayList<>();
    private String codigo;

    public Planta(int numHabitaciones, String codigo) {
        this.codigo = codigo;
        for(int i = 0; i < numHabitaciones; i++) {
            habitaciones.add(new Habitacion(4,codigo + "H" + i)); //suponemos 4 camas por habitación
        }
    }

    public Habitacion getHabitacion(int i) {
        return habitaciones.get(i);
    }

    public int numHabitaciones() {
        return habitaciones.size();
    }

    public boolean hayCamaLibre() {
        int i= 0;
        while(i<habitaciones.size() && !habitaciones.get(i).hayCamaLibre()) {
            i++;
        }
        return i < habitaciones.size();
    }

    public Cama camaLibre() {
        if (!hayCamaLibre()) {
            return null;
        } else {
            int i= 0;
            while(!habitaciones.get(i).hayCamaLibre()) {
                i++;
            }
            return habitaciones.get(i).camaLibre();
        }
    }

    public String toString() {
        return "Planta: " + codigo + "   " + habitaciones.toString();
    }

}

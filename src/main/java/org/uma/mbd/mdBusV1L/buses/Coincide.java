package org.uma.mbd.mdBusV1L.buses;

import org.uma.mbd.mdUrna.urna.Urna;

public class Coincide implements Criterio {
    private Bus bus;

    public Coincide(Bus bus) {
        this.bus = bus;
    }

    @Override
    public boolean esSeleccionable(Bus bus) {
        return this.bus.equals(bus);
    }

    @Override
    public String toString() {
        return "Autobus " + bus;
    }
}

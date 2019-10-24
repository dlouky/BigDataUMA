package org.uma.mbd.mdBusV1L.buses;

@FunctionalInterface
public interface Criterio {
    boolean esSeleccionable(Bus bus);
}

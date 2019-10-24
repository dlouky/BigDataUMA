package org.uma.mbd.mdBusV1L.buses;

public class EnMatricula implements Criterio{
    private String contenido;

    public EnMatricula(String contenido) {
        this.contenido = contenido.toUpperCase();
    }

    @Override
    public boolean esSeleccionable(Bus bus) {
        return bus.getMatricula().toUpperCase().contains(contenido);
    }

    @Override
    public String toString() {
        return "Autobuses cuya matrícula contiene " + contenido;
    }
}

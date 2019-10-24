package org.uma.mbd.mdHospitalV2L.hospital;

public class Cama {
    private String codigo;
    private Paciente paciente;

    public Cama(String codigo) {
        this.codigo = codigo;
        this.paciente = null; //Se crea la cama vacía (sin paciente). Esto se puede obviar.
    }

    public void setPaciente(Paciente paciente) {
        if(!this.estaLibre()) {
            throw new RuntimeException("La cama no está libre");
        }
        this.paciente = paciente;
    }

    public boolean estaLibre() {
        return (this.paciente == null) ? true : false;
    }

    public void libera() {
        this.paciente = null;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    @Override
    public String toString() {
        String s = codigo;
        /*if(paciente == null) {
            s+= " Vacía";
        } else {
            s+= "Paciente -> " + paciente;
        }*/
        return s;
    }

}

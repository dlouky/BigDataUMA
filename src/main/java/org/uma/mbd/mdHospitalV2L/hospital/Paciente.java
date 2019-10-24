package org.uma.mbd.mdHospitalV2L.hospital;

import java.util.StringJoiner;

public class Paciente extends Persona {
    private Medico medico;
    private Cama cama;
    private boolean esUrgencia;
    private String numSegSocial;
    private double altura;
    private double indiceMasaCorporal;
    private double peso;

    public Paciente(String dni, String nombre, String apellidos, int edad, Genero sexo,
                    double altura, double peso, String numSegSocial, boolean esUrgencia, Cama cama) {
        super(dni, nombre, apellidos, edad, sexo);
        this.altura = altura;
        this.peso = peso;
        this.numSegSocial = numSegSocial;
        this.esUrgencia = esUrgencia;
        this.indiceMasaCorporal = peso/Math.pow(altura, 2);
        this.cama = cama;
        this.cama.setPaciente(this);
    }

    public boolean esUrgencia() {
        return esUrgencia;
    }

    public void asignaMedico(Medico medico) {
        this.medico = medico;
    }

    public Medico atendidoPor() {
        return medico;
    }

    public void daDeAlta() {
        cama.libera();
        cama = null;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        return "Paciente" + sj.add(super.toString().replace("]","")).add(altura+"").
                add(peso+"").add(numSegSocial).add(esUrgencia+"").add(medico.getNombreCompleto()).toString();
    }

}

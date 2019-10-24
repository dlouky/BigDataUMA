package org.uma.mbd.mdHospitalV2L.hospital;

import java.util.StringJoiner;

public class Persona {
    private String apellidos;
    private Genero sexo;
    private String nombre;
    private int edad;
    private String dni;

    public Persona(String dni, String nombre, String apellidos, int edad, Genero sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getDni(){
        return dni;
    }

    public String getNombreCompleto() {
        return nombre + ", " + apellidos;
    }


    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        return sj.add(nombre).add(sexo.toString()).toString();
    }

}

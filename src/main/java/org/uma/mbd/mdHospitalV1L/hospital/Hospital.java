package org.uma.mbd.mdHospitalV1L.hospital;

import java.util.LinkedList;
import java.util.List;

public class Hospital {
    private List<Departamento> departamentos;
    private int numDepartamentos;
    private String nombre;
    private String direccion;
    
    public Hospital(String nombre, String direccion, List<Departamento> departamentos, int numDepartamentos){
        this.nombre = nombre;
        this.direccion = direccion;
        this.departamentos = departamentos;
        this.numDepartamentos = numDepartamentos;
    }
    
    public Departamento getDepartamento(String nombre) {
        int pos=0;
        while(pos < departamentos.size() && (departamentos.get(pos).getNombre() != nombre) ) {
            pos++;
        }
        if(pos==departamentos.size()) {
            throw new IllegalArgumentException("No existe departamento con ese nombre");
        }
        return departamentos.get(pos);
    }

    @Override
    public String toString() {
        return departamentos.toString();
    }

}

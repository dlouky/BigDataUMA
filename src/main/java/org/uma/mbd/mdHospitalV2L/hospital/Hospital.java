package org.uma.mbd.mdHospitalV2L.hospital;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private List<Departamento> departamentos;
    private int numDepartamentos;
    private String nombre;
    private String direccion;
    private List<Planta> plantas = new ArrayList<>();
    private List<String> nombresDepartamentos = new ArrayList<>();
    
    public Hospital(String nombre, String direccion, List<Departamento> departamentos, int numPlantas){
        this.nombre = nombre;
        this.direccion = direccion;
        this.departamentos = departamentos;
        this.numDepartamentos = departamentos.size();
        for(int i = 0; i < numPlantas; i++) {
            plantas.add(new Planta(8,"P" + i)); //suponemos 8 habitaciones por planta
        }
        for(int i = 0; i < departamentos.size(); i++) {
            nombresDepartamentos.add(departamentos.get(i).getNombre());
        }
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

    public int numPlantas() {
        return plantas.size();
    }

    public Planta getPlanta(int i) {
        return plantas.get(i);
    }

    public List<String> getNombresDepartamentos() {
        return nombresDepartamentos;
    }

    @Override
    public String toString() {
        return "Hospital " + nombre;
    }

}

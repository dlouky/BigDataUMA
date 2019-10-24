package org.uma.mbd.mdHospitalV1L.hospital;

import java.util.LinkedList;
import java.util.List;

public class Departamento {
    private List<Medico> medicos;
    private int numMedicos;
    private String nombre;

    public Departamento(String nombre, List<Medico> medicos) {
        this.nombre = nombre;
        this.medicos = medicos;
    }

    public boolean trabajaEnDepartamento(Medico med) {
        return medicos.contains(med);
    }

    public Medico getMedico(String dni) {
        Medico me;
        int pos=0;
        while(pos < medicos.size() &&!medicos.get(pos).getDni().equalsIgnoreCase(dni) ) {
            pos++;
        }
       if(pos==medicos.size()) {
            //throw new IllegalArgumentException("No existe medico con ese DNI");
           me = null;
        } else {
           me = medicos.get(pos);
       }
        return me;
    }

    public String getNombre() {
        return nombre;
    }

    public int numMedicos(Categoria cat) {
        numMedicos = 0;
        for (Medico m : medicos) {
            if(m.getCategoriaProfesional() == cat) {
                numMedicos++;
            }
        }
        return numMedicos;
    }

    @Override
    public String toString() {
        return "Dto " + nombre + ": " + medicos.toString().replace("\nMedico:","");
    }
}

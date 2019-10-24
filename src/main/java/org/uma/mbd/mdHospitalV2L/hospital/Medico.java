package org.uma.mbd.mdHospitalV2L.hospital;

public class Medico extends Persona {
    private boolean trabajarEnPrivado;
    private Categoria categoriaProfesional;
    private double horasSemanales;

    public Medico(String dni, String nombre, String apellidos, int edad, Genero sexo,
                  Categoria categoria, boolean trabajarEnPrivado, double horasSemanales) {
        super(dni, nombre, apellidos, edad, sexo);
        this.categoriaProfesional = categoria;
        this.trabajarEnPrivado = trabajarEnPrivado;
        this.horasSemanales = horasSemanales;
    }

    public boolean isTrabajarEnPrivado() {
        return trabajarEnPrivado;
    }

    public Categoria getCategoriaProfesional() {
        return categoriaProfesional;
    }

    @Override
    public String toString() {
        return "Medico:(" + super.toString() + ", "
                + categoriaProfesional + ", "
                + trabajarEnPrivado + ", "
                + horasSemanales + ")";
    }
}

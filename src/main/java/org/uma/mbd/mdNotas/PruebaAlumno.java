package org.uma.mbd.mdNotas;

import org.uma.mbd.mdNotas.notas.Alumno;
import org.uma.mbd.mdNotas.notas.AlumnoException;

public class PruebaAlumno {
    public static void main(String[] args) throws AlumnoException {
        Alumno alumno1 = new Alumno("22456784F", "Gonzalez Perez, Juan", 5.5);
        Alumno alumno2 = new Alumno("33456777S", "Gonzalez Perez, Juan", 3.4);

        System.out.println("Alumno1: " + alumno1);
        System.out.println("Alumno2: " + alumno1);

        System.out.println( alumno1.equals(alumno2) ? "Alumnos iguales" : "Alumnos distintos" );

        alumno2 = new Alumno("33456777S", "Gonzalez Perez, Juan", -3.4); //Arroja la Exception AlumnoException por ser nota negativa.
    }
}

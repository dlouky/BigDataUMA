package org.uma.mbd.mdNotas;

import org.uma.mbd.mdNotas.notas.*;

public class PruebaAsignatura {
    static String[] alumnos = { "12455666F;Lopez Perez, Pedro;6.7",
            "33678999D;Merlo Gomez, Isabel;5.8",
            "23555875G;Martinez Herrera, Lucia;9.1"};

    public static void main(String[] args) {
        Asignatura asignatura = new Asignatura("Asignatura");
        try{
            asignatura.leeDatos(alumnos);
            CalculoMedia mediaAritmetica = new MediaAritmetica();
            System.out.print("Media Aritmetica de la asignatura: ");
            System.out.println(asignatura.getMedia(mediaAritmetica));

            System.out.print("Dni de los alumnos: ");
            for(Alumno alumno : asignatura.getAlumnos()) {
                System.out.print(alumno.getDni() + "\t");
            }

            Alumno al1 = new Alumno("12455666F", "Lopez Perez, Pedro");
            System.out.println("\nCalificacion de " + al1.getNombre() + ": " + asignatura.getCalificacion(al1));

            Alumno al2 = new Alumno("12455666F", "Lopez Lopez, Pedro");
            System.out.println("\nCalificacion de " + al2.getNombre() + ": " + asignatura.getCalificacion(al2));

        } catch(AlumnoException e) {
            System.out.println(e.getMessage());
        }
    }
}

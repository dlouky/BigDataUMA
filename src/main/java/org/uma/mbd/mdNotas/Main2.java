package org.uma.mbd.mdNotas;


import org.uma.mbd.mdNotas.notas.*;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main2 {

	public static void main(String[] args) throws IOException {
		Asignatura algebra = new Asignatura("Algebra");

		try {
			algebra.leeDatos("recursos/mdNotas/notas.txt");
			Alumno al1 = new Alumno("23322443k", "Lopez Turo, Manuel");
			Alumno al2 = new Alumno("342424f2J", "Fernandez Vara, Pedro");
			System.out.println("Calificacion de " + al1 + ": "
					+ algebra.getCalificacion(al1));
			System.out.println("Calificacion de " + al2 + ": "
					+ algebra.getCalificacion(al2));
		} catch (AlumnoException e) {
			System.err.println(e.getMessage());
		}
		try {
			CalculoMedia m1 = new MediaAritmetica();
			CalculoMedia m2 = new MediaArmonica();
			double min = 5.0;
			double max = 9.0;
			CalculoMedia m3 = new MediaSinExtremos(min,max);
			
			System.out.print("Media aritmetica ");
			System.out.println(algebra.getMedia(m1));
			System.out.print("Media armonica ");
			System.out.println(algebra.getMedia(m2));
			System.out.print("Media de valores en ["+min+","+max+"] ");
			System.out.println(algebra.getMedia(m3));
		} catch (AlumnoException e) {
			System.out.println("Error "+ e.getMessage());
		}
		System.out.println("Alumnos...");
		algebra.getAlumnos().forEach(
				alumno -> System.out.println(alumno + ": " + alumno.getCalificacion()));

		System.out.println("Malos...");
		algebra.getErrores().forEach(System.out::println);
		System.out.println("La asignatura completa");
		System.out.println(algebra);

		System.out.println();
		System.out.println("Nombre de los alumnos");
		algebra.getNombreAlumnos().forEach(System.out::println);

		System.out.println();
		System.out.println("Alumnos ordenados por notas, a igualdad de notas por nombre y a igualdad de nombres por dni");
		Comparator<Alumno> compNotas = Comparator.comparing(Alumno::getCalificacion);
		Comparator<Alumno> compNotNomDni = compNotas.thenComparing(Comparator.naturalOrder());
		Set<Alumno> setA = algebra.getAlumnos(compNotNomDni);
		//setAlumnos.forEach(System.out::println); //--> No imprime la nota
		for(Alumno alumno : setA) {
			System.out.println(alumno + " " + alumno.getCalificacion());
		}


		System.out.println();
		System.out.println("Alumnos ordenados por dni descendentes");
		Comparator<Alumno> compDni = Comparator.comparing(Alumno::getDni);
		Set<Alumno> setB = algebra.getAlumnos(compDni.reversed());
		for(Alumno alumno : setB) {
			System.out.println(alumno + " " + alumno.getCalificacion());
		}

		System.out.println();
		System.out.println("Correspondencia de alumnos por inicial");
		Map<Character, Set<Alumno>> map = algebra.getAlumnosInicial();
		for (Character k : map.keySet()) {
			System.out.println("Letra " + k);
			Set<Alumno> setC = map.get(k);
			for (Alumno alumno : setC) {
				System.out.println(alumno + " " + alumno.getCalificacion());
			}
		}
	}
}


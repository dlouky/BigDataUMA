package org.uma.mbd.mdNotas.notas;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.NoSuchObjectException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Asignatura {
	private String nombre;
	private List<Alumno> alumnos;
	private List<String> errores;

	private static final double APROBADO = 5;
	private static final String DNI = "[0-9]{8}[A-Z&&[^IOU]]";

	public Asignatura(String nombreAsignatura) {
		nombre = nombreAsignatura;
		alumnos = new ArrayList<>();
		errores = new ArrayList<>();
	}

	public void leeDatos(String nombreFichero) throws IOException {
		try (Scanner sc = new Scanner(new File(nombreFichero))){
			while(sc.hasNextLine()) {
				stringAAlumno(sc.nextLine());
			}
		}
	}

	public void leeDatos(String[] datos) {
		for (String dato: datos) {
			stringAAlumno(dato);
        }
	}

	private void stringAAlumno(String linea) {
		try (Scanner sc = new Scanner(linea)) {
			sc.useDelimiter("[;]+");
			sc.useLocale(Locale.ENGLISH);
			String dniAlumno = sc.next();
			String nombreAlumno = sc.next();
			double notaAlumno = sc.nextDouble();
			if(!dniAlumno.matches(DNI)) {
				throw new AlumnoException("DNI Incorrecto: ");
			}
			alumnos.add(new Alumno(dniAlumno, nombreAlumno, notaAlumno)); //ver si los sc.next() de arriba se pueden meter como argumentos.
		} catch (AlumnoException e) {
			errores.add(e.getMessage() + linea);
		} catch (InputMismatchException e) {
			errores.add("Nota no numérica: " + linea);
		} catch (NoSuchElementException e) {
			errores.add("Faltan datos: " + linea);
		}
	}

	public double getCalificacion(Alumno al) throws AlumnoException {
 		if(!alumnos.contains(al)) {
 			throw new AlumnoException("No existe el alumno " + al);
		}
		int pos = 0;
 		while (pos < alumnos.size() && !alumnos.get(pos).equals(al)) {
 			pos++;
		}
 		return alumnos.get(pos).getCalificacion();
    }

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public List<String> getErrores() {
		return errores;
	}

	public Set<String> getNombreAlumnos() {
		Set<String> setAlumnos = new HashSet<>();
		for(Alumno al : alumnos) {
			setAlumnos.add(al.getNombre());
		}
		return setAlumnos;
	}
	
	public double getMedia(CalculoMedia media) throws AlumnoException {
		return media.calcular(alumnos);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nombre);
		sb.append(alumnos);
		sb.append(errores);
		return sb.toString();
	}

	public Set<Alumno> getAlumnos(Comparator<Alumno> comp) {
		Set<Alumno> set = new TreeSet<>(comp);
		set.addAll(alumnos);
		return set;
	}

	public Map<Character, Set<Alumno>> getAlumnosInicial() {
		Comparator<Alumno> compNotas = Comparator.comparing(Alumno::getCalificacion).reversed();
		Map<Character, Set<Alumno>> map = new TreeMap<>();
		for (Alumno alumno : alumnos) {
			char nombreInicial = alumno.getNombre().charAt(0);
			Set<Alumno> set = map.computeIfAbsent(nombreInicial, c -> new TreeSet<>(compNotas.thenComparing(Comparator.naturalOrder())));
			set.add(alumno);
		}
		return map;
	}


}

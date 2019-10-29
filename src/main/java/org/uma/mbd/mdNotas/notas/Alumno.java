package org.uma.mbd.mdNotas.notas;

public class Alumno implements Comparable <Alumno> {
	private String nombre;
	private String dni;
	private double nota;
	
	public Alumno(String d, String n, double c) throws AlumnoException {
		if(c < 0) {
			throw new AlumnoException("Calificacion negativa: ");
		}
		dni = d;
		nombre = n;
		nota = c;
	}
	
	public Alumno(String d, String n) throws AlumnoException {
		this(d,n,0);
	}

	@Override
	public boolean equals(Object obj) {
		boolean res = obj instanceof Alumno;
		Alumno a = res ? (Alumno) obj:null;
		return res && nombre.equalsIgnoreCase(a.nombre) && dni.equalsIgnoreCase(a.dni);
	}
	
	@Override
	public int hashCode() {
		return nombre.toLowerCase().hashCode() + dni.toLowerCase().hashCode();
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public double getCalificacion() {
		return nota;
	}
	
	@Override
	public String toString() {
		return nombre + " " + dni;
	}

	@Override
	public int compareTo(Alumno alumno) { //Orden Natural => por nombre y luego por dni
		return (nombre.compareTo(alumno.nombre)!=0) ? nombre.compareTo(alumno.nombre) : dni.compareTo(alumno.dni);
	}

}

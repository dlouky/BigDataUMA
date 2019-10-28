package org.uma.mbd.mdInterfaces.caso4;

public class Persona implements Comparable <Persona> {

	private String nombre;
	private int edad;
	
	public Persona(String n, int e) {
		nombre = n;
		edad = e;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public String toString() {
		return nombre + ":" + edad;
	}

	@Override
	public boolean equals(Object obj) {
		boolean res = obj instanceof  Persona;
		Persona p = res ? (Persona) obj:null;
		return res && nombre.equals(p.nombre) && edad == p.edad;
	}

	public int hashCode(){
		return nombre.hashCode() + Integer.hashCode(edad);
	}



	@Override
	public int compareTo(Persona per) {
		int res = Integer.compare(edad, per.edad);
		if(res==0) {
			res = nombre.compareTo(per.nombre);
		}
		return res;
	}

}










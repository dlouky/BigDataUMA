package org.uma.mbd.mdInterfaces.caso1;

import java.util.Arrays;
// SIN INTERFACES Y CON ARRAYS
public class Amigos {
	private Persona [] personas;
	
	public Amigos(Persona [] personas) {
		this.personas = personas;
	}
	
	public Persona [] getPersonas() {
		return personas;
	}
	
	public Persona [] mayoresQue(int n) {
		Persona [] nueva = new Persona[personas.length];
		int i = 0;
		for (Persona p: personas) {
			if (p.getEdad() >= n) {
				nueva[i] = p;
				i++;
			}
		}
		return Arrays.copyOf(nueva, i);
	}
	
	public Persona [] menoresQue(int n) {
		Persona [] nueva = new Persona[personas.length];
		int i = 0;
		for (Persona p: personas) {
			if (p.getEdad() <= n) {
				nueva[i] = p;
				i++;
			}
		}
		return Arrays.copyOf(nueva, i);
	}
	
	public Persona [] empiezanCon(String s) {
		Persona [] nueva = new Persona[personas.length];
		int i = 0;
		for (Persona p: personas) {
			if (p.getNombre().startsWith(s)) {
				nueva[i] = p;
				i++;
			}
		}
		return Arrays.copyOf(nueva, i);
	}
}

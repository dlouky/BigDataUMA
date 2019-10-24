package org.uma.mbd.mdInterfaces.caso3;
// CON INTEFACES, ARRAYS Y FUNCIONAL
import java.util.Arrays;
import java.util.function.Predicate;

public class Amigos {
	private Persona[] personas;
	
	public Amigos(Persona[] personas) {
		this.personas = personas;
	}
	
	public Persona[] getPersonas() {
		return personas;
	}
	
	public Persona[] filtra(Predicate<Persona> pred) {
		Persona[] nueva = new Persona[personas.length];
		int i = 0;
		for (Persona p: personas) {
			if (pred.test(p)) {
				nueva[i] =  p;
				i++;
			}
		}
		return Arrays.copyOf(nueva, i);
	}	
}

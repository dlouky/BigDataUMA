package org.uma.mbd.mdInterfaces.caso2;
// CON INTERFACES Y CON ARRAYS
import java.util.Arrays;

public class Amigos {
	private Persona [] personas;
	
	public Amigos(Persona [] personas) {
		this.personas = personas;
	}
	
	public Persona [] getPersonas() {
		return personas;
	}
	
	public Persona [] filtra(Predicado pred) { //pred tiene un método filtra que es redefinido según la clase que implemente la interface Predicado
		Persona [] nueva = new Persona[personas.length];
		int i = 0;
		for (Persona p: personas) {
			if (pred.test(p)) {
				nueva[i] = p;
				i++;
			}
		}
		return Arrays.copyOf(nueva, i);
	}	
}

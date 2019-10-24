package org.uma.mbd.mdInterfaces.caso4;
// CON INTERFACES, LISTAS Y FUNCIONAL
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Amigos {
	private List<Persona> personas;
	
	public Amigos(List<Persona> personas) {
		this.personas = personas;
	}
	
	public List<Persona> getPersonas() {
		return personas;
	}
	
	public List<Persona> filtra(Predicate<Persona> pred) {
		List<Persona> nueva = new ArrayList<>();
		for (Persona p: personas) {
			if (pred.test(p)) {
				nueva.add(p);
			}
		}
		return nueva;
	}	
}

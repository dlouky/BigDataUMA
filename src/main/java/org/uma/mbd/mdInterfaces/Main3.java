package org.uma.mbd.mdInterfaces;

import org.uma.mbd.mdInterfaces.caso3.Amigos;
import org.uma.mbd.mdInterfaces.caso3.Persona;

import java.util.function.Predicate;
//Con Arrays y herencias Lambda
public class Main3 {
	public static void main(String [] args) {
		Persona[] personas  = {
				new Persona("juan", 25),
				new Persona("maria", 32),
				new Persona("marta", 28),
				new Persona("julio", 33),
				new Persona("manuel", 29),
				new Persona("justino",25)
		};
		Amigos amigos = new Amigos(personas);
		System.out.println("Empiezan con ma");
		Persona[] ps1 = amigos.filtra((Persona p) -> p.getNombre().startsWith("ma"));
		for (Persona p : ps1) {
			System.out.println(p);
		}
		System.out.println("Mayores de 28");
		Persona[] ps2 = amigos.filtra(p -> p.getEdad() > 28);
		for (Persona p : ps2) {
			System.out.println(p);
		}
		System.out.println("Menores de 27");
		Predicate<Persona> pred = p -> p.getEdad() < 27;
		Persona[] ps3 = amigos.filtra(pred);
		for (Persona p : ps3) {
			System.out.println(p);
		}


	}
}




/*
		System.out.println("Menores de 27");
		Persona [] ps3 = amigos.filtra(p -> p.getNombre().contains("ca");
		for (Persona p : ps3) {
			System.out.println(p);
		}
*/

/*
		Arrays.canciones(ps1).forEach(System.out::println);
 */
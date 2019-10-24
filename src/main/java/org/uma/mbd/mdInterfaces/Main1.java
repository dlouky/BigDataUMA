package org.uma.mbd.mdInterfaces;

import org.uma.mbd.mdInterfaces.caso1.Amigos;
import org.uma.mbd.mdInterfaces.caso1.Persona;
//Con arrays y clases
public class Main1 {
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
		System.out.println("\nEmpiezan con ma");
		Persona [] ps1 = amigos.empiezanCon("ma");
		for (Persona p : ps1) {
			System.out.println(p);
		}
		System.out.println("\nMayores de 28");
		Persona [] ps2 = amigos.mayoresQue(28);
		for (Persona p : ps2) {
			System.out.println(p);
		}
		System.out.println("\nMenores de 27");
		Persona [] ps3 = amigos.menoresQue(27);
		for (Persona p : ps3) {
			System.out.println(p);
		}

	}
}

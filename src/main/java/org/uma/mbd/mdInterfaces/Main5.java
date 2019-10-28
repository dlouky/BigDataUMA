package org.uma.mbd.mdInterfaces;

import org.uma.mbd.mdInterfaces.caso4.Persona;

import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Set<Persona> set = new HashSet<>();
        set.add(new Persona("Juan", 25));
        set.add(new Persona("Pedro", 12));
        set.add(new Persona("Juan", 25));
        set.add(new Persona("Luisa", 18));
        System.out.println(set);

        Set<Persona> set0 = new TreeSet<>();
        set0.add(new Persona("Juan", 25));
        set0.add(new Persona("Pedro", 12));
        set0.add(new Persona("Juan", 25));
        set0.add(new Persona("Luisa", 18));
        set0.add(new Persona("Andres", 12));
        System.out.println(set0);

        /*Set<Persona> setA = new TreeSet<>((p1,p2)-> Integer.compare(p1.getEdad(), p2.getEdad()));
        setA.addAll(set0); //se comporta irracionalmente porque estoy poniendo un comparador que no es bueno (solo por edad).
        System.out.println(setA);*/

        Comparator<Persona> oE = (p1,p2)-> Integer.compare(p1.getEdad(), p2.getEdad());
        Comparator<Persona> oN = (p1,p2)-> p1.getNombre().compareToIgnoreCase(p2.getNombre());
        Set<Persona> setA = new TreeSet<>(oE.reversed().thenComparing(oN).reversed()); //borrar el ultimo reversed y pensar!!!
        setA.addAll(set0); //ahora si estoy haciendo con un comparador bueno
        System.out.println(setA);

        Set<String> setS = new TreeSet<>(List.of("hola", "Antonio", "que", "tal", "estas", "hoy")); //Orden lexicográfico
        System.out.println(setS);

        Comparator<String> comp = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        Comparator<String> com2 = comp.thenComparing(Comparator.naturalOrder());
        Set<String> setS2 = new TreeSet<>(com2);
        setS2.addAll(setS);
        System.out.println(setS2); //ordena primero por longitud de palabra y a igualdad de longitud lexicográficamente
    }
}

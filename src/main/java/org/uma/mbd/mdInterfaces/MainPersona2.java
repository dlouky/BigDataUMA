package org.uma.mbd.mdInterfaces;
import org.uma.mbd.mdInterfaces.caso4.Persona;

import java.util.*;
public class MainPersona2 {
    public static void main(String [] args) {
        Persona p1 = new Persona("Juan", 35);
        Persona p2 = new Persona("Pedro", 22);
        Comparator<Persona> orNombre = Comparator.comparing(Persona::getNombre);
        Comparator<Persona> orEdad = Comparator.comparingInt(Persona::getEdad);
// y ahora
        Comparator<Persona> op = orEdad.thenComparing(orNombre);
        System.out.println(op.compare(p1,p2));
        Comparator<Persona> op2 =
                orNombre.reversed().thenComparing(orEdad);
        System.out.println(op2.compare(p1,p2));
        Comparator<Persona> op3 =
                orNombre.reversed()
                        .thenComparing(Comparator.naturalOrder());
        System.out.println(op3.compare(p1,p2));
    }
}

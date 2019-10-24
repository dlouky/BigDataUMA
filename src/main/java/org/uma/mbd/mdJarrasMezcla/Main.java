package org.uma.mbd.mdJarrasMezcla;

import org.uma.mbd.mdJarrasMezcla.jarrasMezcla.JarraMezcla;
import org.uma.mbd.mdJarrasMezcla.jarrasMezcla.Jarra;

public class Main {
    public static void main(String [] args) {
        JarraMezcla ja = new JarraMezcla(4);
        JarraMezcla jb = new JarraMezcla(4);
        ja.llena(); //ja llena de agua
        jb.llenaVino(); //jb llena de vino
        Jarra jTemp = new Jarra(2);
        jTemp.llenaDesde(ja); //se llama al metodo llenaDesde(Jarrja ) de clase Jarra. Interprea a ja como una Jarra. ja queda con 2 litros.
        jTemp.vacia();
        jTemp.llenaDesde(jb);
        // Las dos jarras estan con 2 litros
        JarraMezcla ji = new JarraMezcla(1);
        for (int i = 0 ; i < 1000; i++) {
            ji.llenaDesde(ja); //ji
            jb.llenaDesde(ji);
            ji.llenaDesde(jb);
            ja.llenaDesde(ji);
            System.out.println(i + " "+ ja + " " + jb);
        }
    }
}

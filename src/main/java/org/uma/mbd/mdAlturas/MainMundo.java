package org.uma.mbd.mdAlturas;

import org.uma.mbd.mdAlturas.alturas.EnContinente;
import org.uma.mbd.mdAlturas.alturas.MenoresQue;
import org.uma.mbd.mdAlturas.alturas.Pais;
import org.uma.mbd.mdAlturas.alturas.Mundo;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MainMundo {
    public static void main(String args[]) throws FileNotFoundException {
        Mundo paises = new Mundo();
        paises.leePaises("recursos/mdAlturas/alturas.txt");
        /*for (Pais pais : paises.selecciona(new MenoresQue(1.70))) {
            System.out.println(pais);
        }*/
        //System.out.println();

        Comparator<Pais> oC = (p1,p2)-> p1.getContinente().compareToIgnoreCase(p2.getContinente());
        Comparator<Pais> oA = (p1, p2)-> Double.compare(p1.getAltura(), p2.getAltura());
        Comparator<Pais> oN = (p1,p2)-> p1.getNombre().compareToIgnoreCase(p2.getNombre());

        System.out.println("\nAhora Ordenado: altura menor a 1.7, por continente y altura y nombre");
        Set<Pais> setA = new TreeSet<>(oC.thenComparing(oA).thenComparing(oN));
        setA.addAll(paises.selecciona(new MenoresQue(1.70)));
        setA.forEach(System.out::println);




        /*for (Pais pais : paises.selecciona(new EnContinente("Europe"))) {
            System.out.println(pais);
        }*/
        //System.out.println();
        System.out.println("\nAhora Ordenado: en Europa, por altura descendiente y nombre");
        Set<Pais> setB = new TreeSet<>(oA.reversed().thenComparing(oN));
        setB.addAll(paises.selecciona(new EnContinente("Europe")));
        setB.forEach(System.out::println);



        /*for (Pais pais : paises.selecciona(p -> p.getAltura() < 1.65)) {
            System.out.println(pais);
        }*/
        System.out.println("\nAhora Ordenado: altura menor a 1.65 y orden natural (por continente y nombre)");
        Set<Pais> setC = new TreeSet<>(Comparator.naturalOrder());
        setC.addAll(paises.selecciona(p -> p.getAltura() < 1.65));
        setC.forEach(System.out::println);

        /*paises.selecciona(p -> p.getAltura() < 1.65)
                .forEach(p -> System.out.println(p));
        paises.selecciona(p -> p.getAltura() < 1.65)
                .forEach(System.out::println);

        System.out.println("\nCon Stream");
        paises.getPaises().stream().filter(p -> p.getAltura() < 1.65)
                .forEach(System.out::println);*/
        System.out.println("\n");
        paises.numPaisesPorContinente().forEach((k,v) -> System.out.println(k + "-> " + v));

        Map<String, Set<Pais>> map = paises.paisesPorContinente();
        for (String k : map.keySet()) {
            System.out.println(k);
            Set<Pais> set = map.get(k);
            for (Pais pais : set) {
                System.out.println("\t" + pais);
            }
        }
    }
}

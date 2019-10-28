package org.uma.mbd.mdAlturas.alturas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Mundo {
    List<Pais> paises;

    public Mundo() {
        paises = new ArrayList<>();
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void leePaises(String file) throws FileNotFoundException {
        try (Scanner sc = new Scanner((new File(file)))) {
            leePaises(sc);
        }
    }

    private void leePaises(Scanner sc) {
        while(sc.hasNextLine()) {
            String datosPais = sc.nextLine();
            stringToPais(datosPais);
        }
    }


    private void stringToPais(String datos) {
        try(Scanner sc = new Scanner(datos)) {
            sc.useDelimiter(",");
            sc.useLocale(Locale.ENGLISH);
            String nomP = sc.next();
            String cont = sc.next();
            double alt = sc.nextDouble();
            Pais pais = new Pais(nomP, cont, alt);
            paises.add(pais);
        } catch (InputMismatchException e) {
            System.err.println("Dato incorrecto en " + datos);
        } catch (NoSuchElementException e) {
            System.err.println("Faltan datos en " + datos);
        }
    }

    public List<Pais> selecciona(Seleccion sel) {
        List<Pais> lista = new ArrayList<>();
        for (Pais pais : paises) {
            if(sel.test(pais)) {
                lista.add(pais);
            }
        }
        return lista;
    }

    public Map<String, Integer> numPaisesPorContinente() {
        Map<String, Integer> map = new HashMap<>();
        for(Pais pais : paises) {
            int veces = map.getOrDefault(pais.getContinente(), 0);
            map.put(pais.getContinente(), veces + 1);
        }
        return map;
    }

    public Map<String, Set<Pais>> paisesPorContinente() {
        Map<String, Set<Pais>> map = new TreeMap<>();//new HashMap<>();
        Comparator<Pais> compA = Comparator.comparingDouble(Pais::getAltura); //(p1, p2) -> Double.compare(p1.getAltura(), p2.getAltura());
        Comparator<Pais> compN = Comparator.comparing(p -> p.getNombre()); //(p1, p2) -> p1.getNombre().compareTo(p2.getNombre());
        Comparator<Pais> comp = compA.thenComparing(compN);
        for (Pais pais : paises) {
            String continente = pais.getContinente();
            Set<Pais> set = map.computeIfAbsent(continente, c -> new TreeSet<>(comp));
            set.add(pais);
            //si se pone un map.put es porque no entendiste el tema!
        }
        return map;
    }

}

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

}

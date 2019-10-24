package org.uma.mbd.mdEjemplo;

import java.util.*;
public class Shuffle {
    public static void main(String args[]) {
// creamos la lista original
        List<String> original = new ArrayList<>();
        for (String arg : args) {
            original.add(arg);
        }
// creamos la copia y la desordenamos
        List<String> duplicado = new ArrayList<>(original);
        Collections.shuffle(duplicado);
// comparamos las dos copias con sendos iteradores
        Iterator<String> iterOriginal = original.iterator();
        Iterator<String> iterDuplicado = duplicado.iterator();
        int mismoSitio = 0;
        while (iterOriginal.hasNext()) {
            if (iterOriginal.next().equals(iterDuplicado.next())) {
                mismoSitio++;
            }
        }
//mostramos el resultado en pantalla
        System.out.println(
                duplicado + ": " + mismoSitio + " en el mismo sitio.");
    }
}
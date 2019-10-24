package org.uma.mbd.mdTesoro;

import org.uma.mbd.mdRectas.rectas.Punto;
import org.uma.mbd.mdTesoro.tesoro.Tesoro;

public class MainTesoro {
    public static void main(String[] args) {
        int pamX = 1, pamY = 0; //palmera amarilla en (pamX, pamY)
        int parX = 13, parY = -35; //fijas palmeras amarillas y azul, cualquier posición de palmera rosa me deja el tesoro en mismo lugar
        int pazX = -1, pazY = 0; //con estas posiciones de palmera amarilla y azul, el tesoro debe estar en (0,1)
        Tesoro tesoro = new Tesoro(new Punto(parX, parY), new Punto(pamX, pamY), new Punto(pazX, pazY));
        System.out.println(tesoro);
    }
}

package org.uma.mbd.mdUrna.urna;

import java.util.NoSuchElementException;
import java.util.Random;

public class Urna {
    public static enum ColorBola {Blanca, Negra}; //prestar atención de cómo se declara (static enum <Nombre> {} y sin igual)
    public int blancas;
    public int negras;
    private static Random alea = new Random();

    public Urna(int blancas, int negras) {
        if(blancas < 0 || negras < 0 || (blancas == 0 && negras == 0)){
            throw new IllegalArgumentException("Número de bolas inválidas");
        } else {
            this.blancas = blancas;
            this.negras = negras;
        }
    }


    public int totalBolas() {
        return blancas + negras;
    }

    public ColorBola extraerBola() {
        int t = totalBolas();
        if(t == 0) {
            throw new NoSuchElementException("No hay bolas");
        }
        int va = alea.nextInt(t+1)+1; //random entre [1,t+1). Si argumento es t se pierde aleatoriedad en el ejercicio.
        ColorBola salida; //se declara una clase ColorBola
        if(va <= blancas) {
            salida = ColorBola.Blanca;
            blancas--;
        } else {
            salida = ColorBola.Negra;
            negras--;
        }
        return salida;
    }

    public void ponerBlanca() {
        blancas++;
    }

    public void ponerNegra() {
        negras++;
    }

    @Override
    public String toString() {
        return "U(" + blancas + ", " + negras + ")";
    }
}

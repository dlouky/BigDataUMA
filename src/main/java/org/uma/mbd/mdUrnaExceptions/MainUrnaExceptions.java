package org.uma.mbd.mdUrnaExceptions;

import org.uma.mbd.mdUrnaExceptions.urna.Urna;

public class MainUrnaExceptions {
    public static void main(String[] args) { //RUN -> Edit Configurations y en Program Arguments le paso los args. Ojo con que Main se selecciona.
        try {
            int nb = Integer.parseInt(args[0]);
            int nn = Integer.parseInt(args[1]);
            Urna u = new Urna(nb, nn);
            System.out.println(u);
            while (u.totalBolas() > 1) {
                Urna.ColorBola b1 = u.extraerBola();
                Urna.ColorBola b2 = u.extraerBola();
                if (b1 == b2) {
                    u.ponerBlanca();
                } else {
                    u.ponerNegra();
                }
            }
            System.out.println(u.extraerBola());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error en la entrada de datos. Debes proporcionar dos argumentos.");
        } catch (NumberFormatException e) {
            System.err.println("Algun dato no es numérico " + e. getMessage());
        } finally {
            System.err.println("No sé como habrá ido pero adiós");
        }
        System.err.println("Y esto que?");
    }

}

package org.uma.mbd.mdUrna;

import org.uma.mbd.mdUrna.urna.Urna;

public class MainUrna {
    public static void main(String[] args) { //RUN -> Edit Configurations y en Program Arguments le paso los args separados por un espacio. Ojo con que Main se selecciona.
        int nb = Integer.parseInt(args[0]);  // en Terminal me paro en C:\Users\dlouk\IdeaProjects\cursombd\target\classes> yle paso java java org/uma/mbd/mdUrna/MainUrna 7 5
        int nn = Integer.parseInt(args[1]);
        Urna u = new Urna(nb, nn);
        System.out.println(u);
        while(u.totalBolas() > 1) {
            Urna.ColorBola b1 = u.extraerBola();
            Urna.ColorBola b2 = u.extraerBola();
            if(b1 == b2) {
                u.ponerBlanca();
            } else {
                u.ponerNegra();
            }
        }
        System.out.println(u.extraerBola());
    }
}

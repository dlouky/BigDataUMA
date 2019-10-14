package org.uma.mbd.mdJarras;

import org.uma.mbd.mdJarras.jarras.Jarra;
import org.uma.mbd.mdJarras.jarras.Mesa;

public class Main {
    public static void main(String[] args) {
        /* 2. Crear dos jarras, una de 5 lts y otra de 7. Realizar las operaciones necesarias para dejar 1 lts en una de las jarras.
        Jarra jarraA = new Jarra(5);
        Jarra jarraB = new Jarra(7);
        jarraA.llena();//A5 B0
        jarraB.llenaDesde(jarraA);//A0 B5
        jarraA.llena();//A5 B5
        jarraB.llenaDesde(jarraA);//A3 B7
        jarraB.vacia();//A3 B0
        jarraB.llenaDesde(jarraA);//A0 B3
        jarraA.llena();//A5 B3
        jarraB.llenaDesde(jarraA);//A1 B7
        System.out.println("La jarra A queda con contenido de: " + jarraA.getContenido() + "litros"); */

         /* 4. Crear una mesa con dos jarras, una de 5 lts y otra de 7.
               Realizar las operaciones necesarias para dejar 1 lts en una de las jarras.*/
        Mesa mesa = new Mesa(5,7);
        mesa.llenaA();//A5 B0
        mesa.vuelcaAsobreB();//A0 B5
        mesa.llenaA();//A5 B5
        mesa.vuelcaAsobreB();//A3 B7
        mesa.vaciaB();//A3 B0
        mesa.vuelcaAsobreB();//A0 B3
        mesa.llenaA();//A5 B3
        mesa.vuelcaAsobreB();//A1 B7
        System.out.println("La jarra A queda con contenido de: " + mesa.getContenidoA());
    }
}

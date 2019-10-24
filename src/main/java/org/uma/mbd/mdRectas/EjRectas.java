package org.uma.mbd.mdRectas;

import org.uma.mbd.mdRectas.rectas.Punto;
import org.uma.mbd.mdRectas.rectas.Recta;

public class EjRectas {
    public static void main(String [] args) {
        // Calcular el área del triángulo formado por tres puntos
        Punto p1 = new Punto(0,0);
        Punto p2 = new Punto(4,0);
        Punto p3 = new Punto(2,3); //area deberia dar 6
        // Se calcula la distancia entre p2 y p3
        double base = p2.distancia(p3);
        // Se calcula la recta que pasa por p2 y p3
        Recta rBase = new Recta(p2,p3);
        // se calcula la distancia entre p1 y rBase
        double altura = rBase.distanciaDesde(p1);
        // El area es base*altura/2
        double area = base*altura/2;
        System.out.printf ("Puntos %s %s %s\n",p1,p2,p3);
        System.out.println ("area = " + area);
        // La perpendicular a rBase por p3
        Punto p4 = new Punto(1,-4);
        Recta rPerpe = rBase.perpendicularPor(p4);
        System.out.println("Perpendicular a " + rBase + " que pasa por " + p4 +"  es: " + rPerpe);
        Recta rPara = rBase.paralelaPor(p1);
        System.out.println("Paralela a " + rBase + " que pasa por " + p1 + " es: " + rPara);
        Punto inter = rPerpe.interseccionCon(rPara);
        System.out.println("Intersección de " + rPerpe + " con " + rPara + " es: " + inter );
    }
}
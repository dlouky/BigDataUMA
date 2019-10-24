package org.uma.mbd.mdPruebaScanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // ------ Uso de la clase Scanner ------------------ No funciona porque cierro System.in en el primer try
        System.out.print("Introduce tu primer apellido y tu edad: ");
        try (Scanner sc = new Scanner(System.in)) {
            String apellido = sc.next();
            int edad = sc.nextInt();
            System.out.println("Datos leídos:");
            System.out.println("Apellido: " + apellido +
                    "\t" + "Edad: " + edad);
        }

        System.out.print("Introduce tu primer apellido y tu edad de nuevo: ");
        try (Scanner sc = new Scanner(System.in)) {
            String apellido = sc.next();
            int edad = sc.nextInt();
            System.out.println("Datos leídos:");
            System.out.println("Apellido: " + apellido +
                    "\t" + "Edad: " + edad);
        }
    }
}

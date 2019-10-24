package org.uma.mbd.mdTestL.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestAsignatura {
    private String nombre;
    private List<Test> examenes;
    private  double vAc;
    private  double vFa;
    private int APROBADO = 5;

    public  TestAsignatura(String n, double va, double vf, List<String> alumnos) {
        nombre = n;
        vAc = va;
        vFa = vf;
        examenes = new ArrayList<>();
        extraeDatos(alumnos);
    }

    public TestAsignatura(String n, List<String> alumnos) {
        this(n, 1, 0, alumnos);
    }

    private void extraeDatos(List<String> alumnos) {
        for(String datoAlumno : alumnos) {
          /*  try (Scanner sc = new Scanner(datoAlumno)) {
                sc.useDelimiter(("[:+]"))
            }*/

            ///////
            String [] campos = datoAlumno.split("[:+]");
            String nA = campos [0];
            int numA = Integer.parseInt(campos[1]);
            int numF = Integer.parseInt(campos[2]);/////////////
            Test test = new Test(nA, numA, numF);
            examenes.add(test);
        }
    }

    public double notaMedia() {
        double sum = 0;
        for(Test test : examenes) {
            sum += test.calificacion(vAc, vFa);
        }
        return sum/examenes.size();
    }

    public int aprobados() {
        int nA = 0;
        for(Test test : examenes) {
            if(test.calificacion(vAc, vFa) >= APROBADO) {
                nA++;
            }
        }
        return nA;
    }

    public String getNombre() {
        return nombre;
    }

}

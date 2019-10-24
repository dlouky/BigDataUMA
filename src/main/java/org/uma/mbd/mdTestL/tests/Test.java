package org.uma.mbd.mdTestL.tests;

public class Test {
    private String alumno;
    int aciertos;
    int errores;

    public Test(String alumno, int aciertos, int errores) {
        this.alumno = alumno;
        this.aciertos = aciertos;
        this.errores = errores;
    }

    public String getAlumno() {
        return alumno;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int getErrores() {
        return errores;
    }

    @Override
    public boolean equals(Object o) {
        boolean res = o instanceof Test;
        Test t = res ? (Test)o : null;
        return res && (t.alumno.equalsIgnoreCase(alumno));
    }

    @Override
    public int hashCode() {
        return alumno.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
    return alumno.toUpperCase() + "[" + aciertos + ", " + errores;
    }

    public double calificacion(double valAc, double valErr) {
        /*double cal = 0;
        if(valAc > 0 && valErr <= 0) {
            cal = (aciertos*valAc + errores*valErr)/(valAc+valErr);
        } else {
            throw new RuntimeException("Las valoraciones no son correctas!!!");
        }
        return cal;*/
        if(valAc <= 0) {
            throw new RuntimeException("Valoración aciertos errónea " + valAc);
        }
        if(valErr > 0) {
            throw new RuntimeException("Valoración fallos errónea " + valErr);
        }
        return aciertos*valAc + errores*valErr;
    }
}

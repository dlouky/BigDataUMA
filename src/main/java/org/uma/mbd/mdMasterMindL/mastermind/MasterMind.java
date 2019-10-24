package org.uma.mbd.mdMasterMindL.mastermind;

import java.util.Random;

public class MasterMind {
    private static final int TAMANO_POR_DEFECTO = 4;
    private static Random alea = new Random();
    protected String combinacionSecreta;

    public MasterMind() {
        // Crea una combinación secreta de tamaño TAMANO_POR_DEFECTO
        this(TAMANO_POR_DEFECTO);
    }

    public MasterMind(int tam) {
        //Crea una combinación secreta de tamaño tam
        if(tam < 1 || tam > 10){
            throw new MasterMindException("Tamaño erróneo! " + tam);
        }

        generaCombinacionSecreta(tam);
    }

    public MasterMind(String secreto) {
        // debe validar el número dado
        combinacionSecreta = secreto;
        if(!validaCombinacion(secreto)){
            throw new MasterMindException("Número secreto erróneo! " + secreto);
        }

    }

    private void generaCombinacionSecreta(int tam) {
        // genera una combinación secreta de tamaño tam
        // no debe tener números repetidos
        if(tam <= 0 || tam > 10){
            throw new MasterMindException("Tamaño del mastermind erróneo, " + tam);
        }
        combinacionSecreta = "";
        int i = 0;
        while(i < tam){
            int n = alea.nextInt(10);
            String ns = Integer.toString(n);
            if(combinacionSecreta.indexOf(ns) < 0){
                combinacionSecreta += ns;
                i++;
            }
        }
    }

    public int getLongitud() {
        // COMPLETAR
        return combinacionSecreta.length();
    }

    private boolean validaCombinacion(String cifrasStr) {
        if (cifrasStr.length() != getLongitud()) {
            return false;
        }
        String patron = "[0-9]";
        for (int i = 1; i < combinacionSecreta.length(); i++) {
            patron += "[0-9&&[^" + cifrasStr.substring(0,i) + "]]";
        }
        return cifrasStr.matches(patron);
    }

    public Movimiento intento(String cifrasStr) {
        // Si no es valida se lanza una excepción

        // En otro caso,
        // calculamos las cifras colocadas y descolocadas
        // y creamos un Movimiento con esos datos
        int colocadas = 0;
        int descolocadas = 0;

        if(!validaCombinacion(cifrasStr)) {
            throw new MasterMindException("Intento no válido " + cifrasStr);
        }

        for(int i = 0; i < combinacionSecreta.length(); i++) {
            if ( combinacionSecreta.charAt(i) == cifrasStr.charAt(i) ) {
                colocadas++;
            } else if ( combinacionSecreta.indexOf(cifrasStr.charAt(i)) >= 0 ) {
                descolocadas++;
            }
        }

        return new Movimiento(cifrasStr, colocadas, descolocadas);
    }

    public String secreto() {
        // COMPLETAR
        return combinacionSecreta;
    }
}

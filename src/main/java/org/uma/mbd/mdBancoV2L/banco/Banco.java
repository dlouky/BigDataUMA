package org.uma.mbd.mdBancoV2L.banco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Banco {
    private static int TAM_ARRAY_CTAS = 10;
    private static final int PRIMER_NUM_CTA = 1001;
    private String nombre; //nombre del banco
    private int ppl; //primera pos libre en el array de Cuenta[]
    private  int snc; //sig numCuenta libre
    private Cuenta[] ctas; //cuentas que posee un banco de nombre n

    public Banco(String n) {
        this(n, TAM_ARRAY_CTAS);
    }

    public Banco(String n, int t) {
        nombre = n;
        ctas = new Cuenta[t];
        ppl = 0;
        snc = PRIMER_NUM_CTA;
    }

    public int abrirCuenta(String titular, double saldoInicial) {
        aseguraQueCabe();
        if(saldoInicial < 0) {
            saldoInicial = 0;
        }
        ctas[ppl] = new Cuenta(titular, snc, saldoInicial);
        ppl++;
        snc++;
        return snc - 1;
    }

    public int abrirCuenta(String titular) {
        return abrirCuenta(titular, 0);
    }

    private void aseguraQueCabe() {
        if(ppl == ctas.length) {
            ctas = Arrays.copyOf(ctas, ppl*2);
        }
    }

    public void cerrarCuenta(int cta) {
        int pos = posicionCuenta(cta); //me da un RuntimeException si no encuentra cta en array ctas
        for(int i = pos + 1; i < ppl ; i++) {
            ctas[i-1] = ctas[i];
        }
        ppl--;
        ctas[ppl] = null; //libera la ultima posicion, de lo contrario quedaría con el último numCta que había antes del borrado
    }

    private int posicionCuenta(int cta) {
        int pos = 0;
        while (pos<ppl && cta!=ctas[pos].getNumCta()) {
            pos++;
        }
        if(pos == ppl) {
            throw new BancoException("No existe la cuenta dada");
        } else {
            return pos;
        }
    }

    public void ingreso(int cta, double ing) {
        int pos = posicionCuenta(cta);
        ctas[pos].ingreso(ing);
    }

    public double debito(int cta, double deb) {
        int pos = posicionCuenta(cta);
        deb = Math.min(deb, ctas[pos].getSaldo());
        ctas[pos].debito(deb);
        return deb;
    }

    public double saldo(int cta) {
        int pos = posicionCuenta(cta);
        return ctas[pos].getSaldo();
    }

    public void transferencia(int origen, int destino, double monto) {
        ingreso(destino, debito(origen, monto));
    }

    public int abrirCuentaVip (String titular, double saldoInicial, double incentivo) {
        int numCtaVip = abrirCuenta(titular, saldoInicial);
        int posCtaVip = posicionCuenta(numCtaVip);
        ctas[posCtaVip] = new CuentaVip(titular, numCtaVip, saldoInicial, incentivo);
        ctas[posCtaVip].ingreso(incentivo);
        return numCtaVip;
    }

    public void cierreEjercicio() {
        for(int i = 0; i < ppl; i++) {
            ctas[i].cierreEjercicio();
        }
    }

    public List<Integer> abrirCuentas (List<String> titulares) {
        List<Integer> numCtas = new ArrayList<>();
        for(String t : titulares) {
            numCtas.add(abrirCuenta(t));
        }
        return numCtas;
    }

    public void cerrarCuentas(List<Integer> numCuentas) {
        try{//si no hago try catch, se lanza la excepcion BancoException desde PosicionCuenta y el programa se detiene.
            for(Integer cta : numCuentas) {
                cerrarCuenta(cta);
            }
        } catch(BancoException e){
            e.printStackTrace();
            System.err.println("Ignoro que la cta que intenté cerrar no existe al pasarla a cerrarCuentas y sigo");
        }
    }

    @Override
    public String toString() {
        String salida = "[";
        for(int i = 0; i < ppl; i++) {
            salida += ctas[i];
            if(i < ppl - 1) {
                salida += " "; //separador entre ctas, salvo que sea la última
            }
        }
        return nombre + ":  " + salida + "]";
    }
}

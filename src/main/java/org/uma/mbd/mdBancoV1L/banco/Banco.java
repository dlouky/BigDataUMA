package org.uma.mbd.mdBancoV1L.banco;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private static final int PRIMER_NUM_CTA = 1001;
    private String nombre; //nombre del banco
    private  int snc; //sig numCuenta libre
    private List<Cuenta> ctas; //cuentas que posee un banco de nombre n

    public Banco(String n) {
        nombre = n;
        ctas = new ArrayList<>();
        snc = PRIMER_NUM_CTA;
    }

    public int abrirCuenta(String titular, int saldoInicial) {
        if(saldoInicial < 0) {
            saldoInicial = 0;
        }
        ctas.add(new Cuenta(titular, snc, saldoInicial));
        snc++;
        return snc - 1;
    }

    public int abrirCuenta(String titular) {
        return abrirCuenta(titular, 0);
    }

    public void cerrarCuenta(int cta) {
        int pos = posicionCuenta(cta); //me da un RuntimeException si no encuentra cta en array ctas
        ctas.remove(pos);
    }

    private int posicionCuenta(int cta) {
        int pos = 0;
        while (pos<ctas.size() && cta!=ctas.get(pos).getNumCta()) {
            pos++;
        }
        if(pos == ctas.size()) {
            throw new RuntimeException("No existe la cuenta dada");
        } else {
            return pos;
        }

    }

    public void ingreso(int cta, double ing) {
        int pos = posicionCuenta(cta);
        ctas.get(pos).ingreso(ing);
    }

    public double debito(int cta, double deb) {
        int pos = posicionCuenta(cta);
        deb = Math.min(deb, ctas.get(pos).getSaldo());
        ctas.get(pos).debito(deb);
        return deb;
    }

    public double saldo(int cta) {
        int pos = posicionCuenta(cta);
        return ctas.get(pos).getSaldo();
    }

    public void transferencia(int origen, int destino, double monto) {
        ingreso(destino, debito(origen, monto));
    }

    @Override
    public String toString() {
        String salida = "[";
        for(int i = 0; i < ctas.size(); i++) {
            salida += ctas.get(i);
            if(i < ctas.size() - 1) {
                salida += " "; //separador entre libros, salvo que sea el ultimo libro
            }
        }

        return nombre + ":  " + salida + "]";
    }
}

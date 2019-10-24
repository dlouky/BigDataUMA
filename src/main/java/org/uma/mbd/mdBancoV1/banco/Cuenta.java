package org.uma.mbd.mdBancoV1.banco;

public class Cuenta {
    private int numCta;
    private double saldo;
    private String titular;

    public Cuenta(String titular, int numCta) {
        this(titular, numCta, 0);
    }

    public Cuenta(String titular, int numCta, double saldo) {
        this.titular = titular;
        this.numCta = numCta;
        this.saldo = saldo;
    }

    public int getNumCta() {
        return numCta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void ingreso(double ing) {
        saldo += ing;
    }

    public void debito(double deb) {
        saldo -= deb;
    }

    public String toString() {
        return "[(" + titular + "/" + numCta + ")" + " -> " + saldo + "]";
    }

}

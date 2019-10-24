package org.uma.mbd.mdBancoV2L.banco;

public class CuentaVip extends Cuenta{
    private double incentivo;

    public CuentaVip(String titular, int numCta, double saldo, double incentivo) {
        super(titular, numCta, saldo);
        this.incentivo = incentivo;
    }

    @Override
    public void cierreEjercicio() {
        super.cierreEjercicio();
        super.ingreso(incentivo);
    }

    @Override
    public String toString() {
        return super.toString() + "$" + incentivo + "$";
    }

}

package org.uma.mbd.mdCoches.coches;

public class CocheImportado extends Coche {
    private double homologacion;

    public CocheImportado(String n, double p, double h) {
        super(n, p);
        homologacion = h;
    }

    @Override
    public double precioTotal() {
        return super.precioTotal() + homologacion;
    }

    //No es necesario redefinir toString ya que el de Coche me sirve (la de la vinculación estática). Observar que al usar el toString de Coche para
    // CocheImportado, el precioTotal() es de CocheImportado (de la vinculación dinámica)



}

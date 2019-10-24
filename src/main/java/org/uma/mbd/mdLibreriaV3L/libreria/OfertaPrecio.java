package org.uma.mbd.mdLibreriaV3L.libreria;

public class OfertaPrecio implements OfertaFlex{
    private  double porDescuento;
    private  double umbralPrecio;

    public OfertaPrecio(double porDescuento, double umbralPrecio) {
        this.porDescuento = porDescuento;
        this.umbralPrecio = umbralPrecio;
    }

    @Override
    public double getDescuento(Libro libro) {
        return (libro.getPrecioBase() >= umbralPrecio) ? porDescuento : 0;
    }

    @Override
    public String toString() {
        return porDescuento + "%" + "(" + umbralPrecio + ")" + "\n";
    }
}

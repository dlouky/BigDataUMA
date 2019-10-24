package org.uma.mbd.mdLibreriaV3L.libreria;

public class LibreriaOfertaFlexible extends Libreria{
    private OfertaFlex ofertaFlexible;

    public LibreriaOfertaFlexible(OfertaFlex ofertaFlex) {
        //super();
        setOferta(ofertaFlex);
    }

    public void setOferta(OfertaFlex ofertaFlex) {
        ofertaFlexible = ofertaFlex;
    }

    public OfertaFlex getOferta() {
        return ofertaFlexible;
    }

    @Override
    public void addLibro (String aut, String tit, double pb) {
        Libro libro = new Libro(aut, tit, pb);
        double descuento = ofertaFlexible.getDescuento(libro);
        if(descuento > 0) {
            libro = new LibroOferta(aut, tit, pb, descuento);
        }
        addLibro(libro);
    }

    @Override
    public String toString() {
        return ofertaFlexible.toString() + super.toString();
    }
}

package org.uma.mbd.mdAlturas.alturas;

public class EnContinente implements Seleccion{
    private String texto;

    public EnContinente(String texto) {
        this.texto = texto;
    }

    @Override
    public boolean test (Pais pais) {
        return pais.getContinente().contains(texto);
    }

}

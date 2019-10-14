package org.uma.mbd.mdTesoro.tesoro;

import org.uma.mbd.mdRectas.rectas.Punto;
import org.uma.mbd.mdRectas.rectas.Vector;

public class Tesoro {
    private Punto pRosa; //palmera rosa
    private Punto pAmarilla;
    private Punto pAzul;
    private Punto eAmarilla; //estaca amarilla
    private Punto eAzul;
    private Punto tesoro;

    public Tesoro(Punto pRosa, Punto pAmarilla, Punto pAzul) {
        this.pRosa = pRosa;
        this.pAmarilla = pAmarilla;
        this.pAzul = pAzul;
        calculaPosiciones();
    }
    
    private void calculaPosiciones(){
        Vector pRosa_pAmarilla = new Vector(pRosa, pAmarilla);
        pRosa_pAmarilla = pRosa_pAmarilla.ortogonal();//giro AH ortogonal= 90º
        eAmarilla = pRosa_pAmarilla.extremoDesde(pAmarilla);

        Vector pRosa_pAzul = new Vector(pRosa, pAzul);
        pRosa_pAzul = pRosa_pAzul.ortogonal().ortogonal().ortogonal();//giro AH ortogonal*3 = 90º*3 = 270º = -90º = giro H ortogonal
        eAzul = pRosa_pAzul.extremoDesde(pAzul);

        tesoro = (new Vector((eAmarilla.getX()+eAzul.getX())/2, (eAmarilla.getY()+eAzul.getY())/2)).extremoDesde(new Punto());
    }

    public void setPalmeraRosa(Punto pRosa) {
        this.pRosa = pRosa;
        calculaPosiciones();
    }

    public void setPalmeraAmarilla(Punto pAmarilla) {
        this.pAmarilla = pAmarilla;
        calculaPosiciones();
    }

    public void setPalmeraAzul(Punto pAzul) {
        this.pAzul = pAzul;
        calculaPosiciones();
    }

    public Punto getEstacaAmarilla() {
        return eAmarilla;
    }

    public Punto getEstacaAzul() {
        return eAzul;
    }

    public Punto getTesoro() {
        return tesoro;
    }

    @Override
    public String toString() {
        return "T(" + tesoro.getX() + ", " + tesoro.getY() + ")";
    }

}

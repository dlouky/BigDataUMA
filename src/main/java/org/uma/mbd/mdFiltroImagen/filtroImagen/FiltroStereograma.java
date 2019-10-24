package org.uma.mbd.mdFiltroImagen.filtroImagen;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class FiltroStereograma implements FiltroImagen {
    private static final int TAM_TRAMA = 80;
    private static final int NUM_CAPAS = 16;
    private static final Random aleatorio = new Random();
    private int tamTrama; //Tamaño de la banda izquierda
    private int numCapas; //Número de capas

    public FiltroStereograma(int tamTrama, int numCapas) {
        this.tamTrama = tamTrama;
        this.numCapas = numCapas;
//        filtra();
    }

    public FiltroStereograma() {
        this.tamTrama = TAM_TRAMA;
        this.numCapas = NUM_CAPAS;
//        filtra();
    }


    @Override
    public void filtra(BufferedImage imagen) {
  /*      BufferedImage stereograma = imagen;
        int fWidth = stereograma.getWidth();
        int fHeight = stereograma.getHeight();
        int tamTrama = 60;

        // Creamos una trama inicial a la izquierda
        for (int x = 0; x < tamTrama; x++) {
            for (int y = 0; y < fHeight; y++) {
                Color color = new Color(	aleatorio.nextInt(256),
                        aleatorio.nextInt(256),
                        aleatorio.nextInt(256));
                stereograma.setRGB(x, y, color.getRGB());
            }
        }
        // Completamos siguiendo el algoritmo
        for (int x = tamTrama; x < fWidth; x++) {
            for (int y = 0; y < fHeight; y++) {
                int capa = 0;
                if (200 < x && x < 800 && 300 < y && y < 600) {
                    capa = 8;
                }
                int nx = x - tamTrama + capa;
                stereograma.setRGB(x, y, stereograma.getRGB(nx, y ));
            }
        }
        ImageIO.write(stereograma, "jpg", new File("recursos/mdFiltroImagen/ejemplo.JPG"));
 */
    }
}

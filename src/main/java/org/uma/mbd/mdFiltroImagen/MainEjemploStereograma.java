package org.uma.mbd.mdFiltroImagen;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MainEjemploStereograma {
    public static Random aleatorio = new Random();

    public static void main(String [] args) throws IOException {
        BufferedImage st = creaStereogramaEjemplo();
        ImageIO.write(st, "jpg", new File("recursos/mdFiltroImagen/ejemplo.JPG"));
    }

    public static BufferedImage creaStereogramaEjemplo() {
        BufferedImage stereograma = new BufferedImage(1200, 800, BufferedImage.TYPE_3BYTE_BGR);
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
        return stereograma;
    }


}

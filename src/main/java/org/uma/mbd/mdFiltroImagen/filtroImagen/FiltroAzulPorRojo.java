package org.uma.mbd.mdFiltroImagen.filtroImagen;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class FiltroAzulPorRojo implements FiltroImagen{

    @Override
    public void filtra(BufferedImage imagen) {
        int fWidth = imagen.getWidth();
        int fHeight = imagen.getHeight();

        for(int x = 0; x < fWidth; x++) {
            for(int y = 0; y < fHeight; y++) {
                int azul = new Color(imagen.getRGB(x, y)).getBlue();
                int rojo = new Color(imagen.getRGB(x, y)).getRed();
                imagen.setRGB(x, y, new Color(azul, 0, rojo).getRGB());
            }
        }
    }
}

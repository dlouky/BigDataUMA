package org.uma.mbd.mdFiltroImagen.filtroImagen;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class FiltroQuitaManchas implements FiltroImagen{

    @Override
    public void filtra(BufferedImage imagen) {
        int fWidth = imagen.getWidth();
        int fHeight = imagen.getHeight();

        for(int x = 0; x < fWidth; x++) {
            for(int y = 0; y < fHeight; y++) {
                int azul = new Color(imagen.getRGB(x, y)).getBlue();
                int rojo = new Color(imagen.getRGB(x, y)).getRed();
                int verde = new Color(imagen.getRGB(x, y)).getGreen();
                if(azul > 200 && rojo > 200 && verde > 200) {
                    imagen.setRGB(x, y, new Color(255, 255, 255).getRGB());
                }
            }
        }
    }
}

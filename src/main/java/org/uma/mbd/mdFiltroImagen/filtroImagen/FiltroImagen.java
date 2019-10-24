package org.uma.mbd.mdFiltroImagen.filtroImagen;

import java.awt.image.BufferedImage;

@FunctionalInterface
public interface FiltroImagen {
    void filtra(BufferedImage imagen);
}

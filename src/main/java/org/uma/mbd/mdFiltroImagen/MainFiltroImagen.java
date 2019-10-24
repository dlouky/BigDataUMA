package org.uma.mbd.mdFiltroImagen;

import org.uma.mbd.mdFiltroImagen.filtroImagen.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainFiltroImagen {
    public static void main(String [] args)  {
        try {
           FiltroImagen st = new FiltroQuitaManchas();
//            FiltroImagen st = new FiltroAzul();
//            FiltroImagen st = new FiltroAzulPorRojo();
//            FiltroImagen st = new FiltroMedia();
//            FiltroImagen st = FiltroMatriz.creaFiltroMedia();
//            FiltroImagen st = FiltroMatriz.creaFiltroBordes();
//            FiltroImagen st = FiltroMatriz.creaFiltroBrillo();
//            FiltroImagen st = FiltroMatriz.creaFiltroEnfoque();
//            FiltroImagen st = new FiltroStereograma(90,8);
            BufferedImage imagen = ImageIO.read(new File("recursos/mdFiltroImagen/espetos.jpg"));
            st.filtra(imagen);
            ImageIO.write(imagen, "png", new File("recursos/mdFiltroImagen/espetos.PNG"));
        } catch (IOException e) {
            System.err.println("Problema de I/O :" + e.getMessage());
        }
    }
}

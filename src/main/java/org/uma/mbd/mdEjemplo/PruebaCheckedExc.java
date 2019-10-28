package org.uma.mbd.mdEjemplo;

import java.io.*;

class PruebaCheckedExc {
    public static void main(String[] args) throws IOException{
        FileReader file = new FileReader("recursos/mdAlturas/alturas.txt");
        //FileReader tiene una Excepción Comprobada (IOException),
        //por lo tanto debe ser tratada o anunciada
        //ya que provoca error en tiempo de compilación. En este ej la anuncio
        //con Throws en el encabezado del main
        BufferedReader fileInput = new BufferedReader(file);

        // Print first 3 lines of file "C:\test\a.txt"
        for (int counter = 0; counter < 3; counter++)
            System.out.println(fileInput.readLine());

        fileInput.close();
    }
}
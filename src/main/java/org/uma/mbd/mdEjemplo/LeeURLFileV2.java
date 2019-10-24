package org.uma.mbd.mdEjemplo;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.net.URL;
public class LeeURLFileV2 {
    public static void main(String[] args) throws IOException, CsvValidationException, CsvException {
        String urlPath = "http://datosabiertos.malaga.eu/recursos/transporte" +
"/EMT/EMTLineasUbicaciones/lineasyubicaciones.csv";
        URL url = new URL(urlPath);
        try (InputStream fs = url.openStream();
             InputStreamReader isr = new InputStreamReader(fs);
             BufferedReader br = new BufferedReader(isr);
             CSVReader csv = new CSVReader(br)) {
            for(String [] datosBus : csv.readAll()) {
                System.out.print("CodBus: " + datosBus[0]);
                System.out.print(" CodLin: " + datosBus[1]);
                System.out.print(" Lon:" + datosBus[3]);
                System.out.println(" Lat: " + datosBus[4]);
            }
/*            csv.readNext();
            String[] datosBus = csv.readNext();
            while (datosBus != null) {
                System.out.print("CodBus: " + datosBus[0]);
                System.out.print(" CodLin: " + datosBus[1]);
                System.out.print(" Lon:" + datosBus[3]);
                System.out.println(" Lat: " + datosBus[4]);
                datosBus = csv.readNext();
            }

 */
        }
    }
}
package org.uma.mbd.mdBusV1L;

//import org.uma.mbd.mdBusV1L.buses.*; no es lo mismo que lo de abajo. Si ponemos * estamos diciendo que en caso que no encuentres la clase la busques aquí. Y si tuviera la clase EnMatricula en otro paquete??? usará esa y no la que quiero que use
import org.uma.mbd.mdBusV1L.buses.Criterio;
import org.uma.mbd.mdBusV1L.buses.EnMatricula;
import org.uma.mbd.mdBusV1L.buses.PorLinea;
import org.uma.mbd.mdBusV1L.buses.Servicio;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MainBuses {
    public static void main(String [] args) {
        Servicio servicio = new Servicio("Malaga");
        try {
        	System.out.println(servicio.getCiudad());
            servicio.leeBuses("recursos/mdBusV1L/buses.txt");
            Criterio cr1 = new PorLinea(21);
            servicio.guarda("recursos/mdBusV1L/linea21.txt", cr1);
            servicio.guarda(new PrintWriter(System.out,true), cr1);
            Criterio cr2 = new EnMatricula("29");
            servicio.guarda("recursos/mdBusV1L/contiene29.txt", cr2);
            servicio.guarda(new PrintWriter(System.out,true), cr2);
        } catch (FileNotFoundException e) {
            System.err.println("No existe el fichero de entrada");
        }
    }
}

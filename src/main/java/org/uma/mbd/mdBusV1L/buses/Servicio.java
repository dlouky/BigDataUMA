package org.uma.mbd.mdBusV1L.buses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Servicio {
    private String ciudad;
    private List<Bus> buses;

    public Servicio(String ciudad) {
        this.ciudad = ciudad;
        buses = new LinkedList<>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void leeBuses(String file) throws FileNotFoundException {
        try (Scanner sc = new Scanner((new File(file)))) {
            leeBuses(sc);
        }
    }

    private void leeBuses(Scanner sc) {
        while(sc.hasNextLine()) {
            String datosBus = sc.nextLine();
            stringToBus(datosBus);
        }
    }

    // escribir /** y enter ==> puedo documentar el método que tiene abajo!!! :-D
    /**
     *
     * @param datos
     * @return
     */

    private void stringToBus(String datos) {
        try(Scanner sc = new Scanner(datos)) {
            sc.useDelimiter(",");
            int codB = sc.nextInt();
            String mat = sc.next();
            int codL = sc.nextInt();
            Bus bus = new Bus(codB, mat);
            bus.setCodLinea(codL);
            buses.add(bus);
        } catch (InputMismatchException e) {
            System.err.println("Dato incorrecto en " + datos);
        } catch (NoSuchElementException e) {
            System.err.println("Faltan datos en " + datos);
        }
    }

    public List<Bus> filtra(Criterio criterio) {
        List<Bus> lista = new ArrayList<>();
        for (Bus bus : buses) {
            if(criterio.esSeleccionable(bus)) {
                lista.add(bus);
            }
        }
        return lista;
    }

    public void guarda(String file, Criterio criterio) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(file)) {
            guarda(pw, criterio);
        }
    }

    public void guarda(PrintWriter pw, Criterio criterio) {
        List<Bus> lista = filtra(criterio);
        for(Bus bus : lista) { //for(Bus bus : filtra(criterio)) {
            pw.println(bus);
        }
    }

}

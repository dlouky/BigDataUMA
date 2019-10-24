import java.io.*;
import java.util.*;
import java.net.URL;
public class LeeURLScanner {
    public static void main(String[] args) throws IOException {
        String urlPath = "http://datosabiertos.malaga.eu/recursos/transporte" +
                "/EMT/EMTLineasUbicaciones/lineasyubicaciones.csv";
        URL url = new URL(urlPath);
        try (Scanner sc = new Scanner(url.openStream())) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
    }
}
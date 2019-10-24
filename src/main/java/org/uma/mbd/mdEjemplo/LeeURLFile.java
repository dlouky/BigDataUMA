import java.io.*;
import java.net.URL;
public class LeeURLFile {
    public static void main(String[] args) throws IOException {
        String urlPath = "http://datosabiertos.malaga.eu/recursos/transporte" +
"/EMT/EMTLineasUbicaciones/lineasyubicaciones.csv";
        URL url = new URL(urlPath);
        try (InputStream fs = url.openStream();
             InputStreamReader isr = new InputStreamReader(fs);
             BufferedReader br = new BufferedReader(isr)) {
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
        }
    }
}
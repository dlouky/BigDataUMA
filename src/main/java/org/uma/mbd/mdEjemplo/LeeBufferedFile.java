import java.io.*;
public class LeeBufferedFile {
    public static void main(String[] args) throws IOException {
        String fichero = "src/main/java/org/uma/mbd/mdEjemplo/Main.java";
        try (InputStream fs = new FileInputStream(fichero);
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

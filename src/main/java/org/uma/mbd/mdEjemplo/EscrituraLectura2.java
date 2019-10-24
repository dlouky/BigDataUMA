import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class EscrituraLectura2 {
    public static void main(String[] args) throws IOException {
        String fichero = "src/main/java/org/uma/mbd/mdEjemplo/datos.txt";
// imprimir un fichero de palabras
        try (PrintWriter pw = new PrintWriter(fichero)) {
            pw.println("amor roma mora ramo");
            pw.println("rima mira");
            pw.println("rail liar");
        }
// leer el fichero de palabras mostrando palabra a palabra
        try (Scanner sc = new Scanner(new File(fichero))) {
            while (sc.hasNextLine()) {
                try (Scanner scLinea = new Scanner(sc.nextLine())) {
                    while (scLinea.hasNext()) {
                        System.out.println(scLinea.next());
                    }
                }
            }
        }
    }
}
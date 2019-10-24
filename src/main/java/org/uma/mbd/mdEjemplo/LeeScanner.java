import java.io.*;
import java.util.*;
public class LeeScanner {
    public static void main(String[] args) throws FileNotFoundException {
        String fichero = "src/main/java/org/uma/mbd/mdEjemplo/Main.java";
        try (Scanner sc = new Scanner(new File(fichero))) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
    }
}
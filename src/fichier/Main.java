import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try {
            Path dossier = Path.of("C:\\Users\\toavina\\MonProjetJava\\src\\dossier");
            System.out.println(dossier);
        } catch (Exception e) {
            System.err.println("Erreur " + e.getMessage());
            e.printStackTrace();
            // TODO: handle exception
        }
    
    }
}

import java.nio.file.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Path dossier = Path.of("C:\\Users\\toavina\\Desktop\\java\\dossier");
        Path fichier = dossier.resolve("fichier.txt");

        try {
            // Créer dossier et fichier
            Files.createDirectories(dossier);
            Files.writeString(fichier, "", StandardOpenOption.CREATE);
            System.out.println("Dossier et fichier prêts");

            // Ajouter du texte
            Files.writeString(fichier, "Nouvelle ligne\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            // Lire le fichier
            String contenu = Files.readString(fichier);
            System.out.println("Contenu du fichier :");
            System.out.println(contenu);

            // Supprimer le fichier
            Files.deleteIfExists(fichier);
            System.out.println("Fichier supprimé (si existant)");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

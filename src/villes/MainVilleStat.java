public class MainVilleStat {
    public static void main(String[] args) {
        VilleStats liste = new VilleStats();
        liste.ajouterVille("Paris", 2200000);
        liste.ajouterVille("Tokyo", 13900000);
        liste.ajouterVille("Antananarivo", 1500000);
        liste.ajouterVille("New York", 8500000);
 
        liste.moyennePopulation();
    }
}
package joueurs;
public class MainJoueur {
    public static void main(String[] args) {

        Joueur joueurs = new Joueur();
        joueurs.ajouterJoueur("Rova" , 10);
        joueurs.ajouterJoueur("Toavina" , 1);
        joueurs.ajouterJoueur("Ravo" , 7);
        joueurs.ajouterJoueur("Rivo" , 12);

        joueurs.plusFaiblejoueur();
    }
}
package livres;
import java.util.HashMap;

public class Bibliotheque {
    //Encapsulation 
    private HashMap<String , Livre> listesLivre ;

    //Constructeur
    public Bibliotheque(){
        listesLivre = new HashMap<>();
    }

    //Méthodes 
    // ajouter un livre 
    public void ajouterLivre(Livre livre){
        if(listesLivre.containsKey(livre.getIsbn())){
            System.err.println("Erreur , ce livre existe déjà dans la liste !");
        }
        else{
            listesLivre.put(livre.getIsbn(), livre);
            System.out.println("Livre ajouté !");
        }
    }

    //Rechercher un livre par ISBN
    public void rechercherParIsbn(String isbn){
        if(listesLivre.isEmpty()){
            System.err.println("Erreur , la bibliotheque est vide.");
        }
        else{
            if(listesLivre.containsKey(isbn)){
               listesLivre.get(isbn).toStringLivre();
            }
        }
    }

    //Rechercher des livres par auteur
    public void rechercherParAuteur(String auteur){
        if (listesLivre.isEmpty()) {
            System.err.println("Erreur , la bibliothèque est vide. ");
        }
        else{
            for(String isbn : listesLivre.keySet()){
                for(Livre livre : listesLivre.values()){
                    if (livre.getAuteur()==auteur) {
                        livre.toStringLivre();
                    }
                }
            }
        }
    }
}                                                      
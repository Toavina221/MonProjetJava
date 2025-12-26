package films;
import java.util.HashMap;
public class GestionFilms {
    //Encapsulation
    private HashMap<String,Film> films;

    //Constructeur
    public GestionFilms(){
        this.films = new HashMap<>();
    }

    //Méthodes
    // Ajouter un film
    public void ajouterFilm(String titre , String realisateur){
        if (films.containsKey(titre)) {
            System.err.println("Ce film existe déjà");
        }
        else{
            Film film = new Film(titre, realisateur);
            films.put(titre, film);
            System.out.println("Film  ajouté : " + titre);
        }
    }

    //Afficher tous les films
    public void afficherFilms(){
        if(films.isEmpty()){
            System.out.println("Aucun film disponible ");
            return ;
        }
        else{
            for(String titre : films.keySet()){
                Film film = films.get(titre);
                System.out.println("Titre : " + titre + " réalisateur : " + film.getRealisateur());
            }
        }
    }

    //Ajouter une note à un fim précis 
    public void noterFilm(String titre , double note){
        if(films.containsKey(titre)){
            Film film = films.get(titre);
            film.ajouterNote(note); 
        }
        else{
            System.err.println("Erreur , ce film n'est pas disponible ");
            return ;
        }
    }

    //Afficher les statistiques d'un film
    public void afficherStats(String titre){
        if(films.containsKey(titre)){
            Film film = films.get(titre);
            film.afficherNotes();
            System.out.println(" Moyenne des notes : " + film.moyenne());
            System.out.println(" Meilleur note : "+ film.meilleureNote()); 
            System.out.println(" Plus faible  note : "+ film.plusFaibleNote());
            
        }
        else{
            System.err.println("Erreur , ce film n'est pas disponible "); 
        }
    }
    


}

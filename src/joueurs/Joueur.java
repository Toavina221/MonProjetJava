import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

public class Joueur{
    //Encapsulation 
    private HashMap<String , Integer> joueurs ;

    //Constructeur
    public Joueur(){
        this.joueurs = new HashMap<>();
    }

    //ajouter Joueur
    public void ajouterJoueur(String nom , Integer score){
        joueurs.put(nom , score);
        System.out.println("Joueur ajouté !");
    }

    //modifier le score
    public void modifierScore(String nom ,Integer score){
        if(joueurs.containsKey(nom)){
            joueurs.put(nom , score);
            System.out.println("score modifié !");
        }
        else{
            System.err.println("Erreur , ce joueur " + nom + " ne figure pas dans la liste!");
        }
    }

    //afficher tous les scores
    public void afficherScores(){
        if(joueurs.isEmpty()){
            System.out.println("Erreur  ,La liste est vide ! ");
        }
        else{
            for(String nom : joueurs.keySet()){
                System.out.println("joueur : " + nom  + "\t score :" + joueurs.get(nom));
            }
        }
    }

    //meilleur joueur
    public void meilleurJoueur(){
        Integer meilleurScore = Collections.max(joueurs.values());
        System.out.println("Meilleur Score : " + meilleurScore);
        String meilleurJoueur =Collections.max(joueurs.entrySet(),Map.Entry.comparingByValue()).getKey();
        System.out.println("Meilleur Joueur : " + meilleurJoueur ) ;
    }

    //trier par ordre croissant
    public void trierParOrdreCroissant(){
        List<Map.Entry<String ,Integer>> liste = new ArrayList<>(joueurs.entrySet());
        Collections.sort(liste, Map.Entry.comparingByValue());
        System.out.println("Liste par ordre croissant");
        for (Map.Entry<String,Integer> entry : liste){
            System.out.println("joueur : " + entry.getKey() + "score : "+ entry.getValue());
        }
    }

    public void trierParOrderDecroissant(){
        List<Map.Entry<String,Integer>> liste = new ArrayList<>(joueurs.entrySet());
        Collections.sort(liste,Map.Entry.comparingByValue(Comparator.reverseOrder()) );
        System.out.println("liste par ordre décroissante");
        for(Map.Entry<String,Integer> entry : liste){
            System.out.println("joueur : " + entry.getKey() + "score  :" + entry.getValue());
        }
    }

    public void moyenneScores(){
        if(joueurs.isEmpty()){
            System.err.println("Erreur , la liste est vide !");
        }
        else{
            Integer somme = 0 ;  
            for(Map.Entry<String , Integer> entry : joueurs.entrySet()){
                somme += entry.getValue();
            }
            double moyenne = somme.doubleValue()/joueurs.entrySet().size();
            System.out.println("La moyenne de tout les scores est de : "  + moyenne);
        }
    }
    
    public void plusFaiblejoueur(){
        if(joueurs.isEmpty()){
            System.err.println("Erreur , la liste est vide !");
        }
        else{
            Map.Entry<String , Integer> score = Collections.min(joueurs.entrySet(),Map.Entry.comparingByValue());
            System.out.println("Le score le plus faible est de : " + score.getValue() + "et le joueur le plus faible est " + score.getKey());
        }
    }
}
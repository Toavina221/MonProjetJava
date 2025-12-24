import java.util.ArrayList;
import java.util.HashMap;

public class GestionNotes{
    //Encapsulation
    private HashMap<String,ArrayList<Integer>> notesEleves ;

    //Constructeur
    public GestionNotes(){
        this.notesEleves = new HashMap<>();
    }

    //Méthodes
    //ajouter un eleve 
    public void ajouterEleve(String nom){
        if(notesEleves.containsKey(nom)){
            System.err.println("Erreur , cet élève est déja inscrit dans la liste ");
        }
        else{
            notesEleves.put(nom,  new  ArrayList<Integer>());
            System.out.println("Elève " + nom  + " ajouté dans la liste  !");
        }
    }

    //ajouter une note a un élève 
    public void ajouterNote(String nom , Integer note){
        if(notesEleves.containsKey(nom)){
            ArrayList<Integer> notes = notesEleves.get(nom);
            notes.add(note);
            System.out.println("Note: " + note + " attribué à "+ nom);
        }
        else{
            System.err.println("L'eleve " + nom + " n'est pas encore dans la liste!");
        }
    }

    //calcul de la moyenne d'un élève
    public double calculerMoyenne(String nom){
        if(notesEleves.containsKey(nom)){
            ArrayList<Integer> notes = notesEleves.get(nom);
            if (notes.isEmpty()) {
                System.err.println(nom + "n'a pas encore des notes !");
                return 0;
            }
            else{
                Integer somme = 0 ;
                for(Integer note : notes){
                    somme += note ;
                }
                double moyenne = (double) somme/ notes.size();
                System.out.println( nom + " a obtenu une moyenne de : " + moyenne) ;
                return moyenne ;
            }
        }  
        else{
            System.err.println("Erreur , l'éleve n'est pas dans la liste");
            return 0;
        }
    }


}
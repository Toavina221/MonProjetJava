 package films; 
 import java.util.ArrayList;
 import java.util.Collections ;
 import java.util.Comparator;

public class Film {
    //encapsulation
    private String titre ;
    private String realisateur ;
    private ArrayList<Double> notes ;

    //Constructeur 
    public Film(String titre , String realisateur){
        this.titre = titre ;
        this.realisateur = realisateur ;
        this.notes = new ArrayList<>();
    }

    //Méthodes 
    public void ajouterNote(double note){
        if(note<=10 && note >=0){
            notes.add(note);
            System.out.println("Note ajoutée au film " + titre);
        }
        else{
            System.err.println("Erreur : note invalide (doit être entre 0 et 10)");
        }
    }

    // Afficher toutes les notes 
    public void  afficherNotes(){
        if (notes.isEmpty() ) {
            System.out.println(" La liste des notes pour ce film est vide ");
        }
        else{
            System.out.println("Notes du film " + titre + " : " );
            System.out.print("[");
            for(Double note : notes){
                System.out.print(note +"  ");
            }
            System.out.print("]");
        }
    } 

    //calculer la moyenne d'une film 
    public double moyenne(){
        if(notes.isEmpty()){
            System.out.println("Erreur  : notes vide pour ce film  ");
            return 0.0;
        }
        else{
            double somme = 0.0;
            for(double note : notes){
                somme += note ;
            }
            double moyenne = somme/notes.size();
            System.out.println("Titre :" + titre + "\t Moyenne des notes " + moyenne);
            return moyenne ;
        }
    }

    // trouver la meilleur note 
    public double meilleureNote(){
        if(notes.isEmpty()){
            System.out.println("Notes indisponibles");
            return 0.0 ;
        }
        else{
            double meilleur = Collections.max(notes);
            return meilleur ;
        }
    }

    // trouver  la plus faible note 
    public double plusFaibleNote(){
        if(notes.isEmpty()){
            System.out.println("Notes indisponibles");
            return 0.0 ;
        }
        else{
            return Collections.min(notes) ;
        }
    }

    

}
package ville;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator; 
import java.util.ArrayList ;

public class VilleStats {
    //Encapsulation 
    private HashMap<String, Integer> GestionVille  ;

    //constructeur 
    public VilleStats(){
        this.GestionVille = new HashMap<>(); 
    }

    //methodes 
    //ajouter une ville 
    public void ajouterVille(String ville , Integer stat){
        if (GestionVille.containsKey(ville)) {
            System.err.println("Erreur , cette liste figure déja dans la liste !");
        }
        else{
        GestionVille.put(ville , stat);
        System.out.println("ville " + ville + " ajouté ");
        }
    }

    //modifier la population d'une ville 
    public void modifierStat(String ville , Integer nouveauStat){
        if (GestionVille.containsKey(ville)) {
            GestionVille.put(ville, nouveauStat);
            System.out.println("populattion de la ville " + ville  + " modifiée en : " + nouveauStat);
        }
        else{
            System.err.println("Erreur , cette ville n'est pas dans la liste , veuillez l'ajouter !!! ");
        }
    }

    //afficher tous les villes
    public void afficherTous(){
        if (GestionVille.isEmpty()){
            System.err.println("Erreur ,   la liste est vide !!! ");
        }
        else{
            for(String  ville   :  GestionVille.keySet()){
                System.out.println("Nom du ville : " + ville + " a une population de : " +   GestionVille.get(ville));
            }
        }
    }

    //trouver la ville la plus peuplée (max)
    public void villePeuplée(){
        if (GestionVille.isEmpty()) {
            System.err.println("Erreur la liste est vide ! On ne peut pas trouver le maximum des stats ! ");
        }
        else{
            Map.Entry<String,Integer> entry = Collections.max(GestionVille.entrySet(),Comparator.comparing(Map.Entry::getValue));
            System.out.println(" la ville la plus peuplée est : " + entry.getKey() + " admettant " + entry.getValue() + " peuple .");
        }
    }

    public void villeMoinsPeuplée(){
        if(GestionVille.isEmpty()){
            System.err.println("Erreur , la liste est vide , on ne peut pas trouver la valeur minimum de la statistique !");
        }
        else{
            Map.Entry<String , Integer> entry = Collections.min(GestionVille.entrySet(),Comparator.comparing(Map.Entry::getValue));
            System.out.println("la valeur mimimum  est " + entry.getValue() + " dont la ville correspondante est : " + entry.getKey() );
        }
    }

    //trier les villes 
    public void trierParOrdreCroissant(){
        if(GestionVille.isEmpty()){
            System.err.println("Erreur , la liste est vide.");
        }
        else{
            List<Map.Entry<String,Integer>> liste  = new ArrayList<>(GestionVille.entrySet());
            Collections.sort(liste,Comparator.comparing(Map.Entry::getValue));
            for(Map.Entry<String , Integer> entry :liste){
                System.out.println("ville : " + entry.getKey() + " population : " + entry.getValue());
            }
        }
    }

    //trier par ordre decroissant
    public void trierParOrdreDecroissant(){
        if(GestionVille.isEmpty()){
            System.out.println("Erreur , la liste est vide.");
        }
        else{
            List<Map.Entry<String,Integer>> liste = new ArrayList<>(GestionVille.entrySet());
            Collections.sort(liste, (entry1, entry2) -> 
                entry2.getValue().compareTo(entry1.getValue()));
            for(Map.Entry<String,Integer> entry : liste){
                System.out.println("ville : " + entry.getKey() + " population : " + entry.getValue());
            }
        }
    }

    //Calculer population totale
    public void  totalePopulation(){
        Integer somme = 0 ;
        for (String ville : GestionVille.keySet()){
            somme += GestionVille.get(ville);
        }
        System.out.println("On a  " + somme + " population en total ! (" + GestionVille.size() +" villes)");
    }

    //calculer moyenne 
    public double moyennePopulation(){
        Integer somme = 0 ;
        for (String ville : GestionVille.keySet()){
            somme += GestionVille.get(ville);
        }
        double moyenne  =(double) somme/ GestionVille.size();
        System.out.println("On a  " + moyenne + " population en moyenne ! (" + GestionVille.size() +" villes)");
        return moyenne ;
    }
    // 
    
}
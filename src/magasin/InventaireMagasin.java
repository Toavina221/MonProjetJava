package magasin;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class InventaireMagasin{
    //Encapsulation
    private HashMap<String,Integer> listeProduit ;

    //Constructeur
    public InventaireMagasin(){
        this.listeProduit = new HashMap<>();
    }

    //Méthodes
    //ajouter produit
    public void ajouterProduit(String nom , Integer quantite){
        if (listeProduit.containsKey(nom)) {
            System.err.println("Erreur , ce produit existe déja dans la liste !");
        }
        else{
            listeProduit.put(nom, quantite);
            System.out.println("produit " + nom + " ajouté (" + quantite + " ).");
        }
    }

    //Modification quantite
    public void modifierQuantite(String nom , Integer nouvelleQuantite){
        if(listeProduit.containsKey(nom)){
            listeProduit.put(nom , nouvelleQuantite);
            System.out.println("Quantité du produit : " + nom +" modifiée en : "+ nouvelleQuantite);
        }
        else{
            System.err.println("Erreur , le produit n/'existe pas ");
        }
    }

    //supprimer produit
    public void supprimerProduit(String nom){
        if(listeProduit.containsKey(nom)){
            listeProduit.remove(nom);
            System.out.println("produit" + nom + " supprimé de la liste !");
        }
        else{
            System.err.println("Erreur , la liste ne contient pas ce produit (deja supprimer peut être).");
        }
    }

    //affichage de tous les produits
    public void afficherProduits(){
        if(listeProduit.isEmpty()){
            System.err.println("Erreur , la liste est vide (rien n'a affiché) !");
        }
        else{
            for (String entry : listeProduit.keySet()){
                System.out.println("Produit : " + entry + " quantité " + listeProduit.get(entry));
            }
        }
    }

    // trier le produit par ordre croissant du produit
    public void trierProduitCroissante(){
        if (listeProduit.isEmpty()) {
            System.err.println("Erreur , la liste est vide !");
        }
        else{
            System.out.println("triage par ordre croissante en quantité des produits");
            System.out.println("-----------------------------------------------------------  ");
            List <Map.Entry<String , Integer>> liste = new ArrayList<>(listeProduit.entrySet());
            Collections.sort(liste , (entry1 ,entry2)->entry1.getValue().compareTo(entry2.getValue()));
             for(Map.Entry<String , Integer> entry : liste){
                System.out.println("Nom du produit : " + entry.getKey() + "quantité : " + entry.getValue() );
             }
        }
    }

    public void trierProduitDecroissante(){
        if(listeProduit.isEmpty()){
            System.err.println("Erreur, la liste est vide !");
        }
        else{
            System.out.println("Triage par ordre décroissante par quantité  des produits  ");
            System.out.println("-----------------------------------------------------------  ");
            List <Map.Entry<String , Integer>> liste = new ArrayList<> (listeProduit.entrySet());
            Collections.sort(liste , (entry1 , entry2)-> entry2.getValue().compareTo(entry1.getValue()));
            for(Map.Entry<String,Integer> entry : liste){
                System.out.println("Produit : " + entry.getKey() + " quantité : " + entry.getValue());
            }
        }
    }

    //calculer la quantité  totale de stock
    public void totaleQuantite(){
        if(listeProduit.isEmpty()){
            System.err.println("La liste est vide ,   la quantité totale vaut donc 0 !");
        }
        else{
            Integer total = 0 ;
            for (String entry : listeProduit.keySet()){
                total += listeProduit.get(entry);
            }
            System.out.println("La quantité totale des produits vaut : " + total );
        }
    }

    //calculer la moyenne 
    public void moyenneQuantite(){
        if(listeProduit.isEmpty()){
            System.err.println("Erreur , la liste est vide , la moyenne vaut donc 0 !");
        }
        else{
            Integer total  = 0;
        for(String entry: listeProduit.keySet()){
            total += listeProduit.get(entry);
        }
        double moyenne = (double) total / listeProduit.size();
        System.out.println("La moyenne des quantités est de : " + moyenne );
        }
    }
}
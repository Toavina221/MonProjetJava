package etudiants;
import java.util.ArrayList;
import java.util.HashMap;
 
public class GestionEtudiants  {
    // Encapsulation 
    private HashMap<String,Etudiant> listeEtudiant ;

    //Constructeur 
    public GestionEtudiants(){
        this.listeEtudiant = new HashMap<>();
    }

    //Méthodes ajouter un etudiant dans la liste
    public void ajouterEtudiant(Etudiant etudiant){
        if(listeEtudiant.containsKey(etudiant.getMatricule())){
            System.err.println("Erreur , cet élève existe déja dans la liste");
        }
        else{
        listeEtudiant.put(etudiant.getMatricule(), etudiant);
        // System.out.println("Etudiant " + etudiant.getPrenom()  + " ajouté dans la liste ");
        }

    }

    //Supprimer un étudiant
    public void supprimerEtudiant(String matricule){
        if(listeEtudiant.containsKey(matricule)){
            listeEtudiant.remove(matricule);
            System.out.println("Etudiant supprimé de la liste");
        }
        else{
            System.err.println("Erreur , l'étudiant ne figure pas dans la liste.");
        }
    }

    //rechercher un etudiant par sa matricule
    public Etudiant rechercherParMatricule(String matricule){
        if(listeEtudiant.isEmpty()){
            System.err.println("Erreur , la liste est vide ");
            return null;
        }
         else if(listeEtudiant.containsKey(matricule)){
            Etudiant etudiant = listeEtudiant.get(matricule);
            etudiant.toStringEtudiant();
            return etudiant;
        }
        else{
            System.err.println("Erreur , matricule introuvable ");
            return null;
        }
    }

    //rechercher un etudiant  par nom 
    public ArrayList<Etudiant> rechercherParNom(String nom){
        if(listeEtudiant.isEmpty()){
            System.err.println("Erreur , la liste est vide ");
            return new ArrayList<>();
        }
        else{   
            ArrayList<Etudiant> listeMemeNom = new ArrayList<>();
            for(Etudiant etudiant : listeEtudiant.values()){
                if(etudiant.getNom().equalsIgnoreCase(nom)){
                    listeMemeNom.add(etudiant);
                }   
            }
            System.out.println("Les élèves portant le nom de : " + nom  + " sont (" + listeMemeNom.size() + ") : " );
            for(Etudiant etudiant : listeMemeNom){
                etudiant.toStringEtudiant();
            }
            return listeMemeNom;
        }
    }

    //Modifier la moyenne d'un etudiant 
    public boolean modifierMoyenne(String matricule , double nouvelleMoyenne){
        if(listeEtudiant.containsKey(matricule)){
            if(nouvelleMoyenne > 0 && nouvelleMoyenne <= 20){
                Etudiant etudiant = listeEtudiant.get(matricule);
                etudiant.setMoyenne(nouvelleMoyenne);
                System.out.println("Moyenne de " + etudiant.getNom() + " modifié ");
            }
            return true ;
        }
        else{
            System.err.println("Erreur , matricule  introuvable ");
            return false;
        }
    }

    //afficher tous les etudiants
    public void afficherToutEtudiants(){
        if(listeEtudiant.isEmpty()){
            System.err.println("Erreur , la liste est vide ");
        }
        else{
            System.out.println("Listes de tous les élèves :");
            System.out.println("----------------------------");
            for(Etudiant etudiant : listeEtudiant.values()){
                etudiant.toStringEtudiant();
            }
            System.out.println("Total : " + listeEtudiant.size() + " étudiant ");
        }
    }

    //afficher les etudiants admis
    public ArrayList<Etudiant> afficherEtudiantsAdmis(){
        if (listeEtudiant.isEmpty()) {
            System.err.println("Erreur , la liste est vide ");
            return new ArrayList<>();
        }
        else{
            System.out.println("Les etudiants admis sont : ");
            System.out.println("----------------------------");
            ArrayList<Etudiant> listeAdmis = new ArrayList<>();
            for(Etudiant etudiant : listeEtudiant.values()){
                if(etudiant.estAdmis()){
                    System.out.println("Etudiant : " + etudiant.getMatricule() + " Nom : " + etudiant.getNom() );
                    listeAdmis.add(etudiant);
                    
                }
            }
            return listeAdmis;
        }
    }

    //afficher les etudiants par filieres
    public ArrayList<Etudiant> afficherEtudiantParFiliere(String filiere){
        ArrayList<Etudiant> listeParFiliere = new ArrayList<>();
        for(Etudiant etudiant : listeEtudiant.values()){
            if (etudiant.getFiliere().equalsIgnoreCase(filiere)) {
                listeParFiliere.add(etudiant);
            }
        }
        System.out.println("Listes des étudiants en " + filiere);
        System.out.println("----------------------------------- " );
        for(Etudiant etudiant : listeParFiliere){
            System.out.println("Matricule : " + etudiant.getMatricule() + " Nom : " + etudiant.getNom());
        }
        return listeParFiliere;
    } 
}

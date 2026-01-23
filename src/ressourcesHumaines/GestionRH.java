package ressourcesHumaines;

import java.util.HashMap;
import java.util.Optional;
import java.util.ArrayList;

public class GestionRH {
    //Encapsulation
    private HashMap<String, Employe> employes = new HashMap<>();
    private HashMap<String, Departement> departements = new HashMap<>() ;
    private HashMap<String, Conge> conges = new HashMap<>();
    private HashMap<String, Evaluation> evaluations = new HashMap<>();
    private HashMap<String, ArrayList<Conge>> planningConges = new HashMap<>();
    private String nomEntreprise;
    private int anneeFiscal;

    //Méthodes
    //Constructeur 
    public GestionRH(String nomEntreprise, int anneeFiscal){ 
        if (nomEntreprise == null || nomEntreprise.trim().isEmpty()) 
            throw new IllegalArgumentException("Le nom de l'entreprise ne peut pas être vide ou null");
        this.nomEntreprise = nomEntreprise;
        if (anneeFiscal < 2000 || anneeFiscal > 2100) 
            throw new IllegalArgumentException("Année fiscale invalide");
        this.anneeFiscal = anneeFiscal;
    }

    //Getters
    public HashMap<String, Employe> getEmployes(){return employes;}
    public HashMap<String, Departement> getDepartements(){return departements;}
    public HashMap<String, Conge> getConges(){return conges;}
    public HashMap<String, Evaluation> getEvaluations(){return evaluations;}
    public HashMap<String, ArrayList<Conge>> getPlanningConges(){return planningConges;}
    public String getNomEntreprise(){return nomEntreprise;}
    public int anneeFiscal(){return anneeFiscal;}

    //GESTION EMPLOYES
    //Embaucher un employé
    public void embaucherEmploye(Employe e){
        if (e != null) {
            if(employes.containsKey(e.getMatricule())){System.out.println("Cet employé est déja enregistrés");}
            else employes.put(e.getMatricule(), e);
        }
        else throw new IllegalArgumentException("L'employe embauché ne peut pas être null");
    }

    //Licencier un employé
    public void licencierEmploye(String matricule){
        if(matricule == null || matricule.trim().isEmpty()){
            throw new IllegalArgumentException("Le matricule ne peut pas être null ou vide");
        }
        if(employes.containsKey(matricule)){
            employes.remove(matricule);
            System.out.println("Employé licencié");
        }
        else{
            System.out.println("Employé introuvable ");
        }
    } 

    //rechercher un employé 
    public Optional<Employe> rechercherEmploye(String matricule){
        if (matricule == null || matricule.trim().isEmpty()) {
            throw new IllegalArgumentException("Le matricule ne peut pas être null ou vide");
        }
        Optional<Employe> employe = Optional.ofNullable(employes.get(matricule));
        if ( employe.isEmpty()) {
            System.err.println("Employé introuvable");
        }
            return employe;
    }

    
}

package ressourcesHumaines;
import java.time.LocalDate;
import java.time.Period;

public class Employe {
    //Encapsulation
    private String matricule;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private LocalDate dateEmbauche;
    private String poste;
    private String departement;
    private double salaireBase;
    private int niveauExperience;
    private String statut;
    private String telephone;
    private String email;
    private String adresse;

    //Méthodes
    //Constructeur
    public Employe(String matricule, String nom, String prenom, LocalDate dateNaissance, LocalDate dateEmbauche , String poste, String departement, double salaireBase, int niveauExperience, String statut, String telephone, String email, String adresse){
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.dateEmbauche = dateEmbauche;
        this.poste = poste;
        this.departement = departement;
        this.salaireBase = salaireBase;
        if (niveauExperience >= 1 && niveauExperience <=5) {
            this.niveauExperience = niveauExperience;
        }
        this.statut = statut;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
    }

    //Getters
    public String getMatricule(){return matricule;}
    public String getNom(){return nom;}
    public String getPrenom(){return prenom;}
    public LocalDate getDateNaissance(){return dateNaissance;}
    public LocalDate getDateEmbauche(){return dateEmbauche;}
    public String getPoste(){return poste;}
    public String getDepartement(){return departement;}
    public double getSalaireBase(){return salaireBase;}
    public int getNiveauExperience(){return niveauExperience;}
    public String getStatut(){return statut;}
    public String getTelephone(){return telephone;}
    public String getEmail(){return email;}
    public String getAdresse(){return adresse;}

    //Setters
    public void setMatricule(String matricule){
        this.matricule = matricule;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public void setDateNaissance(LocalDate dateNaissance){
        this.dateNaissance = dateNaissance;
    }
    public void setDateEmbauche(LocalDate dateEmbauche){
        this.dateEmbauche = dateEmbauche;
    }
    public void setPoste(String nouveauPoste){
        this.poste = nouveauPoste;
    }
    public void setDepartement(String departement){
        this.departement = departement;
    }
    public void setSalaireBase(double salaireBaseActuel){
        this.salaireBase = salaireBaseActuel;
    }
    public void setNiveauExperience(int niveauExperienceActuel){
        this.niveauExperience = niveauExperienceActuel;
    }
    public void setStatut(String statutActuel){
        this.statut = statutActuel;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setAdresse(String adresse){
        this.adresse =  adresse;
    }

    //toString()
    public String toString(){
        return "Matricule : " + matricule + 
        "\nPoste : " + poste + 
        "\nStatut : " + statut ;
    }

    // calculer l'années dans l'entreprise
    public int calculerAnciennete(){
        return Period.between(dateEmbauche,LocalDate.now()).getYears();
    }

    //calculer l'age actuel de l'employe 
    public int calculerAge(){
        return Period.between(dateNaissance, LocalDate.now()).getYears();
    }

    //true si embauhé depuis moins de 3 mois 
    public boolean estEnEssai(){
        Period p = Period.between(dateEmbauche, LocalDate.now());
        return (p.getYears() == 0) && (p.getMonths() < 3);
    }

    // calculer le salaire mensuel
    public double calculerSalaireMensuel(){
        double prime = salaireBase * (niveauExperience * 0.05);
        return salaireBase+prime;
    }
}
package hopital;

import java.time.LocalDateTime;

public class Medecin {
    //Encapsulation
    private String idMedecin;
    private String nom; 
    private String prenom;
    private String specialite;
    private String numeroRPPS;
    private int anneesExperience;
    private boolean disponibilite;
    private int nombrePatientsMax;

    //constructeur 
    public Medecin(String idMedecin, String nom, String prenom, String specialite, String numeroRPPS, int anneesExperience, boolean disponibilite, int nombrePatientsMax){
        this.idMedecin = idMedecin;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.numeroRPPS = numeroRPPS;
        this.anneesExperience = anneesExperience;
        this.disponibilite = disponibilite;
        this.nombrePatientsMax = nombrePatientsMax;
    }

    //Getters
    public String getIdMedecin(){return idMedecin;}
    public String getNom(){return nom;}
    public String getPrenom(){return prenom;}
    public String getSpecialite(){return specialite;}
    public String getNumeroRPPS(){return numeroRPPS;}
    public int getAnneesExperience(){return anneesExperience;}
    public boolean getDisponibilite(){return disponibilite;}
    public int getNombrePatientsMax(){return nombrePatientsMax;}

    //Setters
    public void setIdMedecin(String nouveauIdMedecin){
        this.idMedecin = nouveauIdMedecin;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public void setSpecialite(String specialite){
        this.specialite = specialite;
    }
    public void setNumeroRPPS(String numeroRPPS){
        this.numeroRPPS = numeroRPPS;
    }
    public void setAnneesExperience(int anneesExperience){
        this.anneesExperience = anneesExperience;
    }
    public void isDisponibilite(boolean disponibilite){
        this.disponibilite = disponibilite;
    }
    public void setNombrePatientsMax(int nombrePatientsMax){
        this.nombrePatientsMax = nombrePatientsMax;
    }

    //Méthodes
    //toString 
    public String toString(){
        return 
            "Identifiant : " + idMedecin + 
            "\n Nom : " + nom + 
            "\n Prenom : " + prenom +
            "\n Specialité : " + specialite + 
            "\n Numéro RPPS : " + numeroRPPS +
            "\n Année d'experience : " + anneesExperience +
            "\n Disponibilité : " + disponibilite +
            "\n nombre Patient Max : " + nombrePatientsMax
        ;
    }

    // public boolean peutPrendreNouveauPatient(String idMedecin, LocalDateTime date, int duree){
    //     Medecin medecin = medecins.get(idMedecin);
    //     for(RendezVous ancienrendezVous : rendezVous.values()){
    //         if (ancienrendezVous.getMedecin) {
                
    //         }
    //     }
    // }
}

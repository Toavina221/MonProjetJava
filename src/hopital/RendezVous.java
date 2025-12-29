package hopital;

import java.time.LocalDateTime;
 

public class RendezVous {
    //Encapsulation 
    private String idRendezVous;
    private Patient patient;
    private Medecin medecin;
    private LocalDateTime dateHeure;
    private String motif;
    private int duree;
    private String statut;
    private String salle;

    //Constructeur
    public RendezVous(String idRendezVous, Patient patient, Medecin medecin,  LocalDateTime dateHeure, String motif, int duree, String statut, String salle){
        this.idRendezVous = idRendezVous;
        this.patient =  patient;
        this.medecin = medecin;
        this.dateHeure = dateHeure;
        this.motif = motif;
        this.duree = duree;
        this.statut = statut;
        this.salle = salle;
    }

    //Getters
    public String getIdRendezVous(){return idRendezVous;}
    public Patient getPatient(){return patient;}
    public Medecin getMedecin(){return medecin;}
    public LocalDateTime getDateHeure(){return dateHeure;}
    public String getMotif(){return motif;}
    public int getDuree(){return duree;}
    public String getStatut(){return statut;}
    public String getSalle(){return salle;}

    //Setters
    public void setIdRendezVous(String idRendezVous){
        this.idRendezVous = idRendezVous;
    }
    public void setPatient(Patient patient){
        this.patient = patient;
    }
    public void setMedecin(Medecin medecin){
        this.medecin = medecin; 
    }
    public void setDateHeure(LocalDateTime dateHeure){
        this.dateHeure = dateHeure;
    }
    public void setMotif(String motif){
        this.motif = motif;
    }
    public void setDuree(int duree){
        this.duree = duree; 
    }
    public void setStatut(String statut){
        this.statut = statut;
    }
    public void setSalle(String salle){
        this.salle = salle;
    }

    //toString
    public String toString(){
        return 
        "Informations sur le rendez vous : " + idRendezVous +
        "----------------------------------------------------" +
        "\nPatient : " + patient.getNom() + 
        "\nMedecin : " + medecin.getNom() + 
        "\nDate et heure du rendez-vous : " + dateHeure + 
        "\nMotif : " + motif + 
        "\nDuree : " + duree + 
        "\nStatut : " + statut + 
        "\nSalle : " + salle ;
    } 

    // verifie si la date/heure est passée
    public boolean estPasse(){
        LocalDateTime aujourdhui = LocalDateTime.now();
        return dateHeure.isBefore(aujourdhui);
    }

    // change le statut
    public void annuler(){
         setStatut("Rendez vous annulé");
    }




}

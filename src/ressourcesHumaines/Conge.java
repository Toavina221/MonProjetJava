package ressourcesHumaines;

import java.time.LocalDate;

public class Conge {
    //Encapsulation
    private String idConge;
    private Employe employe;
    private String typeConge;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private int dureeJours;
    private String statut;
    private String motif;
    private LocalDate dateDemande;
    private Employe approuvePar;

    //Méthodes
    //Constructeur
    public Conge(String idConge, Employe employe, String typeConge, LocalDate dateDebut, LocalDate dateFin, int dureeJours, String statut, String motif, LocalDate dateDemande, Employe approuvePar) {
        if(idConge == null || idConge.trim().isEmpty())
             throw new IllegalArgumentException("L'id du congé ne peut pas être null");
        else this.idConge = idConge ;
        if(employe == null)
            throw new IllegalArgumentException("L'employe ne peut pas être null");
        else this.employe = employe;
        if(typeConge == null || typeConge.trim().isEmpty())
            throw new IllegalArgumentException("Le type du congé ne peut pas être vide");
        else this.typeConge = typeConge;
        if (dateDebut ==  null) 
            throw new IllegalArgumentException("La date de début du congé ne peut pas être null");
        else this.dateDebut = dateDebut;
        if(dateFin != null &&dateFin.isAfter(dateDebut)) 
            this.dateFin = dateFin;
        else throw new IllegalArgumentException("La date fin du congéne peut être ni null ni avant la date fin du congé");
        if (dureeJours >= 1)  
            this.dureeJours = dureeJours;
        else throw new IllegalArgumentException("Durée invalide");
        if(statut ==  null || statut.trim().isEmpty())
            throw new IllegalArgumentException("Le statut du congé ne peut pas êre vide");
        else this.statut = statut;
        if (motif == null || motif.trim().isEmpty())
            throw new IllegalArgumentException("Le motif du congé ne peut pas être vide");
        else this.motif = motif;
        if(dateDemande == null || dateDemande.isBefore(dateDebut))
            throw new IllegalArgumentException("La date de demande ne doit être ni null ni avant le date de début du congé");
        else this.dateDemande = dateDemande;
        if(approuvePar == null)
            throw new IllegalArgumentException("Le congé doit être approuvé par un manager ");
        else this.approuvePar = approuvePar;
    }

    //getters et setters
    public String getIdConge() {
        return idConge;
    }
    public void setIdConge(String idConge) {
        if (idConge == null || idConge.trim().isEmpty()) {
            throw new IllegalArgumentException("L'Id congé ne peut pas être vide");
        }
        this.idConge = idConge;
    }
    public Employe getEmploye() {
        return employe;
    }
    public void setEmploye(Employe employe) {
        if(employe == null){
             throw new IllegalArgumentException("L'employé ne peut pas être null");
        }
        this.employe = employe;
    }

    public String getTypeConge() {
        return typeConge;
    }
    public void setTypeConge(String typeConge) {
        if(typeConge == null || typeConge.trim().isEmpty()){
            throw new IllegalArgumentException("Le type de congé ne peut pas être vide");
        }
        this.typeConge = typeConge;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(LocalDate nouveauDateDebut) {
        if(nouveauDateDebut == null){
            throw new IllegalArgumentException("La date de début du congé ne peut pas être null");
        }
        this.dateDebut = nouveauDateDebut;
    }
    

    public LocalDate getDateFin() {
        return dateFin;
    }
    public void setDateFin(LocalDate nouveauDateFin) {
        if(nouveauDateFin == null){
            throw new IllegalArgumentException("La date de fin du congé ne peut pas être null");
        }
        this.dateFin = nouveauDateFin;
    }
 
    public int getDureeJours() {
        return dureeJours;
    }   
    public void setDureeJours(int dureeJours) {
        if(dureeJours < 1){
            throw new IllegalArgumentException("La durée d'un congé est d'un jour minimum");
        }
        this.dureeJours = dureeJours;
    }

    public String getStatut() {
        return statut;
    }
    public void setStatut(String statutActuel) {
        if (statutActuel == null || statutActuel.trim().isEmpty()) {
            throw new IllegalArgumentException("Le statut ne doit pas être vide, \nveuillez le remplir   par 'en attente', 'approuvé', 'refusé' ou 'terminé'");
        }
        this.statut = statutActuel;
    }
    public String getMotif() {
        return motif;
    }
    public void setMotif(String motif) {
        if(motif == null || motif.trim().isEmpty()){
            throw new IllegalArgumentException("La raison du congé ne doit pas être vide");
        }
        this.motif = motif;
    }
    public LocalDate getDateDemande() {
        return dateDemande;
    }
    public void setDateDemande(LocalDate dateDemande) {
        if(dateDemande == null){
            throw new IllegalArgumentException("La date de demande du congé ne peut pas être null");
        }
        this.dateDemande = dateDemande;
    }
    public Employe getApprouvePar() {
        return approuvePar;
    }
    public void setApprouvePar(Employe approuvePar) {
        if(approuvePar == null){
            throw new IllegalArgumentException("Le manager qui a appouvé le congé ne doit pas être null");
        }
        this.approuvePar = approuvePar;
    } 

    //to String
    public String toString(){
        return "Id congé : " + idConge + 
        "Matricule employe : " + employe.getMatricule() + " (" + employe.getNom() + " )" + 
        "date de début : " + dateDebut + 
        "durée : " + dureeJours + 
        "approuvé par : " + approuvePar +
        "statut : " + statut;
    }

    // VERIFIER SI LA DATE ACTUELLE EST DANS LA PERIODE 
    public boolean estEnCours(){
        LocalDate aujourdhui = LocalDate.now();
        return (!aujourdhui.isAfter(dateFin) && !aujourdhui.isBefore(dateDebut));
    }

    //calculer le jours restants
    



}
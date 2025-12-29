package hopital;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


public class Prescription {
    //Encapsulation
    private String idPrescription;
    private Patient patient;
    private Medecin medecin;
    private LocalDate datePrescription;
    private HashMap<String, String> medicaments;
    private ArrayList<String> examens;
    private boolean renouvelable;
    private LocalDate dateExpiration;

    //Constructeur 
    public Prescription( String idPrescription,  Patient patient, Medecin medecin, LocalDate datePrescription, boolean renouvelable , LocalDate dateExpiration){
        this.idPrescription = idPrescription ;
        this.patient = patient;
        this.medecin = medecin;
        this.datePrescription = datePrescription;
        this.renouvelable = renouvelable;
        this.dateExpiration= dateExpiration;
        this.medicaments = new HashMap<>();
        this.examens = new ArrayList<>();
    }

    //Getters
    public String getIdPrescription(){return idPrescription;}
    public Patient getPatient(){return patient;}
    public Medecin getMedecin(){return medecin;}
    public LocalDate getDatePrescription(){return datePrescription;}
    public HashMap<String, String> getMedicaments(){return medicaments;}
    public ArrayList<String> getExamens(){return examens;}
    public boolean isRenouvelable(){return renouvelable;}
    public LocalDate getDateExpiration(){return dateExpiration;}

    //Setters
    public void setIdPrescription(String idPrescription){
        this.idPrescription = idPrescription;
    }
    public void setPatient(Patient patient){
        this.patient = patient;
    }
    public void setMedecin(Medecin medecin){
        this.medecin = medecin;
    }
    public void setDatePrescription(LocalDate datePrescription){
        this.datePrescription = datePrescription;
    }
    public void setMedicaments(HashMap<String, String> medicaments){
        this.medicaments = medicaments;
    }
    public void setExamens(ArrayList<String> examens){
        this.examens = examens;
    }
    public void setRenouvelable(boolean renouvelable){
        this.renouvelable = renouvelable;
    }
    public void setDateExpiration(LocalDate dateExpiration){
        this.dateExpiration = dateExpiration;
    }

    //Méthodes
    public String toString(){
        return
        "Prescription :" + 
        "\n---------------" + 
        "\nIdentifiant : " + idPrescription + 
        "\nPatient : " + patient.getNom() + " " + patient.getPrenom() + 
        "\nMédecin : Dr" + medecin.getNom() + " " + medecin.getPrenom() +
        "\nDate de  préscription : "  + datePrescription + 
        "\nMédicaments : " + medicaments + 
        "\nExamens : " + examens + 
        "\nRenouvelable : "  + renouvelable + 
        "\nDate expiration :" + dateExpiration;
    }

    //ajouter un medicament 
    public void ajouterMedicament(String nom, String posologie){
        medicaments.put(nom, posologie);
        System.out.println("Médicament ajouté : " + nom);
    }

    //vérifie si non expirée
    public boolean estValide(){ 
        return dateExpiration.isAfter(LocalDate.now());
    }

    


    

}

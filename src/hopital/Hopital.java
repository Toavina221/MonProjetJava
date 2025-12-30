package hopital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hopital {
    //Encapsulation 
    private HashMap<String, Patient> patients;
    private HashMap<String, Medecin> medecins;
    private HashMap<String, RendezVous> rendezVous;
    private HashMap<String, Prescription> prescriptions;
    private String nomHopital;
    private String adresse;

    //Constructeur
    public Hopital(String nomHopital, String adresse){
        this.nomHopital = nomHopital;
        this.adresse = adresse;
        this.patients =  new HashMap<>();
        this.medecins = new HashMap<>();
        this.rendezVous = new HashMap<>();
        this.prescriptions = new HashMap<>();
    }

    //Getters
    public HashMap<String, Patient> getPatients(){return patients;}
    public HashMap<String, Medecin> getmedecins(){return medecins;}
    public HashMap<String, RendezVous> getRendezVous(){return rendezVous;}
    public HashMap<String, Prescription> getPrescription(){return prescriptions;}
    public String getNomHopital(){return nomHopital;}
    public String getAdresse(){return adresse;}

    //Setters
    public void setPatients(HashMap<String, Patient> patients){
        this.patients= patients;
    }
    public void setMedecins(HashMap<String, Medecin> medecins){
        this.medecins= medecins;
    }
    public void setRendeVous(HashMap<String, RendezVous> rendezVous){
        this.rendezVous = rendezVous;
    }
    public void setPrescription(HashMap<String, Prescription> prescriptions){
        this.prescriptions = prescriptions;
    }
    public void setNomHopital(String nomHopital){
        this.nomHopital = nomHopital;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    //Méthodes
    //Gestion Patients
    //enregistrer un patient 
    public void enregistrerPatient(Patient p){
        if(patients.containsKey(p.getIdPatient())){
            System.out.println("Ce patient est déjà enregistré ");
        }
        else{
            patients.put(p.getIdPatient(), p);
            System.out.println("Patient enregistré");
        }
    }

    //rechercher un patient 
    public Patient rechercherPatient(String id){
        if(patients.containsKey(id)){
            Patient p = patients.get(id);
            System.out.println(p.toString());
            return p;
        }
        else{
            System.err.println("Erreur , id invalide");
            return null;
        }
    } 

    //liste des patients hospitalisés
    public ArrayList<Patient> listerPatientsHospitalises(){
        ArrayList<Patient> patientsHospitalises = new ArrayList<>();
        for(Patient p : patients.values()){
            if(p.getEstHospitalise()){
                patientsHospitalises.add(p);
            }
        }
        if (patientsHospitalises.isEmpty()) {
            System.out.println("Aucune patient hospitalisé");
            return new ArrayList<>();
        }
        else{
            System.out.println("On a " + patientsHospitalises.size());
            return patientsHospitalises;
        }
    }

    //liste des patients par Genre
    public Map<Character, ArrayList<Patient>> listerPatientsParGenre(){
        ArrayList<Patient> patientsMasculins = new ArrayList<>();
        ArrayList<Patient> patientes = new ArrayList<>();
        for(Patient  p : patients.values()){
            if(p.getGenre()=='M'){
                patientsMasculins.add(p);
            }
            else {
                patientes.add(p);
            }
        }
        Map<Character,ArrayList<Patient>> resultat = new HashMap<>();
        resultat.put('M', patientsMasculins);
        resultat.put('F', patientes);

        return resultat;
    }

    //trouver l'age moyen des patients
    public double calculerMoyenneAge(){
        if(patients.isEmpty()){
            return 0.0;
        }
        else{
        double somme =0  ;
        for(Patient  p : patients.values()){
            somme += p.calculerAge(); 
        }

        return somme/patients.size();
        }
    } 

    //GESTION MEDECINS
    //ajouter un medecin


    
     





}

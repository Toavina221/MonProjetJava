package hopital;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    public void ajouterMedecin(Medecin medecin ){
        if(medecins.containsKey(medecin.getIdMedecin())){
            System.out.println("Le médecin : "  + medecin.getNom() + " est déja dans la liste ");
        }
        else{
            medecins.put(medecin.getIdMedecin(), medecin); 
        }
    }

    // rechercher des medecins par specialite
    public ArrayList<Medecin> rechercherMedecinParSpecialite(String specialite){
        ArrayList<Medecin> memeSpecialite = new ArrayList<>();
        for(Medecin medecin: medecins.values()){
            if (medecin.getSpecialite().equalsIgnoreCase(specialite)) {
                memeSpecialite.add(medecin);
            }
        }
        return memeSpecialite;
    }

    // rechercher le medecin avec la plus d'experience
    public Medecin medecinAvecPlusExperience(){
        if(medecins.isEmpty()){
            return null;
        }
        else
       return Collections.max(medecins.values(),Comparator.comparingInt(Medecin::getAnneesExperience));
    }

    //GESTION RENDEZ-VOUS
    //prendre rendez vous 
    public void prendreRendezVous(String idRendezVous, String idPatient, String idMedecin, LocalDateTime date, String motif){
        if (rendezVous.containsKey(idRendezVous)) {
            System.err.println("Ce rendez vous existe déjà");
            return;
        }
        if (date.isBefore(LocalDateTime.now())) {
            System.err.println( idRendezVous + ": Date invalide");
            return;
        }
        else{
            Patient patient = patients.get(idPatient);
            if(patient==null){
                System.err.println("Ce patient n'est pas encore enregistré!");
                return;
            }

            Medecin medecin = medecins.get(idMedecin);
            if (medecin==null) {
                System.err.println("Medecin introuvable");
                return;
            }
            RendezVous rendezvous = new RendezVous(idRendezVous, patient, medecin, date, motif, 15, null,  null);
            rendezVous.put(idRendezVous, rendezvous);
        }
    }

    //annuler un rendez vous 
    public void annulerRendezVous(String idRendezVous){
        if(idRendezVous == null || idRendezVous.isEmpty()){
            System.err.println("Identifiant invalide");
        }
        else{
            if (rendezVous.containsKey(idRendezVous)) {
                rendezVous.remove(idRendezVous);
                System.out.println("Rendez vous " + idRendezVous + " annulé ");
            }
            else{
            System.err.println("identifiant introuvable");
            }
        }
    }

    //afficher les Rendez-vous à un jour donné 
    public ArrayList<RendezVous> afficherRendezVousJour(LocalDate date){
        if(date==null){
            System.err.println("date invalide");
            return new ArrayList<>();
        }
        ArrayList<RendezVous> rdvMemeJour = new ArrayList<>();
        for(RendezVous rdv : rendezVous.values()){
            if(rdv.getDateHeure().toLocalDate().equals(date)){
                rdvMemeJour.add(rdv);
            }
        }
        if (rdvMemeJour.isEmpty()) {
            System.out.println("Il n'y a aucun rendez vous pris à cette date");
        }
        else{
            System.out.println("Les rendez-vous à la date de  : " + date);
            for(RendezVous rdv : rdvMemeJour){
                System.out.println("Id du rendez-vous " + rdv.getIdRendezVous());
            }
        }
        return rdvMemeJour;
    }

    //afficher les rendez vous par medecin 
    public ArrayList<RendezVous> afficherRendezVousMedecin(String idMedecin, LocalDate date){
        if(idMedecin == null|| idMedecin.isEmpty() || date == null){
            System.err.println("Paramètres invalides");
            return new ArrayList<>();
        }
            ArrayList<RendezVous> rdvMedecin = new ArrayList<>();
            for(RendezVous rdv : rendezVous.values()){
                Medecin medecin =  rdv.getMedecin();
                if(medecin.getIdMedecin().equals(idMedecin) && rdv.getDateHeure().toLocalDate().equals(date)){
                    rdvMedecin.add(rdv);
                }
            }
            if(rdvMedecin.isEmpty()){
                System.out.println("Ce medecin est libre à ce jour à toute heure");
            }
            else{
                System.out.println("Liste des rendez-vous avec dr " + idMedecin);
            for(RendezVous rdv : rdvMedecin){
                Patient patient = rdv.getPatient();
                System.out.println("Patient : " + patient.getIdPatient() + " le  " + rdv.getDateHeure());
            }
            }
            return rdvMedecin;
    }

    //Verifier si le medecin est disponible à une date donnée
    public  boolean verifierDisponibiliteMedecin(String idMedecin,  LocalDateTime date){
        if(idMedecin == null || idMedecin.isEmpty() || date == null){
            System.err.println("Erreur : paramètres invalides");
            return false;
        }
         for(RendezVous rdv : rendezVous.values()){
            Medecin medecin = rdv.getMedecin();
            if(medecin != null && medecin.getIdMedecin().equals(idMedecin) && rdv.getDateHeure().equals(date)){
                System.out.println("Medecin indisponible "); 
                return false;
            }
        }
        return true;
    }
    
    //GESTION PRESCRIPTIONS
     //Creer une prescription 
    public Prescription creerPrescription(String idPatient, String idMedecin){
        if(idPatient == null || idPatient.isEmpty() || idMedecin == null || idMedecin.isEmpty()){
            System.err.println("Erreur : paramètres invalides");
            return null;
        }
        Patient patient = patients.get(idPatient);
        Medecin medecin = medecins.get(idMedecin);
        String idPrescription = "PRESC_" + System.currentTimeMillis();
        if(patient != null && medecin !=null ) {
            Prescription prescription = new Prescription(idPrescription, patient, medecin , LocalDate.now() , false , null,new  HashMap<>(), new ArrayList<>());
            prescriptions.put(idPrescription, prescription);
            System.out.println(idPrescription + " Prescription créer");
            return prescription;
        }
        else{
            System.err.println("Erreur : Patient ou medecin introuvable"); 
            return null; 
        }
    }

    //Afficher la prescription d'un patient 
    public Map<String,Prescription> afficherPrescriptionsPatient(String idPatient){
        if(idPatient == null || idPatient.isEmpty()){
            System.err.println("Erreur : id invalide !");
            return new HashMap<>();
        }
        Map<String,Prescription> prescriptionsPatient = new HashMap<>();
        for(Prescription prescription : prescriptions.values()){
            Patient patient = prescription.getPatient();
            if( patient != null && patient.getIdPatient().equals(idPatient)){
                prescriptionsPatient.put(prescription.getIdPrescription(), prescription);
            }
        }
        if (prescriptionsPatient.isEmpty()) {
            System.out.println("Aucune prescription enregistrée pour ce patient");
        }
        else{
            for(Prescription prescription : prescriptionsPatient.values()){
                System.out.println("Id de la prescription " + prescription.getIdPrescription());
            }
            System.out.println(prescriptionsPatient.size() + " prescriptions trouvées");
        }
        return prescriptionsPatient;
    }

    //trouver le prescriptions expirées
    public Map<String, Prescription> prescriptionsExpirees(){
        Map<String, Prescription> expirees  = new HashMap<>();
        for(Prescription prescription : prescriptions.values()){
            if(prescription.getDateExpiration().isBefore(LocalDate.now())){
                expirees.put(prescription.getIdPrescription(), prescription);
            }
        }
        if(expirees.isEmpty()){
            System.err.println("Aucune prescription n'est expirée");
            return new HashMap<>();
        }
        for(Prescription prescription : expirees.values()){
            System.out.println("Id de la prescription : " + prescription.getIdPrescription() + " Date expiration : " + prescription.getDateExpiration());
        }
        return expirees;
    }

    //STATISTIQUES
    //Calculer le nombre total des patients
    public int nombreTotalPatients(){
        if(patients.isEmpty()){
            System.out.println("0 patient");
            return 0;
        }
        System.out.println(patients.size() + " patients ");
        return patients.size();
    }

    // calculer le nombre des medecins par specialite 
    public Map<String, Integer> nombreMedecinParSpecialite(){
        Map<String, Integer> liste = new HashMap<>(); 
        for(Medecin medecin : medecins.values()){
            if(liste.containsKey(medecin.getSpecialite())){
                int valeurActuel = liste.get(medecin.getSpecialite());
                liste.put(medecin.getSpecialite(), valeurActuel + 1);
            }
            else{
                 liste.put(medecin.getSpecialite(), 1);
            }
        }
        for(String specialite : liste.keySet()){
            System.out.println(
                "Specialité : " + specialite +
                " Effectif : " + liste.get(specialite)
            );
        }
        return liste;
    }

    // Trouver la spécialité la plus demandée 
    public  String specialiteLaPlusDemandee(){
        if(rendezVous.isEmpty()){
            System.out.println("aucune rendez-vous enregistré");
            return null;
        }
        Map<String, Integer> liste = new HashMap<>();

        for(RendezVous rdv :  rendezVous.values()){
            String specialite = rdv.getMedecin().getSpecialite();
            if(liste.containsKey(specialite)){
                int valeurActuel = liste.get(specialite);
                liste.put(specialite, valeurActuel + 1);
            }
            else{
            liste.put(specialite, 1);
            }
        }
        Map.Entry<String, Integer> laPlusDemandee = Collections.max(liste.entrySet(),Map.Entry.comparingByValue());
        return laPlusDemandee.getKey();
    }
    
}
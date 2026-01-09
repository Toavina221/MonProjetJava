  package hopital;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainHopital {
    public static void main(String[] args) {
        // Création de l'hôpital
        Hopital hopital = new Hopital("Hôpital Central", "123 Rue de la Santé, 75000 Paris");
        
        // ========== GESTION PATIENTS ==========
        System.out.println("=== CRÉATION DES PATIENTS ===");
        
        Patient patient001 = new Patient("PAT001", "Dupont", "Jean",LocalDate.parse("1985-05-15"), 'M', "A+", "1 85 05 15 123 456 78",true);
        Patient patient002 = new Patient("PAT002", "Martin", "Marie",     LocalDate.parse("1992-08-22"), 'F', "O-", "1 92 08 22 234 567 89",true);
        Patient patient003 = new Patient("PAT003", "Bernard", "Pierre",     LocalDate.parse("1978-11-30"), 'M', "B+", "1 78 11 30 345 678 90",false);
        Patient patient004 = new Patient("PAT004", "Petit", "Sophie",     LocalDate.parse("1988-03-10"), 'F', "AB+", "1 88 03 10 456 789 01",true);
        Patient patient005 = new Patient("PAT005", "Durand", "Luc",     LocalDate.parse("1995-07-18"), 'M', "A-", "1 95 07 18 567 890 12",false);
        Patient patient006 = new Patient("PAT006", "Leroy", "Julie",     LocalDate.parse("2000-12-05"), 'F', "O+", "2 00 12 05 678 901 23",false);
        Patient patient007 = new Patient("PAT007", "Moreau", "Thomas",     LocalDate.parse("1982-09-25"), 'M', "B-", "1 82 09 25 789 012 34",false);
        Patient patient008 = new Patient("PAT008", "Simon", "Claire",     LocalDate.parse("1990-04-14"), 'F', "A+", "1 90 04 14 890 123 45",false);
        Patient patient009 = new Patient("PAT009", "Laurent", "Paul",     LocalDate.parse("1975-02-28"), 'M', "O+", "1 75 02 28 901 234 56",true);
        Patient patient010 = new Patient("PAT010", "Michel", "Anne",     LocalDate.parse("1998-06-20"), 'F', "B+", "1 98 06 20 012 345 67",false);
        
        // Patients enfants  
        Patient patient011 = new Patient("PAT011", "Garcia", "Léo",     LocalDate.parse("2015-03-12"), 'M', "A+", "2 15 03 12 123 456 79",true);
        Patient patient012 = new Patient("PAT012", "Rodriguez", "Emma",     LocalDate.parse("2018-09-08"), 'F', "O+", "2 18 09 08 234 567 80",true);
        Patient patient013 = new Patient("PAT013", "Martinez", "Lucas",     LocalDate.parse("2020-01-15"), 'M', "B-", "2 20 01 15 345 678 91",false);
        Patient patient014 = new Patient("PAT014", "Hernandez", "Chloé",     LocalDate.parse("2016-07-30"), 'F', "AB-", "2 16 07 30 456 789 02",true);
        Patient patient015 = new Patient("PAT015", "Lopez", "Hugo",     LocalDate.parse("2019-11-22"), 'M', "O-", "2 19 11 22 567 890 13",true);
        
        // Patients âgés  
        Patient patient016 = new Patient("PAT016", "Roux", "Henri",     LocalDate.parse("1950-12-03"), 'M', "A+", "1 50 12 03 678 901 24",false);
        Patient patient017 = new Patient("PAT017", "Fournier", "Jeanne",     LocalDate.parse("1948-04-17"), 'F', "O+", "1 48 04 17 789 012 35",false);
        Patient patient018 = new Patient("PAT018", "Mercier", "Robert",     LocalDate.parse("1960-08-09"), 'M', "B+", "1 60 08 09 890 123 46",false);
        Patient patient019 = new Patient("PAT019", "Lefebvre", "Suzanne",     LocalDate.parse("1955-10-31"), 'F', "A-", "1 55 10 31 901 234 57",false);
        Patient patient020 = new Patient("PAT020", "Girard", "Marcel",     LocalDate.parse("1945-06-25"), 'M', "AB+", "1 45 06 25 012 345 68",true);
        
        // Ajouter les antécédents médicaux
        patient001.ajouterAntecedent("Hypertension");
        patient001.ajouterAntecedent("Allergie pénicilline");
        patient002.ajouterAntecedent("Asthme");
        patient002.ajouterAntecedent("Diabète type 2");
        patient011.ajouterAntecedent("Allergie aux œufs");
        patient011.ajouterAntecedent("Asthme infantile");
        patient016.ajouterAntecedent("Insuffisance cardiaque");
        patient020.ajouterAntecedent("Arthrose sévère");
        patient020.ajouterAntecedent("Opération hanche récente");
        
        
        // Ajouter les patients à l'hôpital
        hopital.enregistrerPatient(patient001);
        hopital.enregistrerPatient(patient002);
        hopital.enregistrerPatient(patient003);
        hopital.enregistrerPatient(patient004);
        hopital.enregistrerPatient(patient005);
        hopital.enregistrerPatient(patient006);
        hopital.enregistrerPatient(patient007);
        hopital.enregistrerPatient(patient008);
        hopital.enregistrerPatient(patient009);
        hopital.enregistrerPatient(patient010);
        hopital.enregistrerPatient(patient011);
        hopital.enregistrerPatient(patient012);
        hopital.enregistrerPatient(patient013);
        hopital.enregistrerPatient(patient014);
        hopital.enregistrerPatient(patient015);
        hopital.enregistrerPatient(patient016);
        hopital.enregistrerPatient(patient017);
        hopital.enregistrerPatient(patient018);
        hopital.enregistrerPatient(patient019);
        hopital.enregistrerPatient(patient020);
        
        System.out.println(hopital.nombreTotalPatients() + " patients enregistrés.\n");
        
        // ========== GESTION MÉDECINS ==========
        System.out.println("=== CRÉATION DES MÉDECINS ===");
        
        // Médecins généralistes
        Medecin medecin001 = new Medecin("MED001", "Bernard", "Pierre", "Généraliste", "RPPS123456789", 12, true, 100);
        Medecin medecin002 = new Medecin("MED002", "Petit", "Sophie", "Généraliste", "RPPS987654321", 8, true, 80);
        Medecin medecin003 = new Medecin("MED003", "Durand", "Luc", "Généraliste", "RPPS456789123", 15, false, 120);
        
        // Spécialistes
        Medecin medecin004 = new Medecin("MED004", "Martin", "Julie", "Cardiologie", "RPPS111222333", 20, true, 50);
        Medecin medecin005 = new Medecin("MED005", "Leroy", "Thomas", "Cardiologie", "RPPS444555666", 10, true, 40);
        Medecin medecin006 = new Medecin("MED006", "Moreau", "Claire", "Pédiatrie", "RPPS777888999", 18, true, 60);
        Medecin medecin007 = new Medecin("MED007", "Simon", "Paul", "Pédiatrie", "RPPS000111222", 7, true, 50);
        Medecin medecin008 = new Medecin("MED008", "Laurent", "Anne", "Gynécologie", "RPPS333444555", 25, true, 40);
        Medecin medecin009 = new Medecin("MED009", "Michel", "Robert", "Orthopédie", "RPPS666777888", 22, true, 30);
        Medecin medecin010 = new Medecin("MED010", "Roux", "Isabelle", "Dermatologie", "RPPS999000111", 14, true, 35);
        Medecin medecin011 = new Medecin("MED011", "Fournier", "Jacques", "Ophtalmologie", "RPPS222333444", 30, true, 45);
        Medecin medecin012 = new Medecin("MED012", "Mercier", "Catherine", "Psychiatrie", "RPPS555666777", 16, true, 25);
        Medecin medecin013 = new Medecin("MED013", "Lefebvre", "Philippe", "Radiologie", "RPPS888999000", 12, true, 40);
        Medecin medecin014 = new Medecin("MED014", "Girard", "Émilie", "Chirurgie", "RPPS111222333", 28, false, 20);
        Medecin medecin015 = new Medecin("MED015", "Bonnet", "Antoine", "Urgences", "RPPS444555666", 5, true, 200);
        
        // Ajouter les médecins à l'hôpital
        hopital.ajouterMedecin(medecin001);
        hopital.ajouterMedecin(medecin002);
        hopital.ajouterMedecin(medecin003);
        hopital.ajouterMedecin(medecin004);
        hopital.ajouterMedecin(medecin005);
        hopital.ajouterMedecin(medecin006);
        hopital.ajouterMedecin(medecin007);
        hopital.ajouterMedecin(medecin008);
        hopital.ajouterMedecin(medecin009);
        hopital.ajouterMedecin(medecin010);
        hopital.ajouterMedecin(medecin011);
        hopital.ajouterMedecin(medecin012);
        hopital.ajouterMedecin(medecin013);
        hopital.ajouterMedecin(medecin014);
        hopital.ajouterMedecin(medecin015);
        
        System.out.println(hopital.getmedecins().size() + " médecins enregistrés.\n");
        
        // ========== GESTION RENDEZ-VOUS ==========
        System.out.println("=== PRISE DE RENDEZ-VOUS ===");
        
        // RDV planifiés pour aujourd'hui
        hopital.prendreRendezVous("RDV001","PAT001", "MED001", 
                                 LocalDateTime.of(2026, 12, 15, 9, 0), 
                                 "Consultation routine");
        
        hopital.prendreRendezVous("RDV002","PAT002", "MED004", 
                                 LocalDateTime.of(2026, 12, 15, 10, 30), 
                                 "Problème cardiaque");
        
        hopital.prendreRendezVous("RDV003","PAT011", "MED006", 
                                 LocalDateTime.of(2026, 12, 15, 14, 0), 
                                 "Vaccination");
        
        // RDV passés
        hopital.prendreRendezVous("RDV004","PAT003", "MED002", 
                                 LocalDateTime.of(2026, 12, 10, 11, 0), 
                                 "Grippe");
        
        hopital.prendreRendezVous("RDV005","PAT016", "MED009", 
                                 LocalDateTime.of(2026, 12, 12, 15, 30), 
                                 "Arthrose genou");
        
 
        // RDV de la semaine
        hopital.prendreRendezVous("RDV006","PAT001", "MED001", 
                                 LocalDateTime.of(2026, 12, 16, 9, 0), 
                                 "Contrôle");
        
        hopital.prendreRendezVous("RDV006","PAT002", "MED004", 
                                 LocalDateTime.of(2026, 12, 16, 10, 0), 
                                 "Cardio");
        
        hopital.prendreRendezVous("RDV007","PAT003", "MED002", 
                                 LocalDateTime.of(2026, 12, 17, 14, 0), 
                                 "Consultation");
        
        hopital.prendreRendezVous("RDV008","PAT011", "MED006", 
                                 LocalDateTime.of(2026, 12, 17, 15, 30), 
                                 "Pédiatrie");
        
        hopital.prendreRendezVous("RDV009","PAT016", "MED009", 
                                 LocalDateTime.of(2026, 12, 18, 11, 0), 
                                 "Orthopédie");
        
        hopital.prendreRendezVous("RDV010","PAT008", "MED008", 
                                 LocalDateTime.of(2026, 12, 19, 9, 30), 
                                 "Gynécologie");
        
        hopital.prendreRendezVous("RDV011","PAT020", "MED014", 
                                 LocalDateTime.of(2026, 12, 20, 13, 0), 
                                 "Suivi chirurgical");
        
        System.out.println(hopital.getRendezVous().size() + " rendez-vous pris.\n");
        
        // ========== GESTION PRESCRIPTIONS ==========
        System.out.println("=== CRÉATION DES PRESCRIPTIONS ===");
      
        // Prescription pour hypertension
        Prescription presc1 = hopital.creerPrescription("PAT001", "MED001");
        if (presc1 != null) {
        presc1.ajouterMedicament("Amlodipine", "1 comprimé par jour");
        presc1.ajouterMedicament("Lisinopril", "1 comprimé matin et soir");
        presc1.ajouterExamen("Prise de tension hebdomadaire");
        presc1.ajouterExamen("Bilan sanguin trimestriel");
        presc1.setRenouvelable(true);
        presc1.setDateExpiration(LocalDate.of(2025, 3, 10));
        }
        
        // Prescription pour enfant asthmatique
        Prescription presc2 = hopital.creerPrescription("PAT011", "MED006");
        if (presc2 != null) {
        presc2.setDatePrescription(LocalDate.of(2024, 12, 5));
        presc2.ajouterMedicament("Ventoline", "2 bouffées si besoin");
        presc2.ajouterMedicament("Flixotide", "1 bouffée matin et soir");
        presc2.ajouterExamen("Test respiratoire mensuel");
        }
        
        // Prescription post-opératoire
        Prescription presc3 = hopital.creerPrescription("PAT020", "MED014");
        if (presc3 != null) {
        presc3.setDatePrescription(LocalDate.of(2024, 12, 3));
        presc3.ajouterMedicament("Paracétamol", "1g toutes les 6h si douleur");
        presc3.ajouterMedicament("Ibuprofène", "400mg 3x/jour");
        presc3.ajouterMedicament("Anticoagulant", "1 injection par jour");
        presc3.ajouterExamen("Radiographie contrôle dans 1 mois");
        presc3.setRenouvelable(false);
        presc3.setDateExpiration(LocalDate.of(2024, 12, 17));
        }
        
        System.out.println(hopital.getPrescription().size() + " prescriptions créées.\n");
        
        // ========== AFFICHAGE DES STATISTIQUES ==========
        System.out.println("=== STATISTIQUES DE L'HÔPITAL ===");
        
        // Patients hospitalisés
        System.out.println("\n1. PATIENTS HOSPITALISÉS :");
        hopital.listerPatientsHospitalises();
        
        // RDV du jour
        System.out.println("\n2. RENDEZ-VOUS DU JOUR (" + LocalDate.now() + ") :");
        hopital.afficherRendezVousJour(LocalDate.now());
        
        // Médecins par spécialité
        System.out.println("\n3. MÉDECINS PAR SPÉCIALITÉ :");
        System.out.println("- Cardiologie : " + hopital.rechercherMedecinParSpecialite("Cardiologie").size());
        System.out.println("- Pédiatrie : " + hopital.rechercherMedecinParSpecialite("Pédiatrie").size());
        System.out.println("- Généraliste : " + hopital.rechercherMedecinParSpecialite("Généraliste").size());
        
        // Âge moyen
        System.out.println("\n4. ÂGE MOYEN DES PATIENTS : " + hopital.calculerMoyenneAge() + " ans");
        
        // Prescriptions
        System.out.println("\n5. PRESCRIPTIONS ACTIVES : " + hopital.getPrescription().size());
        
        // Tests de recherche
        System.out.println("\n=== TESTS DE RECHERCHE ===");
        System.out.println("\nRecherche patient PAT001 :");
        hopital.rechercherPatient("PAT001");
        
        System.out.println("\nPrescriptions du patient PAT001 :");
        hopital.afficherPrescriptionsPatient("PAT001");
        
        System.out.println("\nRendez-vous du médecin MED001 :");
        hopital.afficherRendezVousMedecin("MED001", LocalDate.of(2026, 12, 15));
        System.out.println("\nRendez-vous du médecin MED002 :");
        hopital.afficherRendezVousMedecin("MED0020", LocalDate.of(2026, 12, 15));
        
        System.out.println("\n=== INITIALISATION TERMINÉE ===");
        System.out.println("L'hôpital est prêt avec :");
        System.out.println("- " + hopital.nombreTotalPatients() + " patients");
        System.out.println("- " + hopital.getmedecins().size() + " médecins");
        System.out.println("- " + hopital.getRendezVous().size() + " rendez-vous");
        System.out.println("- " + hopital.getPrescription().size() + " prescriptions");

    // Trouver la spécialité la plus demandée 
        System.out.println(" la spécialité la plus demandée : " + hopital.specialiteLaPlusDemandee());
    }
}
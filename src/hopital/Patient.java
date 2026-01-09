package hopital;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Patient {
    //Encapsulation 
    private String idPatient ;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private char genre ;
    private String groupeSanguin ;
    private ArrayList<String> antecedents;
    private String assuranceMedicale;
    private boolean estHospitalise;
    
    //Constructeur 
    public Patient(String idPatient , String nom , String prenom , 
        LocalDate dateNaissance , char genre , String groupeSanguin  
         ,String assuranceMedicale , boolean estHospitalise){
        this.idPatient = idPatient;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.genre = genre;
        this.groupeSanguin = groupeSanguin;
        this.antecedents= new ArrayList<>();
        this.assuranceMedicale = assuranceMedicale;
        this.estHospitalise = estHospitalise;
    }

    //Getters
    public String getIdPatient(){return idPatient;}
    public String getNom(){return nom;}
    public String getPrenom(){return prenom;}
    public LocalDate getDateNaissance(){return dateNaissance;}
    public char getGenre(){return genre;}
    public String getGroupeSanguin (){return groupeSanguin;}
    public ArrayList<String> getAntecedents(){return antecedents;}
    public String getAssuranceMedicale(){return assuranceMedicale;}
    public boolean getEstHospitalise(){return estHospitalise;}

    //Setters
    public void setIdPatient(String nouveauIdPatient){
        this.idPatient = nouveauIdPatient;
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
    public void  setGenre(char genre){
        this.genre= genre;
    }
    public void setGroupeSanguin(String groupeSanguin){
        this.groupeSanguin= groupeSanguin;
    }
    public void setAntecedents(ArrayList<String> antecedents){
        this.antecedents= antecedents;
    }
    public void setAssuranceMedicale (String assuranceMedicale){
        this.assuranceMedicale= assuranceMedicale;
    }
    public void setEstHospitalise(boolean estHospitalise){
        this.estHospitalise= estHospitalise;
    }

    //Méthodes
    public String toString(){
        return
            "Patient : " + idPatient +
            "\n -----------------------" +
            "\n Nom : "+ nom +
            "\n Prenom : " + prenom +
            "\n Date de Naissance : " + dateNaissance +
            "\n Genre : " + genre + 
            "\n Groupe sanguin : " + groupeSanguin +
            "\n Antecedents : " + antecedents +
            "\n Assurance médicale : " + assuranceMedicale +
            "\n estHospitalise : " + estHospitalise
        ;
    }

    //ajouter antecedent
    public void ajouterAntecedent(String antecedent){
        if(antecedent != null && antecedent.trim().isEmpty()){
        antecedents.add(antecedent);
        System.out.println("Antécédent ajouté au patient " + idPatient);
        }
        else{
            System.out.println("Erreur : antécédent vide ");
        }
    }

    //calculer age 
    public int calculerAge(){
        LocalDate aujourdhui = LocalDate.now();
        if(getDateNaissance() != null){
        return Period.between(getDateNaissance(), aujourdhui).getYears();
        }
        return 0;
    }
    
    //verifie si le patient est adulte ou non 
    public boolean estAdulte(){
        return calculerAge() >= 18;
    }
}
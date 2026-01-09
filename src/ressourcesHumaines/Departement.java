package ressourcesHumaines;
import java.time.LocalDate;
import java.util.ArrayList;

public class Departement {
    //Encapsulation
    private String codeDepartement;
    private String nomDepartement;
    private Employe manager;
    private double budgetAnnuel;
    private int nombrePostesAutorises;
    private LocalDate dateCreation;
    private ArrayList<String> objectifs;
    //Méthodes
    //Constructeur 
    public Departement(String codeDepartement, String nomDepartement, Employe manager, double budgetAnnuel, int nombrePostesAutorises, LocalDate dateCreation, ArrayList<String> objectifs){
        this.codeDepartement = codeDepartement;
        this.nomDepartement = nomDepartement;
        this.manager = manager;
        this.budgetAnnuel = budgetAnnuel;
        this.nombrePostesAutorises = nombrePostesAutorises;
        this.dateCreation = dateCreation;
        this.objectifs = objectifs != null ? objectifs : new ArrayList<>();
    }

    //Getters
    public String getCodeDepartement(){return codeDepartement;}
    public String getNomDepartement(){return nomDepartement;}
    public Employe getManager(){return manager;}
    public double getBudgetAnnuel(){return budgetAnnuel;}
    public int getNombrePostesAutorises(){return nombrePostesAutorises;}
    public LocalDate getDateCreation(){return dateCreation;}
    public ArrayList<String> getObjectifs(){return objectifs;}

    //Setters
    public void setCodeDepartement(String nouveauCodeDepartement){
        if(nouveauCodeDepartement == null || nouveauCodeDepartement.trim().isEmpty()){
            throw new IllegalArgumentException("Le code département ne peut pas être vide");
        }
        this.codeDepartement = nouveauCodeDepartement.trim();
    }
    public void setNomDepartement(String nouveauNomDepartement){
        if(nouveauNomDepartement == null || nouveauNomDepartement.trim().isEmpty()){
            throw new IllegalArgumentException("Le nom du département ne doit pas être vide");
        }
        this.nomDepartement = nouveauNomDepartement;
    }
    public void setManager(Employe nouveauManager){
        if(nouveauManager == null){
            throw new IllegalArgumentException("Le manager ne peut pas être null");
        }
        this.manager = nouveauManager;
    }
    public void setBudgetAnnuel(double budgetAnnuel){
        if(budgetAnnuel < 0){
            throw new IllegalArgumentException("Le budget annuel ne peut pas être négatif");
        }
        this.budgetAnnuel = budgetAnnuel;
    }
    public void setNombrePostesAutorises(int nombrePostesAutorisesActuel){
        if(nombrePostesAutorisesActuel < 0 ){
            throw new IllegalArgumentException("le nombre de postes autorisés ne peut pas être négatif");
        }
        this.nombrePostesAutorises = nombrePostesAutorisesActuel; 
    }
    public void setObjectifs(ArrayList<String> nouveauxObjectifs){
        this.objectifs = nouveauxObjectifs != null ? nouveauxObjectifs : new ArrayList<>();
    }

    //toString()
    public String toString(){
        return "Nom du département : " + nomDepartement +
        "\nCode département " + codeDepartement + 
        "\nManager : " + (manager != null? manager.getMatricule() : " Aucun");
    }

    // public int calculerEffectif(){

    // }

}

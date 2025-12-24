package etudiants;
public class Etudiant {
    //Encapsulation
    private String matricule ;
    private String nom ;
    private String prenom;
    private  int age ; 
    private String filiere ;
    private double moyenne ;

    //Constructeur 
    public Etudiant(String matricule , String nom , String prenom , int age , String filiere , double moyenne){
        this.matricule = matricule;
        this.nom = nom;
        this.prenom= prenom;
        this.age = age;
        this.filiere= filiere;
        this.moyenne = moyenne ;
    }

    //getters
    public String getMatricule(){return matricule;}
    public String getNom(){return nom;}
    public String getPrenom(){return prenom;}
    public int getAge(){return age;}
    public String getFiliere(){return filiere;}
    public double getMoyenne(){return moyenne;}

    //setters
    public void setNom(String nom){this.nom = nom ;}
    public void setPrenom(String prenom){this.prenom= prenom;}
    public void setAge(int age){this.age= age;}
    public void setfiliere(String filiere ){this.filiere = filiere;}
    public void setMoyenne(double moyenne){this.moyenne = moyenne;}

    //Methodes toString
    public String toString(){
        return "Information sur l'élève matriculé :" + matricule +
        "\n----------------------------------------\n\t Nom :" + nom +
         "\t Prenom :" + prenom +
         "\t Age :" + age +
         "\t Filière :" + filiere +
         "\t Moyenne :" + moyenne;
    }

    //Methode estAdmis
    public boolean estAdmis(){
        if(moyenne>=10 && moyenne<=20 ){
           // System.out.println("L'etudiant " + nom + " est admis ");
            return true;
        }
        else{
            //System.out.println("L'etudiant " + nom  + " n'est pas admis ");
            return false;
        }
    }
}

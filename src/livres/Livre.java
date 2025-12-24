package livres;
public class Livre{
    //Encapsulation
    private String titre ;
    private String auteur ;
    private int anneePublication ;
    private String isbn ;

    //Constructeur 
    public Livre(String titre ,String auteur , int anneePublication , String isbn){
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.isbn =  isbn;
    }

    //Getters
    public String getTitre(){return titre;}
    public String getAuteur(){return auteur;}
    public int getAnneePublication(){return anneePublication;}
    public String getIsbn(){return isbn;}


    //Méthodes
    public void toStringLivre(){
        System.out.println("Information sur le livre :");
        System.out.println("------------------------");
        System.out.println("\n\t Livre : " + titre);
        System.out.println("\n\t Auteur : " + auteur);
        System.out.println("\n\t Annee de publication : " + anneePublication);
        System.out.println("\n\t isbn :" +  isbn);
    }


}
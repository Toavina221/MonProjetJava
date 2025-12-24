import java.util.ArrayList;

public class Film {
    //Encapsulation 
    private String titre ;
    private String realisateur ;
    private ArrayList<Double> notes ; 
    
    //constructeur 
    public Film(String titre , String realisateur ){
        this.titre = titre ;
        this.realisateur = realisateur ;
        this.notes = new ArrayList<>();
    }
    

}
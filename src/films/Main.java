package films;

public class Main {
    public static void main(String[] args) {
        Film film1 = new Film("Inception", "Christopher Nolan");
        Film film2 = new Film("Avatar", "James Cameron");

        film1.ajouterNote(2.5);
        film1.ajouterNote(3.5);
        film1.ajouterNote(4.5);
        film1.ajouterNote(5.5);
        film1.moyenne();
        
    }
}

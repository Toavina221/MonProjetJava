package films;

public class Main {
    public static void main(String[] args) {

        GestionFilms films = new GestionFilms();
        Film film1 = new Film("Inception", "Christopher Nolan");
        Film film2 = new Film("Avatar", "James Cameron");
        Film film3 = new Film("Oppenheimer", "Christopher Nolan");

        films.ajouterFilm("Inception", "Christopher Nolan");
        films.ajouterFilm("Avatar", "James Cameron");
        films.ajouterFilm("Oppenheimer", "Christopher Nolan");

        films.noterFilm("Inception", 0);;
        films.noterFilm("Inception" ,6);
        films.noterFilm("Inception",7);
        films.noterFilm("Inception",5);

        films.noterFilm("Avatar",8);
        films.noterFilm("Avatar",8);
        films.noterFilm("Avatar",4);

        films.noterFilm("Oppenheimer",4);
        films.noterFilm("Oppenheimer",7);
        films.noterFilm("Oppenheimer",9);

        films.afficherFilms();
        films.afficherStats("Inception");
        films.afficherStats("Avatar");
        films.afficherStats("Oppenheimer");

        film2.ajouterNote(4);
        film2.ajouterNote(5.5);
        film2.ajouterNote(6);

        System.out.println(" meilleur note du film Avatar :" + film2.meilleureNote()); 


 
        
    }
}

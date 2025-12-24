package etudiants;
public class Main {
    public static  void main(String[] args) {

        Etudiant etu1 = new Etudiant("ETU2024001", "Dupont", "Jean", 20, "Informatique", 14.5);
        Etudiant etu2 = new Etudiant("ETU2024002", "Martin", "Marie", 21, "Mathématiques", 16.2);
        Etudiant etu3 = new Etudiant("ETU2024003", "Bernard", "Pierre", 22, "Physique", 8.7);
        Etudiant etu4 = new Etudiant("ETU2024004", "Petit", "Sophie", 19, "Informatique", 12.8);
        Etudiant etu5 = new Etudiant("ETU2024005", "Durand", "Luc", 20, "Chimie", 15.0);
        Etudiant etu6 = new Etudiant("ETU2024006", "Leroy", "Julie", 21, "Biologie", 9.5);
        Etudiant etu7 = new Etudiant("ETU2024007", "Moreau", "Thomas", 23, "Informatique", 18.3);
        Etudiant etu8 = new Etudiant("ETU2024008", "Simon", "Claire", 20, "Mathématiques", 11.2);
        Etudiant etu9 = new Etudiant("ETU2024009", "Laurent", "Paul", 22, "Physique", 13.7);
        Etudiant etu10 = new Etudiant("ETU2024010", "Michel", "Anne", 21, "Informatique", 7.9);

        Etudiant etu11 = new Etudiant("ETU2024011", "Garcia", "Luis", 20, "Économie", 14.1);
        Etudiant etu12 = new Etudiant("ETU2024012", "Rodriguez", "Maria", 22, "Droit", 16.8);
        Etudiant etu13 = new Etudiant("ETU2024013", "Martinez", "Carlos", 21, "Informatique", 10.0);
        Etudiant etu14 = new Etudiant("ETU2024014", "Hernandez", "Isabel", 19, "Langues", 12.3);
        Etudiant etu15 = new Etudiant("ETU2024015", "Lopez", "Miguel", 23, "Histoire", 17.5);

        Etudiant etu16 = new Etudiant("ETU2024016", "Gonzalez", "Elena", 20, "Informatique", 19.2);
        Etudiant etu17 = new Etudiant("ETU2024017", "Perez", "David", 21, "Génie Civil", 6.8);
        Etudiant etu18 = new Etudiant("ETU2024018", "Sanchez", "Laura", 22, "Architecture", 13.4);
        Etudiant etu19 = new Etudiant("ETU2024019", "Ramirez", "Javier", 20, "Informatique", 15.7);
        Etudiant etu20 = new Etudiant("ETU2024020", "Torres", "Carmen", 21, "Médecine", 11.9);

        // Étudiants avec le même nom pour tester la recherche
        Etudiant etu21 = new Etudiant("ETU2024021", "Dupont", "Paul", 20, "Informatique", 14.0);
        Etudiant etu22 = new Etudiant("ETU2024022", "Martin", "Luc", 22, "Électronique", 9.8);
        Etudiant etu23 = new Etudiant("ETU2024023", "Bernard", "Anne", 21, "Psychologie", 12.5);
        Etudiant etu24 = new Etudiant("ETU2024024", "Petit", "Marc", 23, "Sociologie", 16.1);
        Etudiant etu25 = new Etudiant("ETU2024025", "Durand", "Catherine", 20, "Philosophie", 8.3);

        GestionEtudiants gestion =  new GestionEtudiants();
        gestion.ajouterEtudiant(etu1);
        gestion.ajouterEtudiant(etu2);
        gestion.ajouterEtudiant(etu3);
        gestion.ajouterEtudiant(etu4);
        gestion.ajouterEtudiant(etu5);
        gestion.ajouterEtudiant(etu6);
        gestion.ajouterEtudiant(etu7);
        gestion.ajouterEtudiant(etu8);
        gestion.ajouterEtudiant(etu9);
        gestion.ajouterEtudiant(etu10);
        gestion.ajouterEtudiant(etu11);
        gestion.ajouterEtudiant(etu12);
        gestion.ajouterEtudiant(etu13);
        gestion.ajouterEtudiant(etu14);
        gestion.ajouterEtudiant(etu15);
        gestion.ajouterEtudiant(etu16);
        gestion.ajouterEtudiant(etu17);
        gestion.ajouterEtudiant(etu18);
        gestion.ajouterEtudiant(etu19);
        gestion.ajouterEtudiant(etu20);
        gestion.ajouterEtudiant(etu21);
        gestion.ajouterEtudiant(etu22);
        gestion.ajouterEtudiant(etu23);
        gestion.ajouterEtudiant(etu24);
        gestion.ajouterEtudiant(etu25);
 
        gestion.afficherEtudiantParFiliere("Mathématiques");



    }
}
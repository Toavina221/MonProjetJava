package ressourcesHumaines;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ArrayList;

public class Evaluation {
    //Encapsulation
    private String idEvaluation;
    private Employe employe;
    private Employe evaluateur;
    private LocalDate dateEvaluation;
    private String periode; 
    private double noteGlobale;
    private HashMap<String, Integer> competences;
    private String commentaires;
    private ArrayList<String> objectifsFuturs;
    private String recommandation; 

    //Méthodes
    //Constructeur 
    public Evaluation(String idEvaluation, Employe employe, Employe evaluateur, LocalDate dateEvaluation, String periode, double noteGlobale, HashMap<String, Integer> competences, String commentaires, ArrayList<String> objectifsFuturs, String recommandation){
        if(idEvaluation == null || idEvaluation.trim().isEmpty())
            throw new IllegalArgumentException("L'id de l'évaluation ne peut pas être null ou vide");
        else this.idEvaluation =  idEvaluation;
        if(employe == null)
            throw new IllegalArgumentException("L'employé ne peut pas être null");
        else this.employe = employe;
        if(evaluateur == null)
            throw new IllegalArgumentException("L'evaluateur ne peut pas être null");
        else this.evaluateur = evaluateur;
        if(dateEvaluation == null)
            throw new IllegalArgumentException("La date de l'évaluation ne peut pas être null");
        else this.evaluateur = evaluateur;
        if (periode == null || periode.trim().isEmpty())
            throw new IllegalArgumentException("La période de l'évaluation ne peut pas être null ou vide");
        else this.periode = periode;
        if(noteGlobale < 0 && noteGlobale > 20)
            throw new IllegalArgumentException("Note globale invalide");
        else this.noteGlobale = noteGlobale;
        if(competences == null) 
            throw new IllegalArgumentException("La liste des competences ne peut pas être null");
        else this.competences = new HashMap<>();
        if(commentaires == null || commentaires.trim().isEmpty())
            throw new IllegalArgumentException("Les commentaires ne peuvent pas être null ou vides");
        else this.commentaires = commentaires;
        if(objectifsFuturs == null)
            throw new IllegalArgumentException("la liste des objetifs ne peut pas être null");
        else objectifsFuturs = new ArrayList<>();
        if(recommandation == null || recommandation.trim().isEmpty())
            throw new IllegalArgumentException("La recoomandation ne peut pas être null ou vide");
        else this.recommandation = recommandation;
    }

    //Getters
    public String getIdEvaluation(){return idEvaluation;}
    public Employe getEmploye(){return employe;}
    public Employe getEvaluateur(){return evaluateur;}
    public LocalDate getDateEvaluation(){return dateEvaluation;}
    public String getPeriode(){return periode;}
    public double getNoteGlobale(){return noteGlobale;}
    public HashMap<String, Integer> getCompetences(){return competences;}
    public String getCommentaires(){return commentaires;}
    public ArrayList<String> getObjectifsFuturs(){return objectifsFuturs;}
    public String getRecommandation(){return recommandation;}

    //Setters
    public void setIdEvaluation(String idEvaluation){
        if(idEvaluation == null || idEvaluation.trim().isEmpty())
            throw new IllegalArgumentException("L'id de l'évaluation ne peut pas être null ou vide");
        else this.idEvaluation =  idEvaluation;
    }
    public void setEmploye(Employe employe){
        if(employe == null)
            throw new IllegalArgumentException("L'employé ne peut pas être null");
        else this.employe = employe;
    }
    public void setEvaluateur(Employe evaluateur){
        if(evaluateur == null)
            throw new IllegalArgumentException("L'evaluateur ne peut pas être null");
        else this.evaluateur = evaluateur;
    }
    public void setDateEvaluation(LocalDate dateEvaluation){
        if(dateEvaluation == null)
            throw new IllegalArgumentException("La date de l'évaluation ne peut pas être null");
        else this.evaluateur = evaluateur;
    }
    public void setPeriode(String periode){
        if (periode == null || periode.trim().isEmpty())
            throw new IllegalArgumentException("La période de l'évaluation ne peut pas être null ou vide");
        else this.periode = periode;
    }
    public void setNoteGlobale(double noteGlobale){
        if(noteGlobale < 0 && noteGlobale > 20)
            throw new IllegalArgumentException("Note globale invalide");
        else this.noteGlobale = noteGlobale;
    }
    public void setCompetences(HashMap<String, Integer> competences){
        if(competences == null) 
            throw new IllegalArgumentException("La liste des competences ne peut pas être null");
        else this.competences = new HashMap<>();
    }
    public void setCommentaires(String commentaires){
        if(commentaires == null || commentaires.trim().isEmpty())
            throw new IllegalArgumentException("Les commentaires ne peuvent pas être null ou vides");
        else this.commentaires = commentaires;
    }
    public void setObjectifsFuturs(ArrayList<String> objectifsFuturs){
        if(objectifsFuturs == null)
            throw new IllegalArgumentException("la liste des objetifs ne peut pas être null");
        else objectifsFuturs = new ArrayList<>();
    }
    public void setRecommandation(String recommandation){
        if(recommandation == null || recommandation.trim().isEmpty())
            throw new IllegalArgumentException("La recoomandation ne peut pas être null ou vide");
        else this.recommandation = recommandation;
    }

    //toString()
    public String toString(){
        return  "Evaluation :" + 
        "\n--------------" + 
        "\nid : " + idEvaluation + 
        "\nEmploye : " + employe.getMatricule() + 
        "\nEvaluateur : " + evaluateur.getMatricule() + 
        "\nNote globale : " + noteGlobale; 
    }

    //ajouter une competence dans hashmap competences
    public void ajouterCompetence(String competence, int note){
        if (competence != null && !competence.trim().isEmpty() && note <= 20 && note >=0  ) {
           if(competences.containsKey(competence))
                throw new IllegalArgumentException("Cette competence existe déja");
            else competences.put(competence, note);
            return;
        }
        throw new IllegalArgumentException("La competence ne peut ni  être null ni vide , et la note ne peut pas être invalide ");
    }

    // calculer la moyenne des competences 
    public Optional<Double> calculerMoyenneCompetences(){
        if(competences.isEmpty())
            return Optional.empty();
        int  somme = 0;
        for(Integer note : competences.values())
            somme += note;
        return Optional.of((double) somme/competences.size()) ;
    }

    //retourner les compétences à améliorer
    public List<String> suggereFormation(){
        Optional<Double> moyenneOpt = calculerMoyenneCompetences();
        if(moyenneOpt.isEmpty())
            return new ArrayList<>(); 
        double moyenne = moyenneOpt.get();
        List<String> aAmeliorer = new ArrayList<>();
            for(String competence : competences.keySet()){
                if(competences.get(competence) < moyenne)
                    aAmeliorer.add(competence);
            }
        return aAmeliorer;
    }
}

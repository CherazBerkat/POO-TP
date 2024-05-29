package com.example.tp.Models;
import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class SerieQuestion extends Test implements Serializable {
    //***********************************************LES ATTRIBUTS****************************************************//
    Set<Question> questions = new HashSet<>();
    //***********************************************CONSTRUCTEUR*****************************************************//
    public SerieQuestion (String n,String c){
       super(n,c);
    }
    //****************************************************GETTERS*****************************************************//
    public Set<Question> getQuestions(){
        return questions;
    }
    //************************************************* METHODS ******************************************************//
    public float calculerScoreTotale(){
        float sum=0;
        for(Question q: questions){
            sum+=q.getScore();
        }
        return sum/questions.size();
    }

    public void addQuestion(Question question) {
        if (!questions.contains(question)) {
            questions.add(question);
        } else {
            System.out.println("The question already exists in the set.");
        }
    }

    public void deleteQuestionByIndex(int index) {
        if (index < 0 || index >= questions.size()) {
            System.out.println("Invalid index. No question deleted.");
            return;
        }
        List<Question> questionList = new ArrayList<>(questions);
        questionList.remove(index);
        questions = new HashSet<>(questionList);
    }
}


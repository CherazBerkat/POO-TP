package com.example.tp.Models;
import java.io.Serializable;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class SerieQuestion extends Test implements Serializable {
    Set<Question> questions = new HashSet<>();
    public SerieQuestion (String n,String c){
       super(n,c);
    }
    public float calculerScoreTotale(){
        float sum=0;
        for(Question q: questions){
            sum+=q.getScore();
        }
        return sum/questions.size();
    }
    public  void compteRendu(){
        Scanner scanner = new Scanner(System.in);
        for(Question q: questions){
                int score;
                do {
                    System.out.print("Enter the score for " + q.getText() + ": ");
                    score = scanner.nextInt();
                    if (score < 1 || score > 10) {
                        System.out.println("Invalid score. Please enter a score between 1 and 10.");
                    }
                } while (score < 1 || score > 10);
                q.setScore(score);
        }
    }
    public void addQuestion(Question question) {
        if (!questions.contains(question)) {
            questions.add(question);
        } else {
            System.out.println("The question already exists in the set.");
        }
    }
    public void deleteQuestion(Question question) {
        if (!questions.contains(question)) {
            System.out.println("The question does not exist in the set.");
        } else {
            questions.remove(question);
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


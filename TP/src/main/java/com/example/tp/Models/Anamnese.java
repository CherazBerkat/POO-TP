package com.example.tp.Models;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Anamnese implements Serializable {
  protected ArrayList<QuestionAnam> questions= new ArrayList<>();

    /******************************************************** GETTER **************************************************/

    public ArrayList<QuestionAnam> getQuestions() {
    return questions;
  }
    /******************************************************** METHODS **************************************************/

    public  abstract void ajouterQuestion(QuestionAnam q);
    public  void deleteQuestion(int ind){
      if (ind >= 0 && ind < questions.size())
      questions.remove(ind);
      else System.out.println("Index non valid , No question has been removed");
    };
}
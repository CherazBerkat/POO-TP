package com.example.tp.Models;

import java.io.Serializable;
import java.util.Objects;

public class Question implements Serializable {
    //***********************************************LES ATTRIBUTS****************************************************//
    private String text;
    private int Score;
    //***********************************************CONSTRUCTEUR*****************************************************//
    public Question(String t){
        text=t;
        Score=0;
    }
    //****************************************************GETTERS*****************************************************//
    public int getScore() {
        return Score;
    }

    public String getText() {
        return text;
    }
    //****************************************************SETTERS*****************************************************//
    public void setScore(int score) {
        Score = score;
    }

    public void setText(String text) {
        this.text = text;
    }
    //************************************************* METHODS ******************************************************//
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Question other = (Question) obj;
        return text.equals(other.text);
    }
    public int hashCode() {
        return Objects.hash(text);
    }
}

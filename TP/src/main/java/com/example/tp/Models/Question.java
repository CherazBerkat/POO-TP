package com.example.tp.Models;

import java.io.Serializable;
import java.util.Objects;

public class Question implements Serializable {
    private String text;
    private int Score;

    public Question(String t){
        text=t;
        Score=0;
    }

    public void setScore(int score) {
        Score = score;
    }

    public int getScore() {
        return Score;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

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

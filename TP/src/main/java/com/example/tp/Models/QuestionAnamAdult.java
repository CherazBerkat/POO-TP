package com.example.tp.Models;

import java.io.Serializable;

public class QuestionAnamAdult extends QuestionAnam implements Serializable {
    private TypeAnamneseAdulte type;
    /**************************************************** CONSTRUCTEUR *****************************************************/

    public QuestionAnamAdult(String t,TypeAnamneseAdulte tp){
        super(t);
        type=tp;
    }

    /**************************************************** SETTER *****************************************************/

    public void setType(TypeAnamneseAdulte type) {
        this.type = type;
    }

   /******************************************************** GETTER **************************************************/

    public TypeAnamneseAdulte getTypeAdult(){
        return type;
    }
}

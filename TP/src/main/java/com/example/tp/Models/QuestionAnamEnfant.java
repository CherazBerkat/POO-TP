package com.example.tp.Models;

import java.io.Serializable;

public class QuestionAnamEnfant extends QuestionAnam implements Serializable {
    private TypeAnamneseEnfant type;

    /**************************************************** CONSTRUCTEUR *****************************************************/

    public QuestionAnamEnfant(String t,TypeAnamneseEnfant tp){
        super(t);
        type=tp;
    }

    /**************************************************** SETTER *****************************************************/

    public void setType(TypeAnamneseEnfant type) {
        this.type = type;
    }
    /******************************************************** GETTER **************************************************/

    public TypeAnamneseEnfant getTypeEnfant(){
        return type;
    }
}

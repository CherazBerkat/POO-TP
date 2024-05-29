package com.example.tp.Models;

import java.io.Serializable;

public enum TypeAnamneseEnfant implements Serializable {
    STRUCTUREFAMILIALE,
    DYNAMIQUEFAMILIALE,
    ANTECEDENTSFAMILIAUX,
    CONDITIONSNATALES,
    DEVELOPPEMENTPSYCHOMOTEUR,
    DEVELOPPEMENTLANGAGIER,
    CARACTEREETCOMPORTEMENT;

    public String stringfy(TypeAnamneseEnfant t){
       switch (t){
           case CONDITIONSNATALES -> {
               return "Conditions Natales";
           }
           case DYNAMIQUEFAMILIALE -> {
               return "Dynamique Familiale";
           }
           case ANTECEDENTSFAMILIAUX -> {
               return "Antecedents Familiaux";
           }
           case STRUCTUREFAMILIALE -> {
               return "Structeur Familiale";
           }
           case CARACTEREETCOMPORTEMENT -> {
               return "Caractere et Comportement";
           }
           case DEVELOPPEMENTLANGAGIER -> {
               return "Developpement Langagier";
           }
           case DEVELOPPEMENTPSYCHOMOTEUR -> {
               return "Developpement Psychomoteur";
           }
           default -> {
               return "";
           }
       }
    }
}

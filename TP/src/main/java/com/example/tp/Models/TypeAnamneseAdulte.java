package com.example.tp.Models;

import java.io.Serializable;

public enum TypeAnamneseAdulte implements Serializable {
    HISTOIREDEMALADIE,
    SUIVIMEDICAL;
    public String stringfy(TypeAnamneseAdulte t){
        switch (t){
            case SUIVIMEDICAL -> {
                return "Suivi Medical";
            }
            case HISTOIREDEMALADIE -> {
                return "Histoire de maladie";
            }
            default -> {
                return "";
            }
        }
    }
}
package com.example.tp.Models;

import java.io.Serializable;

public enum TypeObjectif implements Serializable {
    COURTTERME,
    MOYENTERME,
    LONGTERME;

    public String stringfy(){
        switch (this){
            case COURTTERME -> {
                return "COURT TERME";
            }
            case MOYENTERME -> {
                return "MOYEN TERME";
            }
            case LONGTERME->{
                return "LONG TERME";
            }
            default -> {
                return "";
            }
        }
    }
}
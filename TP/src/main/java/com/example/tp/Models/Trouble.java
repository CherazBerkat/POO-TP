package com.example.tp.Models;

import java.io.Serializable;

public class Trouble implements Serializable {
    private String nom;
    private TypeTrouble type;

    public Trouble(String n, TypeTrouble t)
    {
        nom = n;
        type = type;
    }
}
package com.example.tp.Models;

public class PremierBO extends BO {
    private Anamnese anamnese;
    public PremierBO(Diagnostic d, EpreuveClinique e, String p, Anamnese a) ////chofihaaa rahi fiha zyada jsp
    {
        super(d,p);
        anamnese = a;
    }

}
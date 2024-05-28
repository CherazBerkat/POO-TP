
package com.example.tp.Models;

import java.io.Serializable;

public class PremierBO extends BO implements Serializable {

    private Anamnese anamnese;
    public PremierBO( Anamnese a)
    {
        anamnese = a;
    }

}
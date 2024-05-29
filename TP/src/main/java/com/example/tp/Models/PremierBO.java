
package com.example.tp.Models;

import java.io.Serializable;

public class PremierBO extends BO implements Serializable {

    private Anamnese anamnese;

    public PremierBO()
    {
        super();
    }
    public PremierBO( Anamnese a)
    {
        anamnese = a;
    }

    public Anamnese getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(Anamnese anamnese) {
        this.anamnese = anamnese;
    }

}

package com.example.tp.Models;

import java.io.Serializable;

public class PremierBO extends BO implements Serializable {

    private Anamnese anamnese;

    public PremierBO()
    {
        super();
    }
    public PremierBO( String p, Anamnese a)
    {
        super(p);
        anamnese = a;
    }

    public Anamnese getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(Anamnese anamnese) {
        this.anamnese = anamnese;
    }
}
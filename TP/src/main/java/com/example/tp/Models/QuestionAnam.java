package com.example.tp.Models;

import java.io.Serializable;

public class QuestionAnam  implements Serializable {
    private String text;

    //**************************************************** CONSTRUCTEUR ***********************************************//
     public QuestionAnam(String t){
         text=t;
     }

    //**************************************************** SETTER *****************************************************//

    public void setText (String t){
        text=t;
    }

    //******************************************************** GETTER *************************************************//

    public String getText() {
        return text;
    }
}

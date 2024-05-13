package com.example.tp.Models;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import static com.example.tp.HelloApplication.*;

public class Ortho extends Person implements  Serializable{
    private String mail;
    private String passwd;
    private String userName;
    private ArrayList<SerieExo> serieExos =new ArrayList<>();
    private ArrayList<SerieQuestion> serieQuestions=new ArrayList<>();
    public Ortho (String n,String p,String t,String m,String pd){
        super(n,p,t);
        mail=m;
        passwd=pd;
    }
    public Ortho(){}

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswd(){
        return passwd;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
     public String getUserNAme(){
        return userName;
     }
    public void addSerieExos(SerieExo s){
        serieExos.add(s);
    }
    public void addSerieQuestions(SerieQuestion s){
        serieQuestions.add(s);
    }
    public void deleteSerieExosIndx (int index){
        if (index >= 0 && index < serieExos.size()) {
            serieExos.remove(index);
        } else {
            System.out.println("Invalid index. No Serie Exos deleted.");
        }
    }

    public void deleteSerieQuestionsIndx (int index){
        if (index >= 0 && index < serieQuestions.size()) {
            serieQuestions.remove(index);
        } else {
            System.out.println("Invalid index. No Serie Exos deleted.");
        }
    }

    public void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(FILE_PATH))) {
            out.writeObject(orthophonist);
            System.out.println("data is saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

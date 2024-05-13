package com.example.tp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
public class SerieExo extends Test implements Serializable {

    private ArrayList<Exo> exos = new ArrayList<>();
    public SerieExo(String n,String c){
        super(n,c);
    }
    public void addExo(Exo exo) {
        exos.add(exo);
    }
    // Method to delete all the occurences
    public void deleteExo(Exo exoToDelete) {
        ArrayList<Exo> exosToRemove = new ArrayList<>();
        for (Exo exo : exos) {
            if (exo.equals(exoToDelete)) {
                exosToRemove.add(exo);
            }
        }
        exos.removeAll(exosToRemove);
    }
    // Method to delete an Exo from the list based on index
    public void deleteExoIndx(int index) {
        if (index >= 0 && index < exos.size()) {
            exos.remove(index);
        } else {
            System.out.println("Invalid index. No Exo deleted.");
        }
    }
    public void compteRendu() {
        Scanner scanner = new Scanner(System.in);
        for (Exo exo : exos) {
            int score;
            do {
                System.out.print("Enter the score for " + exo.getConsigne() + ": ");
                score = scanner.nextInt();
                if (score < 1 || score > 10) {
                    System.out.println("Invalid score. Please enter a score between 1 and 10.");
                }
            } while (score < 1 || score > 10);
            exo.setScore(score);
        }
    }
    public float calculerScoreTotale(){
        int sum=0;
        int counter=0;
        float sumtot=0;
        int compt=0;
        ArrayList<Exo> exosNew = new ArrayList<>(exos);
        for (int i = 0; i < exosNew.size(); i++) {
            sum = 0;
            counter = 0;
            Exo exo = exosNew.get(i);
            for (Exo exo2 : exosNew) {
                if (exo.equals(exo2)) {
                    sum += exo2.getScore();
                    counter++;
                }
            }
            sumtot += (sum / counter);
            // Remove the processed elements from exosNew
            exosNew.removeIf(exo2 -> exo.equals(exo2));
            compt++;
        }
        return sumtot/compt;
    }
    public void afficher(){
        super.afficher();
        for (Exo exo : exos) {
            exo.afficher();
        }
    }

}

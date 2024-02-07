package com.antoinebeaudry.garage_mobile.classes;

public class Cnotif {

    String nom;
    String date;
    String heureDeb;
    String heureFin;




    public Cnotif(String nom, String date, String heureDeb, String heureFin) {
        this.nom = nom;
        this.date = date;
        this.heureDeb = heureDeb;
        this.heureFin = heureFin;

    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeureDeb() {
        return heureDeb;
    }

    public void setHeureDeb(String heureDeb) {
        this.heureDeb = heureDeb;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }
}

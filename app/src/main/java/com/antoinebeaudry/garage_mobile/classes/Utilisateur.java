package com.antoinebeaudry.garage_mobile.classes;

import com.google.gson.annotations.SerializedName;

public class Utilisateur {

    @SerializedName("id")
    int id;

    @SerializedName("prenom")
    String prenom;
    @SerializedName("nom")
    String nom;
    @SerializedName("email")
    String email;

    @SerializedName("adresse")
    String adresse;

    @SerializedName("telepone")
    String telepone;

    @SerializedName("password")
    String password;




    public Utilisateur(int id, String nom, String email, String adresse, String telepone, String password , String prenom)
    {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
        this.telepone = telepone;
        this.password = password;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelepone() {
        return telepone;
    }

    public void setTelepone(String telepone) {
        this.telepone = telepone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}

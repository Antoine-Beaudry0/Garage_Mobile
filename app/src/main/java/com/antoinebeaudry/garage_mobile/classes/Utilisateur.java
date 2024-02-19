package com.antoinebeaudry.garage_mobile.classes;

import com.google.gson.annotations.SerializedName;

public class Utilisateur {

    @SerializedName("id")
    int id;

    @SerializedName("nom")
    String nom;

    @SerializedName("email")
    String email;

    public Utilisateur(int id, String nom, String email)
    {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}

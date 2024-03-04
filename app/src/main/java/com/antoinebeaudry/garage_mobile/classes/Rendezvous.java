package com.antoinebeaudry.garage_mobile.classes;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class Rendezvous {

    @SerializedName("id")
    private int id;

    @SerializedName("services")
    private JsonObject services;

    @SerializedName("dateHeureDebut")
    private String dateHeureDebut;

    @SerializedName("dateHeureFin")
    private String dateHeureFin;

    @SerializedName("commentaire")
    private String commentaire;

    @SerializedName("notificationEnvoye")
    private boolean notificationEnvoye;

    @SerializedName("id_Voiture")
    private int id_Voiture;

    @SerializedName("id_Statut")
    private int id_Statut;

    // Constructeur
    public Rendezvous(int id, JsonObject services, String dateHeureDebut, String dateHeureFin, String commentaire, boolean notificationEnvoye, int id_Voiture, int id_Statut) {
        this.id = id;
        this.services = services;
        this.dateHeureDebut = dateHeureDebut;
        this.dateHeureFin = dateHeureFin;
        this.commentaire = commentaire;
        this.notificationEnvoye = notificationEnvoye;
        this.id_Voiture = id_Voiture;
        this.id_Statut = id_Statut;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JsonObject getServices() {
        return services;
    }

    public void setServices(JsonObject services) {
        this.services = services;
    }

    public String getDateHeureDebut() {
        return dateHeureDebut;
    }

    public void setDateHeureDebut(String dateHeureDebut) {
        this.dateHeureDebut = dateHeureDebut;
    }

    public String getDateHeureFin() {
        return dateHeureFin;
    }

    public void setDateHeureFin(String dateHeureFin) {
        this.dateHeureFin = dateHeureFin;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public boolean isNotificationEnvoye() {
        return notificationEnvoye;
    }

    public void setNotificationEnvoye(boolean notificationEnvoye) {
        this.notificationEnvoye = notificationEnvoye;
    }

    public int getId_Voiture() {
        return id_Voiture;
    }

    public void setId_Voiture(int id_Voiture) {
        this.id_Voiture = id_Voiture;
    }

    public int getId_Statut() {
        return id_Statut;
    }

    public void setId_Statut(int id_Statut) {
        this.id_Statut = id_Statut;
    }
}

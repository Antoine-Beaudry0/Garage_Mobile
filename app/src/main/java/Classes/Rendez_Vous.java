package Classes;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Rendez_Vous {
    @SerializedName("id")
    private String id;


    @SerializedName("voiture_details")
    private VoitureDetails voitureDetails;

    @SerializedName("services")
    private List<Servic_Rendezvous> services;

    @SerializedName("dateHeureDebut")
    private String dateHeureDebut;

    @SerializedName("dateHeureFin")
    private String dateHeureFin;


    @SerializedName("tel")
    private String tel;

    @SerializedName("notificationEnvoye")
    private int notificationEnvoye;

    @SerializedName("id_Voiture")
    private int id_Voiture;

    @SerializedName("id_Statut")
    private int id_Statut;

    // Constructeur
    public Rendez_Vous(String id,VoitureDetails voitureDetails, List<Servic_Rendezvous> services, String dateHeureDebut, String dateHeureFin, String tel, int notificationEnvoye, int id_Voiture, int id_Statut) {
        this.id = id;
        this.voitureDetails = voitureDetails;
        this.services = services;
        this.dateHeureDebut = dateHeureDebut;
        this.dateHeureFin = dateHeureFin;
        this.tel = tel;
        this.notificationEnvoye = notificationEnvoye;
        this.id_Voiture = id_Voiture;
        this.id_Statut = id_Statut;
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public VoitureDetails getVoitureDetails() {
        return voitureDetails;
    }

    public void setVoitureDetails(VoitureDetails voitureDetails) {
        this.voitureDetails = voitureDetails;
    }



    public void setId(String id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }




    public List<Servic_Rendezvous> getServices() {
        return services;
    }

    public void setServices(List<Servic_Rendezvous> services) {
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


    public int isNotificationEnvoye() {
        return notificationEnvoye;
    }

    public void setNotificationEnvoye(int notificationEnvoye) {
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

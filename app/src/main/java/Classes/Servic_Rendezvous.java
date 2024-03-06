package Classes;

import com.google.gson.annotations.SerializedName;

public class Servic_Rendezvous {

    Rendez_Vous rendezVous;
    @SerializedName("prix")
    private String prix;

    @SerializedName("type")
    private String type;

    @SerializedName("temps")
    private String temps;

    @SerializedName("titre")
    private String titre;

    @SerializedName("chosen")
    private boolean chosen;

    @SerializedName("position")
    private int position;

    @SerializedName("id_prestation")
    private int id_prestation;

    // Constructeur
    public Servic_Rendezvous(String prix, String type, String temps, String titre, boolean chosen, int position, int id_prestation) {
        this.prix = prix;
        this.type = type;
        this.temps = temps;
        this.titre = titre;
        this.chosen = chosen;
        this.position = position;
        this.id_prestation = id_prestation;
    }

    // Getters et setters
    public String getPrix() {
        return prix;
    }
    public String getPrixString() {
        return prix + "$";
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public boolean isChosen() {
        return chosen;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }

    public int getPosition() {
        return position;
    }
    public String getPosition_String() {
        return String.valueOf(position);
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getId_prestation() {
        return id_prestation;
    }

    public String getId_prestation_String() {
        return String.valueOf(id_prestation);
    }

    public void setId_prestation(int id_prestation) {
        this.id_prestation = id_prestation;
    }
}
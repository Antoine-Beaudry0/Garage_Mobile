package Classes;

import com.google.gson.annotations.SerializedName;

public class VoitureDetails {

    @SerializedName("marque")
    private String marque;

    @SerializedName("modele")
    private String modele;

    // Constructeur
    public VoitureDetails(String marque, String modele) {
        this.marque = marque;
        this.modele = modele;
    }

    // Getters et Setters
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }


}

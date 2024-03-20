package Classes;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReponseServeur {
    List<Rendez_Vous> data;
    @SerializedName("message")
    String message;
    String token;
    boolean statut;

    public ReponseServeur(List<Rendez_Vous> data, String message, String token, boolean statut) {
        this.data = data;
        this.message = message;
        this.token = token;
        this.statut = statut;
    }

    /*public ReponseServeur(List<Rendez_Vous> data) {
        this.data = data;
    }*/

    public List<Rendez_Vous> getData() {
        return data;
    }

    public void setData(List<Rendez_Vous> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }
}

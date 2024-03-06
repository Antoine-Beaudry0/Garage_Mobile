package Classes;

import java.util.List;

public class ReponseServeur {
    List<Rendez_Vous> data;

    public ReponseServeur(List<Rendez_Vous> data) {
        this.data = data;
    }

    public List<Rendez_Vous> getData() {
        return data;
    }

    public void setData(List<Rendez_Vous> data) {
        this.data = data;
    }
}

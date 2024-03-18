package Classes;

import com.google.gson.annotations.SerializedName;

public class Users {

    @SerializedName("id")
    private int id;

    @SerializedName("email")
    private String email;

    @SerializedName("prenom")
    private String prenom;

    @SerializedName("nom")
    private String nom;


    public Users(int id, String email, String prenom, String nom) {
        this.id = id;
        this.email = email;
        this.prenom = prenom;
        this.nom = nom;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                '}';


    }
}

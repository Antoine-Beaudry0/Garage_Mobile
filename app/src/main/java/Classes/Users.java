package Classes;

import com.google.gson.annotations.SerializedName;

public class Users {

    @SerializedName("email")
    String email;
    @SerializedName("password")
    String password;
    @SerializedName("prenom")
    String prenom;
    @SerializedName("telephone")
    String telephone;
    @SerializedName("adresse")
    String adresse;
    @SerializedName("nom")
    String nom;

    public Users(String email, String password, String prenom, String telephone, String adresse, String nom) {
        this.email = email;
        this.password = password;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.nom = nom;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }







}

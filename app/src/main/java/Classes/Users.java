package Classes;

import com.google.gson.annotations.SerializedName;

public class Users {


    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", adresse='" + adresse + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }

    @SerializedName("id")

    int id;

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

    public Users(int id ,String email, String password, String prenom, String telephone, String adresse, String nom) {
        this.email = email;
        this.password = password;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.nom = nom;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





}

package com.antoinebeaudry.garage_mobile.classes;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface InterfaceServeur {

    @GET("/appli/getListeUtilisateurs.php")
    Call<List<Utilisateur>> getListeUtilisateurs();

    @GET("/appli/getListeUtilisateurs.php")
    Call<ResponseBody> getListeUtilisateursBiss();

    @GET("/appli/getUtilisateur.php")
    Call<Utilisateur> getUtilisateurByid(@Query("id") int id);  // cette ligne permet d'avoir la cle id et la valeur mise en paramettre . donc son id et sa valeur et le mot query permets de rechercher l,utilisateur avec id.
    // le query permets d'obtenir le id de l,utilisateur pour avoir ses informations.


    @POST("/appli/addUtilisateur.php")
    @FormUrlEncoded
    Call<Boolean> ajoutUtilisateur(@Field("nom") String nom,
                                   @Field("email") String email, @Field("adresse") String adresse, @Field("telephone") String telephone, @Field("prenom") String prenom,
     @Field("password") String password);
}

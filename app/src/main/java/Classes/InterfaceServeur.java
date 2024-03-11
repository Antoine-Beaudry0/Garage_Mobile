package Classes;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface InterfaceServeur {
    /*@GET("/api/rendezvous")
    Call<List<Rendez_Vous>> getListeRendezvous();*/
    @FormUrlEncoded
    @POST("/api/users/login")
    Call<ReponseServeur> login(@Field("email") String username,
                               @Field("password") String mdp
                               );
    @GET("/api/rendezvous")
    Call<ReponseServeur> getListeRendezvous();

    @GET("/api/rendezvous/confirme")
    Call<ReponseServeur> getListeRendezvousConfirme();

    @GET("/api/rendezvous/encours")
    Call<ReponseServeur> getListeRendezvousEncours();

}


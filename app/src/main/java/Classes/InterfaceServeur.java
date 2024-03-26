package Classes;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface InterfaceServeur {
    /*@GET("/api/rendezvous")
    Call<List<Rendez_Vous>> getListeRendezvous();*/
    @FormUrlEncoded
    @POST("/api/logingarage")
    Call<LoginResponse> login(@Field("email") String username,
                               @Field("password") String mdp
                               );
    @GET("/api/rendezvous")
    Call<ReponseServeur> getListeRendezvous();

    @GET("/api/rendezvous/confirme")
    Call<ReponseServeur> getListeRendezvousConfirme();

    @GET("/api/rendezvous/nonconfirme")
    Call<ReponseServeur> getListeRendezvousnonConfirme();


    // la route pour appeler la notifications

    @POST("/api/notifications/notifications/send/{notification}")
    Call<ReponseServeur> getNotifications(String id);

    @GET("/api/rendezvous/encours")
    Call<ReponseServeur> getListeRendezvousEncours();


    @PATCH("/api/rendezvous/terminer/{id}")
    Call<ReponseServeur> termine(@Path("id") String id);

    @PATCH("/api/rendezvous/terminer/{id}")
    Call<ResponseBody> termine2(@Path("id") String id);
    @PATCH("/api/rendezvous/confirmer/{id}")
    Call<ReponseServeur> confirme(@Path("id") String id);

    @POST("/api/logout")
    Call<ReponseServeur> logout(String Auth);

}


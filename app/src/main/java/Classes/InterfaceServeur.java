package Classes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceServeur {
    /*@GET("/api/rendezvous")
    Call<List<Rendez_Vous>> getListeRendezvous();*/

    @GET("/api/login")
    Call<ReponseServeur> login(@Query("username") String username,
                               @Query("mdp") String mdp
                               );

    @GET("/api/rendezvous")
    Call<ReponseServeur> getListeRendezvous();

    @GET("/api/rendezvous/encours")
    Call<ReponseServeur> getListeRendezvousConfirme();

}


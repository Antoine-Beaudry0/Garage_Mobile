package com.example.garage_mobile2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import Classes.AdapterListeRendezVous;
import Classes.InterfaceServeur;
import Classes.Rendez_Vous;
import Classes.ReponseServeur;
import Classes.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class fragment_RendezvousEncoursV extends Fragment {


    RecyclerView recyclerViewRendezVousEncours;



    public fragment_RendezvousEncoursV() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.layout_fragment__rendezvous_encours_v, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewRendezVousEncours = view.findViewById(R.id.rvRendezvousEncours);
        recyclerViewRendezVousEncours.setLayoutManager(new LinearLayoutManager(getContext()));

        getRendezVousEncours();

        Button btnRendezVousTermine;

        btnRendezVousTermine = view.findViewById(R.id.btnRendezVousTermine);

        /*btnRendezVousTermine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InterfaceServeur serveur = RetrofitInstance.getInstance().create(InterfaceServeur.class);

                Call<ReponseServeur> call = serveur.getNotifications();
                call.enqueue(new Callback<ReponseServeur>() {
                    @Override
                    public void onResponse(Call<ReponseServeur> call, Response<ReponseServeur> response) {
                        //ReponseServeur ReponseServeur = response.body();

                        if (response.isSuccessful()) {

                            Toast.makeText(getContext(), "réussi", Toast.LENGTH_SHORT).show();


                        } else {
                            Toast.makeText(getContext(), "Email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<ReponseServeur> call, Throwable t) {
                        Log.d("TEST-CONNEXION", t.getMessage());
                        Toast.makeText(getContext(), "Une erreur s'est produite", Toast.LENGTH_SHORT).show();


                    }
                });
                        }

        });

*/
    }

    public void getRendezVousEncours()
    {
        InterfaceServeur serveur = RetrofitInstance.getInstance().create(InterfaceServeur.class);

        Call<ReponseServeur> call = serveur.getListeRendezvousEncours();
        call.enqueue(new Callback<ReponseServeur>() {
            @Override
            public void onResponse(Call<ReponseServeur> call, Response<ReponseServeur> response) {
                if (response.isSuccessful()) {

                    List<Rendez_Vous> listeRendezVous = response.body().getData();


                    AdapterListeRendezVous adapterRendezVous = new AdapterListeRendezVous(listeRendezVous, getContext());
                    adapterRendezVous.setHideB(true);
                    recyclerViewRendezVousEncours.setAdapter(adapterRendezVous);
                } else {
                    Toast.makeText(getContext(), "Une erreur s'est produite", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ReponseServeur> call, Throwable t) {
                Log.d("TEST-CONNEXION", t.getMessage());
                Toast.makeText(getContext(), "Une erreur s'est produite", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
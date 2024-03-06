package com.example.garage_mobile2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


public class fragment_rendezvousconfirmer extends Fragment {
    RecyclerView recyclerViewRendezVousEncours;



    public fragment_rendezvousconfirmer() {
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
        return inflater.inflate(R.layout.layout_fragment_rendezvousconfirmer, container, false);
    }

    public void getRendezVous()
    {
        InterfaceServeur serveur = RetrofitInstance.getInstance().create(InterfaceServeur.class);

        Call<ReponseServeur> call = serveur.getListeRendezvous();
        call.enqueue(new Callback<ReponseServeur>() {
            @Override
            public void onResponse(Call<ReponseServeur> call, Response<ReponseServeur> response) {
                if (response.isSuccessful()) {

                    List<Rendez_Vous> listeRendezVous = response.body().getData();


                    AdapterListeRendezVous adapterRendezVous = new AdapterListeRendezVous(listeRendezVous, getContext());
                    recyclerViewRendezVous.setAdapter(adapterRendezVous);
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
package com.example.garage_mobile2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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


public class fragment_RDVNonConfirme extends Fragment {

    RecyclerView recyclerViewRendezVousnonConfirme;




    public fragment_RDVNonConfirme() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.layout_fragmentrdvnon_confirme, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewRendezVousnonConfirme = view.findViewById(R.id.rvNonConfirme);
        recyclerViewRendezVousnonConfirme.setLayoutManager(new LinearLayoutManager(getContext()));


        getRendezVousnonConfirme();
    }

    public void getRendezVousnonConfirme() {

        InterfaceServeur serveur = RetrofitInstance.getInstance().create(InterfaceServeur.class);

        Call<ReponseServeur> call = serveur.getListeRendezvousnonConfirme();
        call.enqueue(new Callback<ReponseServeur>() {
            @Override
            public void onResponse(Call<ReponseServeur> call, Response<ReponseServeur> response) {
                if (response.isSuccessful()) {

                    List<Rendez_Vous> listeRendezVous = response.body().getData();


                    AdapterListeRendezVous adapterRendezVous = new AdapterListeRendezVous(listeRendezVous, getContext());
                    adapterRendezVous.setHideButtons(true);
                    recyclerViewRendezVousnonConfirme.setAdapter(adapterRendezVous);
                } else {
                    Toast.makeText(getContext(), "Une erreur s'est produite", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ReponseServeur> call, Throwable t) {
                Log.d("TEST-CONNEXION", t.getMessage());
                try {
                    Toast.makeText(getContext(), "Une erreur s'est produite", Toast.LENGTH_SHORT).show();
                } catch (Exception exc) {
                }
            }
        });
    }
}
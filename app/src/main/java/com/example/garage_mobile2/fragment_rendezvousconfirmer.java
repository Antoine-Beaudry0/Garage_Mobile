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
import android.widget.Toast;

import java.util.List;

import Classes.AdapterListeRendezVous;
import Classes.InterfaceServeur;
import Classes.Rendez_Vous;
import Classes.ReponseServeur;
import Classes.RetrofitInstance;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class fragment_rendezvousconfirmer extends Fragment {
    RecyclerView recyclerViewRendezVousConfirme;



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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewRendezVousConfirme = view.findViewById(R.id.rvConfirme);
        recyclerViewRendezVousConfirme.setLayoutManager(new LinearLayoutManager(getContext()));

        getRendezVousConfirme();
    }

    public void getRendezVousConfirme()
    {
        InterfaceServeur serveur = RetrofitInstance.getInstance().create(InterfaceServeur.class);

        /*Call<ResponseBody> call = serveur.getListeRendezvousConfirme2();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(getContext(), "Une erreur s'est produite", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getContext(), "Une erreur s'est produite", Toast.LENGTH_SHORT).show();

            }
        });*/


        Call<ReponseServeur> call = serveur.getListeRendezvousConfirme();
        call.enqueue(new Callback<ReponseServeur>() {
            @Override
            public void onResponse(Call<ReponseServeur> call, Response<ReponseServeur> response) {
                if (response.isSuccessful()) {

                    List<Rendez_Vous> listeRendezVous = response.body().getData();


                    AdapterListeRendezVous adapterRendezVous = new AdapterListeRendezVous(listeRendezVous, getContext());
                    recyclerViewRendezVousConfirme.setAdapter(adapterRendezVous);
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
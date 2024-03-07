package com.example.garage_mobile2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import Classes.AdapterListeRendezVous;
import Classes.InterfaceServeur;
import Classes.Rendez_Vous;
import Classes.ReponseServeur;
import Classes.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class fragment_rendezvous extends Fragment {
 RecyclerView recyclerViewRendezVous;
 RecyclerView recyclerViewServices;

 BottomNavigationView bottomNav;
    fragmentConexion fragmentConexion;

    fragment_rendezvous fragmentRendezvous;
    //Fragment_Notif fragment_notif;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    public fragment_rendezvous() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragment_dynamique);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.layout_fragment_rendezvous, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerViewRendezVous = view.findViewById(R.id.recyclerViewRendezVous);
        recyclerViewRendezVous.setLayoutManager(new LinearLayoutManager(getContext()));


        getRendezVous();

        bottomNav = view.findViewById(R.id.bottomNav);
        bottomNav .setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.idFragCon, fragmentConexion);
                    fragmentTransaction.commit();
                    return true;
                } else if (item.getItemId() == R.id.notif) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.idFragrendezvous,fragmentRendezvous);
                    fragmentTransaction.commit();
                    return true;
                }
                return false;
            }
        });


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
package com.antoinebeaudry.garage_mobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.antoinebeaudry.garage_mobile.classes.AdapterListe;
import com.antoinebeaudry.garage_mobile.classes.AdapterUtilisateurs;
import com.antoinebeaudry.garage_mobile.classes.InterfaceServeur;
import com.antoinebeaudry.garage_mobile.classes.RetrofitInstance;
import com.antoinebeaudry.garage_mobile.classes.Utilisateur;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListeUtilisateursActivity extends AppCompatActivity {


    RecyclerView rvUtilisateurs;
    AdapterUtilisateurs adapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_utilisateurs);

        context = this;

        rvUtilisateurs = findViewById(R.id.rvListeUtilisateurs);
        rvUtilisateurs.setHasFixedSize(true);
        rvUtilisateurs.setLayoutManager(new LinearLayoutManager(this));

        getUtilisateur();
    }

    public void getUtilisateur()
    {
        InterfaceServeur serveur = RetrofitInstance.getInstance().create(InterfaceServeur.class);

        Call<List<Utilisateur>> call = serveur.getListeUtilisateurs();

        call.enqueue(new Callback<List<Utilisateur>>() {

            @Override
            public void onResponse(Call<List<Utilisateur>> call, Response<List<Utilisateur>> response) {
                List<Utilisateur> liste = response.body();
                adapter = new AdapterUtilisateurs(liste);
                rvUtilisateurs.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Utilisateur>> call, Throwable t) {
                Toast.makeText(ListeUtilisateursActivity.this,"UNE ERREUR",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void dialognormal()
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Message de Validation");
        builder.setIcon(R.drawable.ic_profile);
        builder.setMessage("l'utilisateur à été bien ajouter");
        builder.setPositiveButton("valider", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.setNegativeButton("Invalid", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNeutralButton("Anuller", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}
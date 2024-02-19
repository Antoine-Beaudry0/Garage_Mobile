package com.antoinebeaudry.garage_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.antoinebeaudry.garage_mobile.classes.InterfaceServeur;
import com.antoinebeaudry.garage_mobile.classes.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Connexion extends AppCompatActivity {


    TextView tbemail;
    TextView tbpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        tbemail = findViewById(R.id.tbemail);
        tbpassword = findViewById(R.id.tbpassword);
    }

    public void gestionClick(View v)
    {
        //getUtilisateur();
        //getUtilisateurByid();
        ajouterutilisateur();
        //getListUtilisateursBiss();
    }

    public void ajouterutilisateur() {
        if (tbemail.getText().toString().trim().isEmpty() || tbpassword.getText().toString().trim().isEmpty())
        {
            Toast.makeText(Connexion.this, "UNE ERREUR", Toast.LENGTH_LONG).show();
        }

        else {


            InterfaceServeur serveur = RetrofitInstance.getInstance().create(InterfaceServeur.class);
            Call<Boolean> call = serveur.ajoutUtilisateur("Lavoie", "Rose");

            call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    boolean resultat = response.body();
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                    Log.e("Erreur", "Erreur lors de l'envoi de la requête", t);
                    Toast.makeText(Connexion.this, "UNE ERREUR: " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }




}
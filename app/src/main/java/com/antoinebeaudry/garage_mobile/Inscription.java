package com.antoinebeaudry.garage_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.antoinebeaudry.garage_mobile.classes.InterfaceServeur;
import com.antoinebeaudry.garage_mobile.classes.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Inscription extends AppCompatActivity {


    EditText tbemail;
    EditText tbadresse;
    EditText tbphone;
    EditText tbnom;
    EditText tbprenom;
    TextView tbpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        tbemail = findViewById(R.id.tbemail);
        tbpassword = findViewById(R.id.tbpassword);
        tbnom = findViewById(R.id.tbnom);
        tbprenom = findViewById(R.id.tbprenom);
        tbphone = findViewById(R.id.tbphone);
        tbadresse = findViewById(R.id.tbadresse);
    }

    public void gestionClick(View v)
    {
        //getUtilisateur();
        //getUtilisateurByid();
        ajouterutilisateur();
        //getListUtilisateursBiss();
    }

    public void ajouterutilisateur() {
        if (tbemail.getText().toString().trim().isEmpty() || tbpassword.getText().toString().trim().isEmpty() || tbnom.getText().toString().trim().isEmpty()
                || tbprenom.getText().toString().trim().isEmpty() || tbphone.getText().toString().trim().isEmpty() || tbadresse.getText().toString().trim().isEmpty())
        {
            Toast.makeText(Inscription.this, "UNE ERREUR", Toast.LENGTH_LONG).show();
        }

        else {


            InterfaceServeur serveur = RetrofitInstance.getInstance().create(InterfaceServeur.class);
            Call<Boolean> call = serveur.ajoutUtilisateur("$nom","$email","$adresse","$telephone","$prenom","$password");

            call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    boolean resultat = response.body();
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                    Log.e("Erreur", "Erreur lors de l'envoi de la requête", t);
                    Toast.makeText(Inscription.this, "UNE ERREUR: " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }




}
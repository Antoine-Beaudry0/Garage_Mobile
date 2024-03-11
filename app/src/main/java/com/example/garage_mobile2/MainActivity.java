package com.example.garage_mobile2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import Classes.AdapterListeUser;
import Classes.Users;

public class MainActivity extends AppCompatActivity  implements AdapterListeUser.interfaceUser {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public void gestionClick(int position, Users user) {
        Intent intent = new Intent(this, Fragment_Profile.class);
        intent.putExtra("nom", user.getNom());
        intent.putExtra("prenom", user.getPrenom());
        intent.putExtra("email", user.getEmail());
        intent.putExtra("phone", user.getTelephone());
        intent.putExtra("adresse", user.getAdresse());

        startActivity(intent);

    }
}
package com.antoinebeaudry.garage_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.antoinebeaudry.garage_mobile.classes.AdapterListe;

import java.util.ArrayList;
import java.util.List;
import com.antoinebeaudry.garage_mobile.classes.Cnotif;

public class Notifications extends AppCompatActivity implements AdapterListe.interfaceNotification{

    List<Cnotif> liste = new ArrayList<>();


    RecyclerView rv;
    AdapterListe adapterListe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);


        rv.setLayoutManager(new LinearLayoutManager(this));// sa aussi marche pour le vertical
        liste.add(new Cnotif("Joyce",  "10-02-2023", "10:00am", "12:00pm"));
        liste.add(new Cnotif("Vanelle",  "10-02-2023", "11:00am", "1:00pm"));
        liste.add(new Cnotif("Tsatia",  "10-02-2023", "12:00pm", "6:00pm"));

        adapterListe = new AdapterListe(liste , this);  // creation dune adapterliste pour pouvoir afficher la liste avec le recycleview

        //adapterListe = ((AdapterListe)rv.getAdapter());
        rv.setAdapter(new AdapterListe(liste, this));
        adapterListe = ((AdapterListe)rv.getAdapter());



    }

    @Override
    public void gestionClick(int position, com.antoinebeaudry.garage_mobile.classes.Notifications notification) {

    }
    /*
    btNotif.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), InformationsParticipants.class);
            launcher.launch(intent);
        }
    });*/


}
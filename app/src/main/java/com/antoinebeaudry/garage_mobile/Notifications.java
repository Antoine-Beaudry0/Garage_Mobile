package com.antoinebeaudry.garage_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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
        liste.add(new Cnotif("Joyce",  "Joyce0", "joyc9", "test"));

        adapterListe = new AdapterListe(liste , this);  // creation dune adapterliste pour pouvoir afficher la liste avec le recycleview

        //adapterListe = ((AdapterListe)rv.getAdapter());
        rv.setAdapter(new AdapterListe(liste, this));
    }

    @Override
    public void gestionClick(int position, com.antoinebeaudry.garage_mobile.classes.Notifications notification) {

    }
}
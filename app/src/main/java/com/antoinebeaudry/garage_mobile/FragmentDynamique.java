package com.antoinebeaudry.garage_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.antoinebeaudry.garage_mobile.Fragment_Notif;
import com.antoinebeaudry.garage_mobile.Fragment_home;
import com.antoinebeaudry.garage_mobile.R;
import com.antoinebeaudry.garage_mobile.classes.AdapterListe;
import com.antoinebeaudry.garage_mobile.classes.Cnotif;
import com.antoinebeaudry.garage_mobile.classes.Notifications;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class FragmentDynamique extends AppCompatActivity implements AdapterListe.interfaceNotification {

    BottomNavigationView bottomNav;
    Fragment_home fragment_home;
    Fragment_Notif fragment_notif;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    List<Cnotif> liste = new ArrayList<>();


    RecyclerView rv;
    AdapterListe adapterListe;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dynamique);
            rv = findViewById(R.id.rv);
            rv.setHasFixedSize(true);

            rv.setLayoutManager(new LinearLayoutManager(this));// sa aussi marche pour le vertical
            liste.add(new Cnotif("Joyce",  "10-02-2023", "10:00am", "12:00pm"));
            liste.add(new Cnotif("Vanelle",  "10-02-2023", "11:00am", "1:00pm"));
            liste.add(new Cnotif("Tsatia",  "10-02-2023", "12:00pm", "6:00pm"));



            fragmentManager = getSupportFragmentManager();


        fragment_notif = new Fragment_Notif();
        fragment_home = new Fragment_home();
        fragment_call = new  Fragment_home();


        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.idFragment, fragment_home);
        fragmentTransaction.commit();


        bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.idFragment, fragment_home);
                    fragmentTransaction.commit();
                    return true;
                } else if (item.getItemId() == R.id.notif) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.idFragment, fragment_notif);
                    fragmentTransaction.commit();
                    return true;
                }
                else if (item.getItemId() == R.id.cal) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.idFragment, Fragment_cal);
                    fragmentTransaction.commit();
                    return true;
                }

                return false;
            }
        });
    }

    @Override
    public void gestionClick(int position, Notifications notification) {

    }
}

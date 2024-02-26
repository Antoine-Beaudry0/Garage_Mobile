package com.antoinebeaudry.garage_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class GestionRendezvousGar extends AppCompatActivity {


    BottomNavigationView bottomNav;
    Fragment_home fragment_home;
    Fragment_Notif fragment_notif;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_rendezvous_gar);


        fragmentManager = getSupportFragmentManager();


        fragment_notif = new Fragment_Notif();
        fragment_home = new Fragment_home();


        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.idFragment, fragment_home);
        fragmentTransaction.commit();

        // Initialise le BottomNavigationView
        bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.flFragment, fragment_home);
                    fragmentTransaction.commit();
                    return true;
                } else if (item.getItemId() == R.id.notif) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.flFragment, fragment_notif);
                    fragmentTransaction.commit();
                    return true;
                }
                return false;
            }
        });
    }
}
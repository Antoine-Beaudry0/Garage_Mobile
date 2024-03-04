package com.antoinebeaudry.garage_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.antoinebeaudry.garage_mobile.Fragment_Notif;
import com.antoinebeaudry.garage_mobile.Fragment_home;
import com.antoinebeaudry.garage_mobile.R;
import com.antoinebeaudry.garage_mobile.classes.AdapterListe;
import com.antoinebeaudry.garage_mobile.classes.Cnotif;
import com.antoinebeaudry.garage_mobile.classes.Notifications;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class FragmentDynamique extends AppCompatActivity implements AdapterListe.interfaceNotification, Fragment_Notif.InterfaceFNotif {

    BottomNavigationView bottomNav;
    Fragment_home fragment_home;
    Fragment_Notif fragment_notif;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dynamique);



            fragmentManager = getSupportFragmentManager();


        fragment_notif = new Fragment_Notif();
        fragment_home = new Fragment_home();



        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.idFragment, fragment_home);
        fragmentTransaction.commit();


        bottomNav = findViewById(R.id.bottomNav);

        //bottomNav.setVisibility(View.GONE);
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
               /* else if (item.getItemId() == R.id.cal) {
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.idFragment, Fragment_cal);
                    fragmentTransaction.commit();
                    return true;*/
               // }

                return false;
            }
        });
    }

    @Override
    public void gestionClick(int position, Notifications notification) {

    }

    @Override
    public void changerVisibilite() {
        bottomNav.setVisibility(View.VISIBLE);
    }
}

package com.antoinebeaudry.garage_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.antoinebeaudry.garage_mobile.R;


import com.antoinebeaudry.garage_mobile.ui.login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {


    Button btnNotif;
    Button btnConnexion;
    Context context;

    Button menu1;
    BottomNavigationView bottomNavigationView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bottomNavigationView = findViewById(R.id.bottom_navigation);

        btnNotif = findViewById(R.id.btnNotification);
        btnConnexion = findViewById(R.id.btnConnexion);
        bottomNavigationView = findViewById(R.id.bottom_navigation);


        btnNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Notifications.class);
                v.getContext().startActivity(intent);
            }
        });

        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),LoginActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_item1) {
                    Toast.makeText(MainActivity.this,"yyyy",Toast.LENGTH_LONG).show();
                    return true;
                }
                else if (item.getItemId() == R.id.menu_item2) {
                    Toast.makeText(MainActivity.this,"Ajouter",Toast.LENGTH_LONG).show();
                    return true;
                }
                else if (item.getItemId() == R.id.menu_item3) {
                    Toast.makeText(MainActivity.this,"Ajouter",Toast.LENGTH_LONG).show();
                    return true;
                }
                else if (item.getItemId() == R.id.menu_item4) {
                    Toast.makeText(MainActivity.this,"Ajouter",Toast.LENGTH_LONG).show();
                    return true;
                }
                return false;
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mon_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.itemDoc)
        {
            Toast.makeText(this,"sayer",Toast.LENGTH_LONG).show();
            return true;
        }
        else if (item.getItemId() == R.id.itemSearch) {
            Toast.makeText(this,"good",Toast.LENGTH_LONG).show();
            return true;
        }
        else
            return super.onOptionsItemSelected(item);



    }




}
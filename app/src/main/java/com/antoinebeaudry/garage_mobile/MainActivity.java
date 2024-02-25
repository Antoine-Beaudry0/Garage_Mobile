package com.antoinebeaudry.garage_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;

//import retrofit2.Call;


public class MainActivity extends AppCompatActivity {


    Button btnNotif;
    Button btnConnexion;
    Context context;


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
                Intent intent = new Intent(v.getContext(), Inscription.class);
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

   public void gestionClick(View v)
    {
        //getUtilisateur();
        //getUtilisateurByid();
        //ajouterutilisateur();
        //etListUtilisateursBiss();
    }

   /* public void ajouterutilisateur() {
        if (tb.getText().toString().trim().isEmpty() || tbPrenom.getText().toString().trim().isEmpty())
        {
            Toast.makeText(MainActivity.this, "UNE ERREUR", Toast.LENGTH_LONG).show();
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
                    Toast.makeText(MainActivity.this, "UNE ERREUR", Toast.LENGTH_LONG).show();
                }
            });
        }
    }*/

    /*public void getUtilisateur()
    {
        InterfaceServeur serveur = RetrofitInstance.getInstance().create(InterfaceServeur.class);

        Call<List<Utilisateur>> call = serveur.getListeUtilisateurs();

        call.enqueue(new Callback<List<Utilisateur>>() {
            RecyclerView rvUtilisateurs;
            AdapterUtilisateurs adapter;
            @Override
            public void onResponse(Call<List<Utilisateur>> call, Response<List<Utilisateur>> response) {
                List<Utilisateur> liste2 = response.body();
                adapter = new AdapterUtilisateurs(liste2);
                rvUtilisateurs.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Utilisateur>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"UNE ERREUR",Toast.LENGTH_LONG).show();
            }
        });
    }


    public void getUtilisateurByid()
    {
        InterfaceServeur serveur = RetrofitInstance.getInstance().create(InterfaceServeur.class);

        Call<Utilisateur> call = serveur.getUtilisateurByid(1);

        call.enqueue(new Callback<Utilisateur>() {
            @Override
            public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {
                Utilisateur utilisateur = response.body();

               // tvtexte.setText(utilisateur.getNom() + " " + utilisateur.getPrenom());
            }

            @Override
            public void onFailure(Call<Utilisateur> call, Throwable t) {
                Toast.makeText(MainActivity.this,"UNE ERREUR",Toast.LENGTH_LONG).show();

            }
        });



    }
    public void getListUtilisateursBiss() {
        InterfaceServeur serveur = RetrofitInstance.getInstance().create(InterfaceServeur.class);
        Call<ResponseBody> call = serveur.getListeUtilisateursBiss();

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody reponse = response.body();

                try {
                    String texte = reponse.string();
                    //  tvtexte.setText(texte);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });*/
    }




//}
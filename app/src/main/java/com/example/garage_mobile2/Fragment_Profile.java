package com.example.garage_mobile2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.content.Intent;
import android.widget.Toast;

import Classes.AdapterListeUser;
import Classes.InterfaceServeur;
import Classes.LoginResponse;
import Classes.ReponseServeur;
import Classes.RetrofitInstance;
import Classes.Users;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_Profile extends Fragment {

    TextView tvNom;
    TextView tvPrenom;
    TextView  tvEmail;
    TextView tvAFF;


    public Fragment_Profile() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.layout_fragment__profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        String prenom = sharedPreferences.getString("prenom", null);
        String nom = sharedPreferences.getString("nom", null);
        String email = sharedPreferences.getString("email", null);

        tvAFF = view.findViewById(R.id.profil);

        Toolbar toolbar = view.findViewById(R.id.toolbar);

        toolbar.inflateMenu(R.menu.mon_menu);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.itemdec)
                {
                    Toast.makeText(getContext(), "Déconnexion Réussi", Toast.LENGTH_SHORT).show();

                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    String token = sharedPreferences.getString("token", "");
                    String authToken = "Bearer " + token; // Formatage du token
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.clear();
                    editor.apply();

                    //InterfaceServeur interfaceServer = RetrofitInstance.getInstance().create(InterfaceServeur.class);
                   // Call<ReponseServeur> call = interfaceServer.logout(authToken); // Utilisation du token d'authentification
/*                    call.enqueue(new Callback<ReponseServeur>() {

                        @Override
                        public void onResponse(Call<ReponseServeur> call, Response<ReponseServeur> response) {
                            if (response.isSuccessful()) {
//


                            }
                            else {
                                Toast.makeText(getContext(), "Failed to logout", Toast.LENGTH_SHORT).show();
                            }
                        }*/
                       /* @Override
                        public void onFailure(Call<ReponseServeur> call, Throwable t) {
                            Toast.makeText(getContext(), "Opération échoue -404", Toast.LENGTH_SHORT).show();
                        }

                    });*/
                    NavController navController = Navigation.findNavController(requireActivity(), R.id.fragmentContainerView);
                    navController.navigate(R.id.fragMenuTofragCon);
                }

                return false;
            }
        });

        tvNom = view.findViewById(R.id.idNom);
        tvPrenom = view.findViewById(R.id.idPrenom);
        tvEmail = view.findViewById(R.id.idEmail2);

        tvNom.setText(nom);
        tvPrenom.setText(prenom);
        tvEmail.setText(email);
        tvAFF.setText("Bienvenue" + " " + prenom);





    }

}
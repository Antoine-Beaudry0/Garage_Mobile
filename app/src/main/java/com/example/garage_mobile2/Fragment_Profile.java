package com.example.garage_mobile2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.content.Intent;

import Classes.AdapterListeUser;
import Classes.Users;


public class Fragment_Profile extends Fragment {

    TextView tvNom;
    TextView tvPrenom;
    TextView tvPhone;
    TextView  tvEmail;

    TextView tvAdresse;



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

        // Obtenir une référence aux préférences partagées

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        // Lire les valeurs à partir des préférences partagées
        String valeur1 = sharedPreferences.getString("prenom",null);
        String valeur2 = sharedPreferences.getString("nom",null);


        // Utiliser les valeurs lues comme nécessaire
        Log.d("Valeur 1:", valeur1);
        Log.d("Valeur 2:", (valeur2));


        tvNom = view.findViewById(R.id.idNom);
        tvPrenom = view.findViewById(R.id.idPrenom);
        tvPhone = view.findViewById(R.id.idPhone);
        tvEmail = view.findViewById(R.id.idEmail2);
        tvAdresse = view.findViewById(R.id.idAddresse);



    }

}
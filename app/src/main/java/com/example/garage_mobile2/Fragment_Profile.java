package com.example.garage_mobile2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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

        tvNom = view.findViewById(R.id.idNom);
        tvPrenom = view.findViewById(R.id.idPrenom);
        tvPhone = view.findViewById(R.id.idPhone);
        tvEmail = view.findViewById(R.id.idEmail2);
        tvAdresse = view.findViewById(R.id.idAddresse);


      //Intent intent = getIntent();
     /*   String nom = intent.getStringExtra("nom");
        String prenom = intent.getStringExtra("prenom");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");
        String adress = intent.getStringExtra("adress");
*/

       /* tvNom.setText(nom);
        tvPrenom.setText(prenom);
        tvEmail.setText(email);
        tvPhone.setText(phone);
        tvAdresse.setText(adress);
*/


    }

}
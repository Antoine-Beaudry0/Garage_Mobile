package com.example.garage_mobile2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import Classes.AdapterListeRendezVous;
import Classes.InterfaceServeur;
import Classes.LoginResponse;
import Classes.Rendez_Vous;
import Classes.ReponseServeur;
import Classes.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class fragmentConexion extends Fragment {


    public fragmentConexion() {
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
        return inflater.inflate(R.layout.layout_fragment_conexion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Button btConnexion  =view.findViewById(R.id.btConnexion) ;



        TextView etemail = view.findViewById(R.id.idEmail);
        TextView etpassword = view.findViewById(R.id.idpassword);

        String Email = etemail.getText().toString();
        String Password = etpassword.getText().toString();




        btConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


              InterfaceServeur serveur = RetrofitInstance.getInstance().create(InterfaceServeur.class);

                Call<ReponseServeur> call = serveur.login( "alexandre.bernard@example.com", "password");
                call.enqueue(new Callback<ReponseServeur>() {
                    @Override
                    public void onResponse(Call<ReponseServeur> call, Response<ReponseServeur> response) {
                        ReponseServeur loginResponse = response.body();
                        if (response.isSuccessful()) {
                            //SharedPreferences sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                            NavController controller = Navigation.findNavController(view);
                            controller.navigate(R.id.fragConToFragMenu);
                            Toast.makeText(getContext(), "réussi", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getContext(), "Une erreur s'est produite", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ReponseServeur> call, Throwable t) {
                        Log.d("TEST-CONNEXION", t.getMessage());
                        Toast.makeText(getContext(), "Une erreur s'est produite", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        })
        ;

    }
}
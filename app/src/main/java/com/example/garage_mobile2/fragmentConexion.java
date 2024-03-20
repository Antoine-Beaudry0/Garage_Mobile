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
import Classes.Users;
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



        btConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String Email = etemail.getText().toString();
                String Password = etpassword.getText().toString();

                // Valider que les champs email et mot de passe ne sont pas vides
                if (Email.isEmpty()) {
                    etemail.setError("Veuillez entrer votre adresse email");
                    etemail.requestFocus();
                    return;
                }

                if (Password.isEmpty()) {
                    etpassword.setError("Veuillez entrer votre mot de passe");
                    etpassword.requestFocus();
                    return;
                }


              InterfaceServeur serveur = RetrofitInstance.getInstance().create(InterfaceServeur.class);

                Call<LoginResponse> call = serveur.login(Email , Password);
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        LoginResponse loginResponse = response.body();

                        if (response.isSuccessful()) {

                            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("token", response.body().getToken());
                            Users user = response.body().getUser();
                            editor.putInt("id", user.getId());
                            editor.putString("prenom", user.getPrenom());
                            editor.putString("nom", user.getNom());
                            Toast.makeText(getContext(), user.getPrenom(), Toast.LENGTH_SHORT).show();
                            editor.putString("email", user.getEmail());
                            editor.apply();
                            Toast.makeText(getContext(), "Bienvenue", Toast.LENGTH_SHORT).show();
                            //Toast.makeText(getContext(), user.getNom(), Toast.LENGTH_SHORT).show();
                            NavController controller = Navigation.findNavController(view);
                            controller.navigate(R.id.fragConToFragMenu);

                       } else {
                            Toast.makeText(getContext(), "Email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Log.d("TEST-CONNEXION", t.getMessage());
                        Toast.makeText(getContext(), "Email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();


                    }
                });
            }
        })
        ;

    }
}
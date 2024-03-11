package com.example.garage_mobile2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Fragment_menu extends Fragment {



    public Fragment_menu() {
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
        View v = inflater.inflate(R.layout.layout_fragment_menu, container, false);

        BottomNavigationView bottomNav = v.findViewById(R.id.bottomNav);

        NavHostFragment host =(NavHostFragment)getChildFragmentManager().findFragmentById(R.id.fragmentContainerViewMenu);
        NavController navController = host.getNavController();

        NavigationUI.setupWithNavController(bottomNav,navController);



        return v;
    }
}
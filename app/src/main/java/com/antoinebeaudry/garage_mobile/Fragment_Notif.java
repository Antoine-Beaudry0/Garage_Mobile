package com.antoinebeaudry.garage_mobile;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Fragment_Notif extends Fragment {

 public interface InterfaceFNotif{
     public void changerVisibilite();
 }

    public InterfaceFNotif interfaceFNotif;

    public Fragment_Notif() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        interfaceFNotif = (InterfaceFNotif) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        interfaceFNotif.changerVisibilite();
        return inflater.inflate(R.layout.fragment__gestionrendezvous, container, false);
    }
}
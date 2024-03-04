package com.antoinebeaudry.garage_mobile.classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.antoinebeaudry.garage_mobile.R;

import java.util.List;



public class AdapterRendezvous extends RecyclerView.Adapter {

    List<Rendezvous>liste;

    public AdapterRendezvous(List<Rendezvous> liste ){this.liste = liste;}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_rendezvous,parent,false);
        return new ViewHolderRendezvous(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolderRendezvous viewHolderRendezvous = (ViewHolderRendezvous)  holder;


        //viewHolderUltilisateurs.tvNomUtilisateur.setText(liste.get(position).getNom());
    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    public class ViewHolderRendezvous extends RecyclerView.ViewHolder
    {

       // TextView tvNomUtilisateur;


        public ViewHolderRendezvous(@NonNull View itemView) {
            super(itemView);
           // tvNomUtilisateur = itemView.findViewById(R.id.tvNomUtilisateur);
        }
    }


}

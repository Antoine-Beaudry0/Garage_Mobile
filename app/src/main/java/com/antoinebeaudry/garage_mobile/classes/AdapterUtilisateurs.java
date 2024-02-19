package com.antoinebeaudry.garage_mobile.classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.antoinebeaudry.garage_mobile.R;

import java.util.List;

public class AdapterUtilisateurs extends RecyclerView.Adapter {

    List<Utilisateur> liste;

    public  AdapterUtilisateurs(List<Utilisateur> liste)
    {
        this.liste = liste;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_carte,parent,false);
        return new ViewHolderUltilisateurs(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderUltilisateurs viewHolderUltilisateurs = (ViewHolderUltilisateurs)  holder;


        viewHolderUltilisateurs.tvNomUtilisateur.setText(liste.get(position).getNom());
    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    public class ViewHolderUltilisateurs extends RecyclerView.ViewHolder
    {

        TextView tvNomUtilisateur;


        public ViewHolderUltilisateurs(@NonNull View itemView) {
            super(itemView);
            tvNomUtilisateur = itemView.findViewById(R.id.tvNomUtilisateur);
        }
    }
}

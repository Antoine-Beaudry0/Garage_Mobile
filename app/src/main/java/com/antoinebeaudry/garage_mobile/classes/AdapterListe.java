package com.antoinebeaudry.garage_mobile.classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.antoinebeaudry.garage_mobile.R;

import java.util.List;

public class AdapterListe  extends RecyclerView.Adapter{

    List<Cnotif> liste;
    interfaceNotification interfaceNotification;


    public interface  interfaceNotification
    {
        public void gestionClick(int position , Notifications notification);
    }

    public AdapterListe(List<Cnotif> liste, interfaceNotification  interfaceNotification)
    {
        this.liste = liste;
        this.interfaceNotification = interfaceNotification;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.notif,parent,false);
        return new MonViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MonViewHolder monViewHolder = (MonViewHolder) holder;
        monViewHolder.tvnom.setText(liste.get(position).getNom());
        monViewHolder.tvDate.setText(liste.get(position).getDate());
        monViewHolder.tvDateHeurDeb.setText(liste.get(position).getHeureDeb());
        monViewHolder.tvDateHeurFin.setText(liste.get(position).getHeureFin());

    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    public class MonViewHolder extends RecyclerView.ViewHolder {

        TextView tvnom, tvDate, tvDateHeurDeb, tvDateHeurFin;



        public MonViewHolder(@NonNull View itemView) {
            super(itemView);

            tvnom = itemView.findViewById(R.id.tvNom);
            tvDate= itemView.findViewById(R.id.tvDate);
            tvDateHeurDeb = itemView.findViewById(R.id.tvDateDeb);
            tvDateHeurFin = itemView.findViewById(R.id.tvDateF);


        }
    }
}

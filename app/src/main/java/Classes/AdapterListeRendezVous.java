package Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.garage_mobile2.R;
import com.google.gson.JsonObject;

import java.util.List;

public class AdapterListeRendezVous extends RecyclerView.Adapter {

     List<Rendez_Vous> rendezVousList;
     Context context;

    public AdapterListeRendezVous(List<Rendez_Vous> rendezVousList) {
        this.rendezVousList = rendezVousList;
    }

    public AdapterListeRendezVous(List<Rendez_Vous> rendezVousList, Context context) {
        this.rendezVousList = rendezVousList;
        this.context = context;
    }



    @NonNull
    @Override
    public RendezVousViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_carte_rendez_vous, parent, false);
        return new RendezVousViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RendezVousViewHolder rendezVousViewHolder = (RendezVousViewHolder) holder;

        rendezVousViewHolder.tvDateHeureDebut.setText(rendezVousList.get(position).getDateHeureDebut());
        rendezVousViewHolder.tvDateHeureFin.setText(rendezVousList.get(position).getDateHeureFin());
        rendezVousViewHolder.tvIdStatut.setText(rendezVousList.get(position).getId_Statut()+"");
        rendezVousViewHolder.tvCommentaire.setText(rendezVousList.get(position).getCommentaire());
        rendezVousViewHolder.tvIdVoiture.setText(rendezVousList.get(position).getId_Voiture()+"");
        rendezVousViewHolder.tvNotificationEnvoye.setText(String.valueOf(rendezVousList.get(position).isNotificationEnvoye()));

        List<Servic_Rendezvous> serviceList = rendezVousList.get(position).getServices();
        if (serviceList != null && !serviceList.isEmpty()) {
            AdapterListeServiceRendezvous serviceAdapter = new AdapterListeServiceRendezvous(serviceList);
            rendezVousViewHolder.recyclerViewServices.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false));
            rendezVousViewHolder.recyclerViewServices.setAdapter(serviceAdapter);
        }

    }


    @Override
    public int getItemCount() {
        return rendezVousList.size();
    }

    public class RendezVousViewHolder extends RecyclerView.ViewHolder {

        TextView tvDateHeureDebut;
        TextView tvDateHeureFin;
        TextView tvCommentaire;
        TextView tvNotificationEnvoye;
        TextView tvIdVoiture;
        TextView tvIdStatut;
        RecyclerView recyclerViewServices;

        public RendezVousViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDateHeureDebut = itemView.findViewById(R.id.textViewDateHeureDebut);
            tvDateHeureFin = itemView.findViewById(R.id.textViewDateHeureFin);
            tvCommentaire = itemView.findViewById(R.id.textViewCommentaire);
            tvNotificationEnvoye = itemView.findViewById(R.id.textViewNotificationEnvoye);
            tvIdVoiture = itemView.findViewById(R.id.textViewIdVoiture);
            tvIdStatut = itemView.findViewById(R.id.textViewIdStatut);

            recyclerViewServices = itemView.findViewById(R.id.rvServices);

        }
    }
}

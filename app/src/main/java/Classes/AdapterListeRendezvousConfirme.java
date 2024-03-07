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

import java.util.List;

public class AdapterListeRendezvousConfirme extends RecyclerView.Adapter {

    List<Rendez_Vous> rendezVousListConfirme;
    Context context;

    public AdapterListeRendezvousConfirme(List<Rendez_Vous> rendezVousList) {
        this.rendezVousListConfirme = rendezVousList;
    }

    public AdapterListeRendezvousConfirme(List<Rendez_Vous> rendezVousList, Context context) {
        this.rendezVousListConfirme = rendezVousList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_carte_rendez_vous, parent, false);
        return new RendezVousViewHolderConfirme(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        AdapterListeRendezVous.RendezVousViewHolder rendezVousViewHolder = (AdapterListeRendezVous.RendezVousViewHolder) holder;

        rendezVousViewHolder.tvDateHeureDebut.setText(rendezVousListConfirme.get(position).getDateHeureDebut());
        rendezVousViewHolder.tvDateHeureFin.setText(rendezVousListConfirme.get(position).getDateHeureFin());
        rendezVousViewHolder.tvIdStatut.setText(rendezVousListConfirme.get(position).getId_Statut()+"");
        rendezVousViewHolder.tvCommentaire.setText(rendezVousListConfirme.get(position).getCommentaire());
        rendezVousViewHolder.tvIdVoiture.setText(rendezVousListConfirme.get(position).getId_Voiture()+"");
        rendezVousViewHolder.tvNotificationEnvoye.setText(String.valueOf(rendezVousListConfirme.get(position).isNotificationEnvoye()));

        List<Servic_Rendezvous> serviceList = rendezVousListConfirme.get(position).getServices();
        if (serviceList != null && !serviceList.isEmpty()) {
            AdapterListeServiceRendezvous serviceAdapter = new AdapterListeServiceRendezvous(serviceList);
            rendezVousViewHolder.recyclerViewServices.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false));
            rendezVousViewHolder.recyclerViewServices.setAdapter(serviceAdapter);
        }

    }

    @Override
    public int getItemCount() {
        return rendezVousListConfirme.size();
    }

    public class RendezVousViewHolderConfirme extends RecyclerView.ViewHolder {

        TextView tvDateHeureDebut;
        TextView tvDateHeureFin;
        TextView tvCommentaire;
        TextView tvNotificationEnvoye;
        TextView tvIdVoiture;
        TextView tvIdStatut;
        RecyclerView recyclerViewServices;

        public RendezVousViewHolderConfirme(@NonNull View itemView) {
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

package Classes;

import android.app.Service;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.garage_mobile2.R;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.garage_mobile2.R;
import com.google.gson.Gson;

import java.util.List;

public class AdapterListeServiceRendezvous extends RecyclerView.Adapter {

    private List<Servic_Rendezvous> serviceJsonList;

    public AdapterListeServiceRendezvous(List<Servic_Rendezvous> serviceJsonList) {
        this.serviceJsonList = serviceJsonList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_carte_rendezvous_service,parent,false);
        return new ServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AdapterListeServiceRendezvous.ServiceViewHolder serviceViewHolder = (AdapterListeServiceRendezvous.ServiceViewHolder) holder;


        serviceViewHolder.tvTitreService.setText("Prix: " + serviceJsonList.get(position).getTitre());
        serviceViewHolder.tvPrestation.setText("Prestation: " + serviceJsonList.get(position).getId_prestation_String());
        serviceViewHolder.tvtype.setText("Type: " + serviceJsonList.get(position).getType());
        serviceViewHolder.tvposition.setText("Position: " + serviceJsonList.get(position).getPosition_String());
        serviceViewHolder.tvTempsService.setText("Temps du service: " + serviceJsonList.get(position).getTemps());
        serviceViewHolder.tvPrixService.setText("Prix du service: " + serviceJsonList.get(position).getPrixString());
        //serviceViewHolder.tvChosen.setText(String.valueOf(serviceJsonList.get(position).isChosen()));


    }


    @Override
    public int getItemCount() {
        return serviceJsonList.size();
    }




        public class ServiceViewHolder extends RecyclerView.ViewHolder {

            TextView tvTitreService;
            TextView tvPrixService;
            TextView tvTempsService;
            TextView tvChosen;
            TextView tvposition;
            TextView tvPrestation;

            TextView tvtype;

            public ServiceViewHolder(@NonNull View itemView) {
                super(itemView);
                tvTitreService = itemView.findViewById(R.id.idtitre);
                tvPrixService = itemView.findViewById(R.id.idprix);
                tvTempsService = itemView.findViewById(R.id.idtemp);
                tvChosen = itemView.findViewById(R.id.idchosen);
                tvposition = itemView.findViewById(R.id.idposition);
                tvtype = itemView.findViewById(R.id.idtype);
                tvPrestation = itemView.findViewById(R.id.idprestation);
            }
        }
}

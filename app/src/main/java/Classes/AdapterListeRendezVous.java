package Classes;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.garage_mobile2.R;
import com.google.gson.JsonObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterListeRendezVous extends RecyclerView.Adapter {

     List<Rendez_Vous> rendezVousList;
     Context context;


     boolean hideButtons = false;
    boolean hideBut = false;

    boolean hidebutt = false;



    public AdapterListeRendezVous(List<Rendez_Vous> rendezVousList) {
        this.rendezVousList = rendezVousList;
    }

    public AdapterListeRendezVous(List<Rendez_Vous> rendezVousList, Context context) {
        this.rendezVousList = rendezVousList;
        this.context = context;
    }

    public void setHideButtons(boolean hide)
    {
        hideButtons = hide;
    }
    public void setHideB(boolean hide)
    {
        hideBut = hide;
    }

    public void setHide(boolean hide)
    {
        hidebutt = hide;
    }




    public void suprimerRDV(int position)
    {
        rendezVousList.remove(position);
        notifyItemRemoved(position);
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

        Rendez_Vous rendezVous = rendezVousList.get(position);
        VoitureDetails voitureDetails = rendezVous.getVoitureDetails();

        rendezVousViewHolder.tvDateHeureDebut.setText(formatDate(rendezVousList.get(position).getDateHeureDebut()));
        rendezVousViewHolder.tvDateHeureFin.setText(formatDate(rendezVousList.get(position).getDateHeureFin()));
        rendezVousViewHolder.tvTel.setText(rendezVousList.get(position).getTel());
        rendezVousViewHolder.tvmarque.setText(voitureDetails.getMarque());
       rendezVousViewHolder.tvmodele.setText(voitureDetails.getModele());
        rendezVousViewHolder.tvId.setText(rendezVousList.get(position).getId());



        List<Servic_Rendezvous> serviceList = rendezVousList.get(position).getServices();
        if (serviceList != null && !serviceList.isEmpty()) {
            AdapterListeServiceRendezvous serviceAdapter = new AdapterListeServiceRendezvous(serviceList);
            rendezVousViewHolder.recyclerViewServices.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false));
            rendezVousViewHolder.recyclerViewServices.setAdapter(serviceAdapter);
        }

        if(hideButtons == true)
        {
            rendezVousViewHolder.btTermine.setVisibility(View.GONE);
            rendezVousViewHolder.btBientot.setVisibility(View.GONE);
            rendezVousViewHolder.btAppeler.setVisibility(View.GONE);
        }

        if(hideBut == true)
        {
            rendezVousViewHolder.btdelete.setVisibility(View.GONE);

        }

        if(hidebutt == true)
        {
            rendezVousViewHolder.btdelete.setVisibility(View.GONE);
            rendezVousViewHolder.btTermine.setVisibility(View.GONE);
            rendezVousViewHolder.btBientot.setVisibility(View.GONE);

        }


    }


    @Override
    public int getItemCount() {
        return rendezVousList.size();
    }

    public class RendezVousViewHolder extends RecyclerView.ViewHolder {
        int id;
        TextView tvDateHeureDebut ,tvId;
        TextView tvDateHeureFin;
        TextView tvmodele;
        TextView tvmarque , tvTel;
        RecyclerView recyclerViewServices;

        Button btdelete;

        Button btAppeler, btTermine, btBientot ;

        public RendezVousViewHolder(@NonNull View itemView) {
            super(itemView);


            tvDateHeureDebut = itemView.findViewById(R.id.textViewDateHeureDebut);
            tvDateHeureFin = itemView.findViewById(R.id.textViewDateHeureFin);
            tvmodele = itemView.findViewById(R.id.tvmodele);
            tvmarque = itemView.findViewById(R.id.tvmarque);
            tvTel = itemView.findViewById(R.id.tvtel);
            btdelete = itemView.findViewById(R.id.btndeleteRDV);
            tvId = itemView.findViewById(R.id.idRDV);
            btAppeler = itemView.findViewById(R.id.btnappellerClient);
            btTermine = itemView.findViewById(R.id.btnRendezVousTermine);
            btBientot = itemView.findViewById(R.id.btnRDVbientotTermine);

            recyclerViewServices = itemView.findViewById(R.id.rvServices);


            btdelete.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    suprimerRDV(getLayoutPosition());
                    Toast.makeText(itemView.getContext(),"Suppression de RendezVous", Toast.LENGTH_LONG).show();
                    return false;
                }
            });

            btBientot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            btAppeler.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String phone = tvTel.getText().toString(); // Utilisez getText() pour obtenir le texte de la TextView
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                    context.startActivity(intent); // Utilisez context.startActivity() au lieu de startActivity()
                }
            });

            btTermine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String idRendezVous = tvId.getText().toString();
                    int pos = getLayoutPosition();

                    InterfaceServeur serveur = RetrofitInstance.getInstance().create(InterfaceServeur.class);

                    Call<ReponseServeur> call = serveur.termine(idRendezVous);
                    call.enqueue(new Callback<ReponseServeur>() {
                        @Override
                        public void onResponse(Call<ReponseServeur> call, Response<ReponseServeur> response) {
                            if (response.isSuccessful()) {
                                Rendez_Vous rendezVous = response.body().getSingledata();
                                rendezVousList.set(pos, rendezVous);
                                notifyDataSetChanged();

                            } else {
                                Toast.makeText(itemView.getContext(), "Une erreur s'est produite", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ReponseServeur> call, Throwable t) {
                            Log.d("TEST-CONNEXION", t.getMessage());
                            try {
                                Toast.makeText(itemView.getContext(), "Une erreur s'est produite", Toast.LENGTH_SHORT).show();
                            }
                            catch (Exception exc)
                            {
                            }

                        }
                    });




                }
            });

        }




    }

    private String formatDate(String dateTime) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // Le format de date souhaité
            Date date = inputFormat.parse(dateTime);
            return outputFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "Format de date incorrect"; // Message en cas d'erreur de formatage de date
        }
    }
}

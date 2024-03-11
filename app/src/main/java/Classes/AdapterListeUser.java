package Classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.garage_mobile2.R;

import java.util.List;

public class AdapterListeUser extends RecyclerView.Adapter {

    interfaceUser interfaceUser;

    List<Users> liste;

    public interface  interfaceUser
    {
        public void gestionClick(int position , Users user);


    }

    public AdapterListeUser(List<Users> liste, interfaceUser  interfaceUser)
    {
        this.liste = liste;
        this.interfaceUser = interfaceUser;
    }

    public void ajouterUsers(Users user)
    {
        liste.add(user);
        notifyItemInserted(liste.size() -1);
    }
    public void suprimerUsers(int position)
    {
        liste.remove(position);
        notifyItemRemoved(position);
    }

    public void modifierUsers(int position , Users user)
    {
        liste.set(position, user);
        notifyItemChanged(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_fragment__profile,parent,false);
        return new MonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return liste.size();
    }

    public class MonViewHolder extends RecyclerView.ViewHolder {

        TextView tvnom, tvPrenom, tvCourriel , tvPhone;
       Button btndelete ,btnmodif;


        public MonViewHolder(@NonNull View itemView) {
            super(itemView);

            tvnom = itemView.findViewById(R.id.idNom);
            tvPrenom = itemView.findViewById(R.id.idPrenom);
            tvCourriel = itemView.findViewById(R.id.idEmail2);
            tvPhone = itemView.findViewById(R.id.idPhone);
            btnmodif = itemView.findViewById(R.id.btnModifier);
            btndelete = itemView.findViewById(R.id.btndelete);


       /*
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    interfaceParticipant.gestionClick(getLayoutPosition(), liste.get(getLayoutPosition()));

                }
            });*/
/*
            btndetail.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    interfaceUser.gestionClick(getLayoutPosition(), liste.get(getLayoutPosition()));
                    return false;
                }
            });*/

            btndelete.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    suprimerUsers(getLayoutPosition());
                    Toast.makeText(itemView.getContext(),"Suppression de Profile", Toast.LENGTH_LONG).show();
                    return false;
                }
            });



        }
    }
}

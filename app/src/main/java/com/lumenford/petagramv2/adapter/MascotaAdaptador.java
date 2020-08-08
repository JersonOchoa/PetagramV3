package com.lumenford.petagramv2.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lumenford.petagramv2.Mascota;
import com.lumenford.petagramv2.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, final int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.txtNombreCV.setText(mascota.getNombre());
        holder.txtLikesCV.setText(String.valueOf(mascota.getLikes()));

        holder.btnLike.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                int auxLikes = mascota.getLikes();
                auxLikes++;
                mascota.setLikes(auxLikes);
                holder.txtLikesCV.setText(String.valueOf(mascota.getLikes()));

            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imgFoto;
        private ImageButton btnLike;
        private TextView txtNombreCV;
        private TextView txtLikesCV;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            txtNombreCV = (TextView) itemView.findViewById(R.id.txtNombreCV);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            txtLikesCV = (TextView) itemView.findViewById(R.id.txtLikesCV);
        }
    }

}

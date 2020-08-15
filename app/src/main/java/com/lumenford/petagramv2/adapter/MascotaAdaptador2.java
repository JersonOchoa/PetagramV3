package com.lumenford.petagramv2.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lumenford.petagramv2.pojo.Mascota;
import com.lumenford.petagramv2.R;

import java.util.ArrayList;

public class MascotaAdaptador2 extends RecyclerView.Adapter<MascotaAdaptador2.MascotaViewHolder>  {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador2(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas2, parent, false);
        return new MascotaAdaptador2.MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.txtLikesCV.setText(String.valueOf(mascota.getLikes()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imgFoto;
        private TextView txtLikesCV;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto2);
            txtLikesCV = (TextView) itemView.findViewById(R.id.txtLikesCV2);
        }
    }
}

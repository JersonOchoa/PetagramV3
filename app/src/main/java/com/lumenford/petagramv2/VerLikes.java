package com.lumenford.petagramv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.lumenford.petagramv2.adapter.MascotaAdaptador;

import java.util.ArrayList;

public class VerLikes extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_likes);
        
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas2);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        InicializarMascotas();
        InicializarAdaptador();
    }

    public MascotaAdaptador adaptador;
    public void InicializarAdaptador()
    {
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void InicializarMascotas()
    {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Caballo", 10, R.drawable.caballo));
        mascotas.add(new Mascota("Cabra", 9, R.drawable.cabra));
        mascotas.add(new Mascota("Cerdo", 8, R.drawable.cerdo));
        mascotas.add(new Mascota("Gallo", 7, R.drawable.gallo));
        mascotas.add(new Mascota("Mono", 6, R.drawable.mono));
    }

}
package com.lumenford.petagramv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.lumenford.petagramv2.adapter.MascotaAdaptador;
import com.lumenford.petagramv2.pojo.Mascota;
import com.lumenford.petagramv2.presentador.IVerLikesPresenter;
import com.lumenford.petagramv2.presentador.VerLikesPresenter;

import java.util.ArrayList;

public class VerLikes extends AppCompatActivity implements iVerLikes {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IVerLikesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_likes);
        
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas2);

        presenter = new VerLikesPresenter(this,this);
    }

    @Override
    public void GenerarLLM() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, VerLikes.this);
        return adaptador;
    }

    @Override
    public void InicializarAdaptadorLikes(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
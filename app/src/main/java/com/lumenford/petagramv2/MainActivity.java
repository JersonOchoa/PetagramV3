package com.lumenford.petagramv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

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
        mascotas.add(new Mascota("Perro", 5, R.drawable.perro));
        mascotas.add(new Mascota("Serpiente", 4, R.drawable.serpiente));
        mascotas.add(new Mascota("Tigre", 3, R.drawable.tigre));

    }

    public void VerLikes(View v)
    {
        Intent intent = new Intent(MainActivity.this, VerLikes.class);
        startActivity(intent);
    }
}
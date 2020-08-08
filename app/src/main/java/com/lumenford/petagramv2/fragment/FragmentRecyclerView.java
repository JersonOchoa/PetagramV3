package com.lumenford.petagramv2.fragment;

import android.os.Bundle;
import android.telephony.RadioAccessSpecifier;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lumenford.petagramv2.Mascota;
import com.lumenford.petagramv2.R;
import com.lumenford.petagramv2.adapter.MascotaAdaptador;

import java.util.ArrayList;

public class FragmentRecyclerView extends Fragment {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        InicializarMascotas();
        InicializarAdaptador();
        return v;
    }

    public MascotaAdaptador adaptador;
    public void InicializarAdaptador()
    {
        adaptador = new MascotaAdaptador(mascotas, getActivity());
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

}

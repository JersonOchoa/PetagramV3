package com.lumenford.petagramv2.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lumenford.petagramv2.Mascota;
import com.lumenford.petagramv2.R;
import com.lumenford.petagramv2.adapter.MascotaAdaptador;
import com.lumenford.petagramv2.adapter.MascotaAdaptador2;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public PerfilFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_perfil, container, false);
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        CircularImageView circularImageView = v.findViewById(R.id.circularImgPerfil);
        // Set Color
        circularImageView.setCircleColor(Color.WHITE);
        // or with gradient
        circularImageView.setCircleColorStart(Color.BLACK);
        circularImageView.setCircleColorEnd(Color.RED);
        circularImageView.setCircleColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);

        // Set Border
        circularImageView.setBorderWidth(10f);
        circularImageView.setBorderColor(Color.BLACK);
        // or with gradient
        circularImageView.setBorderColorStart(Color.BLACK);
        circularImageView.setBorderColorEnd(Color.RED);
        circularImageView.setBorderColorDirection(CircularImageView.GradientDirection.TOP_TO_BOTTOM);

        // Add Shadow with default param
        circularImageView.setShadowEnable(true);
        // or with custom param
        circularImageView.setShadowRadius(7f);
        circularImageView.setShadowColor(Color.RED);
        circularImageView.setShadowGravity(CircularImageView.ShadowGravity.CENTER);


        listaMascotas = (RecyclerView) v.findViewById(R.id.rvPerfil);


        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(glm);
        InicializarMascotas();
        InicializarAdaptador();

        return v;
    }

    public MascotaAdaptador2 adaptador;
    public void InicializarAdaptador()
    {
        adaptador = new MascotaAdaptador2(mascotas, getActivity());
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

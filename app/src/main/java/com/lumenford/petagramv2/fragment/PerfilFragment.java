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
import androidx.recyclerview.widget.RecyclerView;

import com.lumenford.petagramv2.adapter.MascotaAdaptador;
import com.lumenford.petagramv2.pojo.Mascota;
import com.lumenford.petagramv2.R;
import com.lumenford.petagramv2.adapter.MascotaAdaptador2;
import com.lumenford.petagramv2.presentador.IPerfilFragmentPresenter;
import com.lumenford.petagramv2.presentador.PerfilFragmentPresenter;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class PerfilFragment extends Fragment implements IPerfilFragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IPerfilFragmentPresenter presenter;
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
        presenter = new PerfilFragmentPresenter(this, getContext());
        return v;
    }

    @Override
    public void GenerarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);
        listaMascotas.setLayoutManager(glm);
    }

    @Override
    public MascotaAdaptador2 crearAdaptador2(ArrayList<Mascota> mascotas) {
        MascotaAdaptador2 adaptador = new MascotaAdaptador2(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void InicializarAdaptadorRV2(MascotaAdaptador2 adaptador2) {
        listaMascotas.setAdapter(adaptador2);
    }
}

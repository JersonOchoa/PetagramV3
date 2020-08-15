package com.lumenford.petagramv2.fragment;

import com.lumenford.petagramv2.adapter.MascotaAdaptador;
import com.lumenford.petagramv2.pojo.Mascota;

import java.util.ArrayList;

public interface IFragmentRecyclerView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void InicializarAdaptadorRV(MascotaAdaptador adaptador);
}

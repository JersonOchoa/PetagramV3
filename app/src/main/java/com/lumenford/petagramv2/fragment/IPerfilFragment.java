package com.lumenford.petagramv2.fragment;

import com.lumenford.petagramv2.adapter.MascotaAdaptador2;
import com.lumenford.petagramv2.pojo.Mascota;

import java.util.ArrayList;

public interface IPerfilFragment {

    public void GenerarGridLayout();

    public MascotaAdaptador2 crearAdaptador2(ArrayList<Mascota> mascotas);

    public void InicializarAdaptadorRV2(MascotaAdaptador2 adaptador2);

}

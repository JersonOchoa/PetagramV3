package com.lumenford.petagramv2;

import com.lumenford.petagramv2.adapter.MascotaAdaptador;
import com.lumenford.petagramv2.pojo.Mascota;

import java.util.ArrayList;

public interface iVerLikes {
    public void GenerarLLM();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void InicializarAdaptadorLikes(MascotaAdaptador adaptador);
}

package com.lumenford.petagramv2.presentador;

import android.content.Context;

import com.lumenford.petagramv2.db.ConstructorMascotas;
import com.lumenford.petagramv2.iVerLikes;
import com.lumenford.petagramv2.pojo.Mascota;

import java.util.ArrayList;

public class VerLikesPresenter implements IVerLikesPresenter {

    private iVerLikes iVerLikes;
    private Context context;
    private ArrayList<Mascota> mascotas;
    private ConstructorMascotas constructorMascotas;

    public VerLikesPresenter(iVerLikes iVerLikes, Context context) {
        this.iVerLikes = iVerLikes;
        this.context = context;
        Obtener5Mascotas();
    }

    @Override
    public void Obtener5Mascotas() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.Obtener5Mascotas();
        MostrarMascotasLikes();
    }

    @Override
    public void MostrarMascotasLikes() {
        iVerLikes.InicializarAdaptadorLikes(iVerLikes.crearAdaptador(mascotas));
        iVerLikes.GenerarLLM();
    }
}

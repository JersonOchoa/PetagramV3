package com.lumenford.petagramv2.presentador;

import android.content.Context;

import com.lumenford.petagramv2.db.ConstructorMascotas;
import com.lumenford.petagramv2.fragment.IFragmentRecyclerView;
import com.lumenford.petagramv2.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IFragmentRecyclerView iFragmentRecyclerView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter (IFragmentRecyclerView iFragmentRecyclerView, Context context){
        this.iFragmentRecyclerView = iFragmentRecyclerView;
        this.context = context;
        ObtenerMascotasBD();
    }

    @Override
    public void ObtenerMascotasBD() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.ObtenerDatos();
        MostrarMascotasRV();
    }

    @Override
    public void MostrarMascotasRV() {
        iFragmentRecyclerView.InicializarAdaptadorRV(iFragmentRecyclerView.crearAdaptador(mascotas));
        iFragmentRecyclerView.generarLinearLayoutVertical();
    }
}

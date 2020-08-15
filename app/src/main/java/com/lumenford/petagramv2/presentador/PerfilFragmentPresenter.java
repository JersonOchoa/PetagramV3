package com.lumenford.petagramv2.presentador;

import android.content.Context;

import com.lumenford.petagramv2.db.ConstructorMascotas;
import com.lumenford.petagramv2.fragment.IPerfilFragment;
import com.lumenford.petagramv2.pojo.Mascota;

import java.util.ArrayList;

public class PerfilFragmentPresenter implements IPerfilFragmentPresenter {
    private IPerfilFragment iPerfilFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public PerfilFragmentPresenter(IPerfilFragment iPerfilFragment, Context context) {
        this.iPerfilFragment = iPerfilFragment;
        this.context = context;
        ObtenerMascotasPerfil();
    }

    @Override
    public void ObtenerMascotasPerfil() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.ObtenerDatosPerfil();
        MostrarMascotasPerfilRV();
    }

    @Override
    public void MostrarMascotasPerfilRV() {
        iPerfilFragment.InicializarAdaptadorRV2(iPerfilFragment.crearAdaptador2(mascotas));
        iPerfilFragment.GenerarGridLayout();
    }
}

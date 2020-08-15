package com.lumenford.petagramv2.db;

import android.content.ContentValues;
import android.content.Context;
import android.provider.ContactsContract;

import com.lumenford.petagramv2.R;
import com.lumenford.petagramv2.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {
    private Context context;

    public ConstructorMascotas(Context context)
    {
        this.context = context;
    }

    public ArrayList<Mascota> ObtenerDatos()
    {
        BaseDatos db = new BaseDatos(context);
        InsertarMascotas(db);
        return db.obtenerMascotas();
    }

    public ArrayList<Mascota> ObtenerDatosPerfil()
    {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerMascotasPerfil();
    }

    public ArrayList<Mascota> Obtener5Mascotas()
    {
        BaseDatos db = new BaseDatos(context);
        return db.obtener5Mascotas();
    }

    public void InsertarMascotas(BaseDatos db)
    {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Bojack Horseman");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.caballo);
        db.InsertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Peppa Pig");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.cerdo);
        db.InsertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "GOAT");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.cabra);
        db.InsertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Claudio");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.gallo);
        db.InsertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Goku");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.mono);
        db.InsertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Spike");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.perro);
        db.InsertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Slytherin");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.serpiente);
        db.InsertarMascotas(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Tony");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.tigre);
        db.InsertarMascotas(contentValues);


    }

    public void DarLike(Mascota mascota)
    {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_LIKES_CONTEO, 1);
        db.InsertarLikeMascota(contentValues);
    }

    public int ObtenerLikes(Mascota mascota)
    {
        BaseDatos db = new BaseDatos(context);
        return db.ObtenerLikesMascota(mascota);
    }
}

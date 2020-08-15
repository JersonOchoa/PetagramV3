package com.lumenford.petagramv2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.lumenford.petagramv2.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String queryCrearTabla = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA +
                "(" +
                ConstantesBaseDatos.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO + " INTEGER" +
                ")";

        String queryCrearTabla2 = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES +
                "(" +
                ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTA_LIKES_CONTEO +  " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA + ") " +
                "REFERENCES " +  ConstantesBaseDatos.TABLE_MASCOTA + "(" + ConstantesBaseDatos.TABLE_MASCOTA_ID + ")" +
                ")";
        sqLiteDatabase.execSQL(queryCrearTabla);
        sqLiteDatabase.execSQL(queryCrearTabla2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTA);

        onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascota> obtenerMascotas()
    {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext())
        {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_CONTEO + ") " +
                                "FROM " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES +
                                " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA + "=" + mascotaActual.getId();
            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if(registrosLikes.moveToNext())
            {
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }
            else
            {
                mascotaActual.setLikes(0);
            }
            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public ArrayList<Mascota> obtenerMascotasPerfil()
    {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT DISTINCT(" + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA + ") FROM " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext())
        {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));

            String queryLikes = "SELECT * " +
                    "FROM " + ConstantesBaseDatos.TABLE_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_ID + "=" + registros.getInt(0);
            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if(registrosLikes.moveToNext())
            {
                mascotaActual.setNombre(registrosLikes.getString(1));
                mascotaActual.setFoto(registrosLikes.getInt(2));
                mascotaActual.setLikes(1);
                mascotas.add(mascotaActual);
            }
            else
            {
                mascotaActual.setNombre("N/A");
                mascotaActual.setFoto(1);
            }
        }
        db.close();
        return mascotas;
    }

    public ArrayList<Mascota> obtener5Mascotas()
    {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query =  "SELECT " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA + ", COUNT(" + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_CONTEO + ") AS CONTEO " +
                        "FROM " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES +
                        " GROUP BY " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA +
                        " ORDER BY CONTEO DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        Integer cont = 0;

        while (registros.moveToNext() && cont < 5)
        {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setLikes(registros.getInt(1));
            String query2 = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA +
                            " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_ID + "=" + registros.getInt(0);
            Cursor registros2 = db.rawQuery(query2, null);
            if(registros2.moveToNext())
            {
                mascotaActual.setNombre(registros2.getString(1));
                mascotaActual.setFoto(registros2.getInt(2));
                mascotas.add(mascotaActual);
            }
            cont++;
        }
        db.close();
        return mascotas;
    }

    public void InsertarMascotas(ContentValues contentValues)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void InsertarLikeMascota(ContentValues contentValues)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA_LIKES, null, contentValues);
        db.close();
    }

    public int ObtenerLikesMascota(Mascota mascota)
    {
        int likes = 0;
        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_CONTEO + ")" +
                        " FROM " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES +
                        " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA + "=" + mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while(registros.moveToNext())
        {
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }
}

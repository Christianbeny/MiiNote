package com.example.miinote;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.miinote.Modelo.Item;
import com.example.miinote.Modelo.Notas;

import java.util.ArrayList;

public class BaseDeDatos extends SQLiteOpenHelper {

    SQLiteDatabase bd;

    public BaseDeDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table notas(Idnota integer primary key autoincrement, Titulo varchar(25) not null, Descripcion text not null,nota text not null,Fecha varchar(25) not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<Item> MostrarNotas() {
        ArrayList<Item> listanota = new ArrayList<>();
        bd = this.getWritableDatabase();
        String sql = "Select * from notas order by Fecha desc, Idnota desc";
        Cursor registros = bd.rawQuery(sql, null);
        if (registros.moveToFirst()) {
            do {
                listanota.add(new Item(registros.getString(1), registros.getString(2), registros.getString(4)));
            } while (registros.moveToNext());
        }
        return listanota;
    }

    public Notas ObtenerNota(int id) {
        Notas nota = new Notas();
        bd = this.getWritableDatabase();
        String sql = "Select * from notas where ClaveNota=" + id;
        Cursor registros = bd.rawQuery(sql, null);
        if (registros.moveToFirst()) {
            do {
                nota.id = registros.getInt(0);
                nota.titulo = registros.getString(1);
                nota.descripcion = registros.getString(2);
                nota.nota = registros.getString(3);
                nota.fecha = registros.getString(4);
            } while (registros.moveToNext());
        }
        return nota;
    }
/**
 public int ObtenerClaveTarea(String titulo)
 {
 int clave=0;
 bd= this.getWritableDatabase();
 String consulta="Select ClaveTarea from tareas where titulo='"+titulo+"'";
 Cursor registros = bd.rawQuery(consulta,null);
 if(registros.moveToFirst())
 {
 clave = registros.getInt(0);
 }
 return clave;
 }
 **/
}
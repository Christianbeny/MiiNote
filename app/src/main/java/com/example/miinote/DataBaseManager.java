package com.example.miinote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseManager {
    //Nombre de la tabla
    public static final String TABLA_NAME = "notas";
    //creacion de atributos
    public static final String CN_ID = "id";
    public static final String CN_TITLE = "titulo";
    public static final String CN_DESCRIP = "descripcion";
    public static final String CN_CONTENT = "nota";
    //creacion de la tabla SQLite
    public static final String CREATE_TABLE = "create table "+ TABLA_NAME + " ("
            + CN_ID + " integer primary key AUTOINCREMENT, "
            + CN_TITLE + " text not null, "
            + CN_DESCRIP + " text not null, "
            + CN_CONTENT + " text )";

    private DbHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context context) {
        //instancia para dbhelper
        helper = new DbHelper(context,"listanotas",null,1);
        //instancia para llamar base de datos y si no existe este la crea.
        db = helper.getWritableDatabase();
    }
    //Metodo de Contenedor de Valores
    public ContentValues generarContenidoValues(String titulo, String descripcion, String nota){
        ContentValues valores = new ContentValues();
        valores.put(CN_TITLE,titulo);
        valores.put(CN_DESCRIP,descripcion);
        valores.put(CN_CONTENT,nota);

        return valores;
    }
    //Metodo de insertar
    public void insertar(String titulo, String descripcion, String nota){
        //funcion de insertar
        db.insert(TABLA_NAME,null,generarContenidoValues(titulo,descripcion,nota));
    }
    //Metodo Para Eliminar Por titulo
    public void eliminarTitulo(String titulo){
        //Funcion de Eliminar
        db.delete(TABLA_NAME,CN_TITLE+"=?",new String[]{titulo});
    }

    public Cursor cargarCursorNotas(){
        String[] columnas = new String[]{CN_ID,CN_TITLE,CN_DESCRIP,CN_CONTENT};
        return db.query(TABLA_NAME,columnas,null,null,null,null,null);
    }
}

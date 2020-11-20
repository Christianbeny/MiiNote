package com.example.miinote;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    /**
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
**/
    private static final String DATABASE_DROP = "drop table if exists " + DataBaseManager.TABLA_NAME;

    public DbHelper( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseManager.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DATABASE_DROP);
        this.onCreate(db);
    }
}
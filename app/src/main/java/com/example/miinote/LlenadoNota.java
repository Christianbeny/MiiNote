package com.example.miinote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miinote.Modelo.Notas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LlenadoNota extends AppCompatActivity {

    private EditText titulo;
    private EditText descripcion;
    private EditText nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llenado_nota);

        titulo = (EditText)findViewById(R.id.txt_Titulo);
        descripcion = (EditText)findViewById(R.id.txt_Descripcion);
        nota = (EditText)findViewById(R.id.txt_Texto);

    }
    public void Guardar(View view)
    {
        BaseDeDatos admin =new BaseDeDatos(this,"MiiNota",null,1);
        SQLiteDatabase bd= admin.getWritableDatabase();
        String titu=titulo.getText().toString();
        String desc=descripcion.getText().toString();
        String not=nota.getText().toString();
        if(!titu.isEmpty()&&!desc.isEmpty()&&!not.isEmpty())
        {
            Notas nota=new Notas();
            nota.titulo=titu;
            nota.descripcion=desc;
            nota.nota=not;
            nota.fecha=getDate();
            ContentValues registro = new ContentValues();
            registro.put("titulo",nota.titulo);
            registro.put("descripcion",nota.descripcion);
            registro.put("nota",nota.nota);
            registro.put("fecha",nota.fecha);
            bd.insert("notas",null, registro);
            bd.close();
            Toast.makeText(this, "MiiNota Guardada", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getBaseContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Toast.makeText(this, "Algun Campo Esta Vacio", Toast.LENGTH_SHORT).show();
        }
    }

    private String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
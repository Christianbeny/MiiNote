package com.example.miinote;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
//55959594

    private DataBaseManager manager;
    private Cursor cursor;
    private ListView lista;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        manager = new DataBaseManager(this);
        lista = (ListView) findViewById(R.id.ListView);

        manager.insertar("Mane","debe Feria","Me deves mucho mane hijo de la *******");
        //manager.insertar("Aplicacion","debe Feria","Me deves mucho mane hijo de la *******");
        //manager.insertar("chales","debe Feria","Me deves mucho mane hijo de la *******");


        String[] from = new String[]{ manager.CN_TITLE,manager.CN_DESCRIP,manager.CN_CONTENT};
        int[] to = new int[]{android.R.id.text1,android.R.id.text2};
        cursor = manager.cargarCursorNotas();
//Error MANE CHECALO
        adapter = new SimpleCursorAdapter(this,android.R.layout.two_line_list_item,cursor,from,to,0);
        lista.setAdapter(adapter);


        //creacion de boton flotante
        FloatingActionButton fab = findViewById(R.id.agrega);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //llamado de activity llenadoNota
                Intent miIntent = new Intent(MainActivity.this,LlenadoNota.class);
                startActivity(miIntent);
            }
        });
    }
//cambios
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/**
    public void registrar(){
        manager = new DbHelper(this,"listanotas",null,1);
        SQLiteDatabase admin = manager.getWritableDatabase();
        String titulo = "mane";
        String descripcion = "debe";
        String nota = "me debe feria";

        ContentValues registro = new ContentValues();
        registro.put("titulo",titulo);
        registro.put("descripcion",descripcion);
        registro.put("nota",nota);

        admin.insert("notas",null,registro);

    }**/
}
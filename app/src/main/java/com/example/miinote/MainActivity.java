package com.example.miinote;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.example.miinote.Adaptador.Adaptador;
import com.example.miinote.Modelo.Item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adaptador adaptador;
    private RecyclerView.LayoutManager manager;
    private ArrayList<Item> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.RecyclerView);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        actualizarlista();
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

    public void actualizarlista()
    {

        BaseDeDatos admin =new BaseDeDatos(this,"MiiNota",null,1);
        lista=admin.MostrarNotas();
        if(lista.size()==0)
        {
            ArrayList<Item> listavacia=new ArrayList<>();
            listavacia.add(new Item("No Hay MiiNotas","",""));
            adaptador = new Adaptador(this,listavacia);
            recyclerView.setAdapter(adaptador);
        }
        else
        {
            adaptador= new Adaptador(this,lista);
            recyclerView.setAdapter(adaptador);
        }
    }

    public void TipoDeNota(View v)
    {
        AlertDialog.Builder Dialogo = new AlertDialog.Builder(this);
        Dialogo.setTitle("Tipo De Archivo:");
        final String[] opciones = new String[]{"Nota", "Multimedia"};
        Dialogo.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i==0)
                {
                    Intent intent = new Intent(getBaseContext(),LlenadoNota.class);
                    startActivity(intent);
                }
                else
                {

                }
            }
        });
        Dialogo.setNegativeButton("Cancelar",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        Dialogo.create().show();
    }
}
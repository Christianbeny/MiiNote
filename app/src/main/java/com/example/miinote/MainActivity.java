package com.example.miinote;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.example.miinote.Adaptador.Adaptador;
import com.example.miinote.Modelo.Item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//55959594
/**
    private DataBaseManager manager;
    private Cursor cursor;
    private ListView lista;
    private Adaptador adapter;
**/
    private RecyclerView recyclerView;
    private Adaptador adaptador;
    private RecyclerView.LayoutManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/**
        manager = new DataBaseManager(this);
        lista = (ListView) findViewById(R.id.RecyclerView);

        manager.insertar("Mane","debe Feria","Me deves mucho mane hijo de la *******");
        //manager.insertar("Aplicacion","debe Feria","Me deves mucho mane hijo de la *******");
        //manager.insertar("chales","debe Feria","Me deves mucho mane hijo de la *******");

        cursor = manager.cargarCursorNotas();

        adapter = new Adaptador();
        lista.setAdapter(adapter);
**/


        recyclerView = findViewById(R.id.RecyclerView);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        adaptador = new Adaptador(this,getlista());
        recyclerView.setAdapter(adaptador);

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
    private ArrayList<Item> getlista() {
        ArrayList<Item> itemLists = new ArrayList<>();
        itemLists.add(new Item("Saga de Broly", "Ultima pelicula de DB, peleas epicas.", "Atomicos"));
        itemLists.add(new Item("Super sayayines 4", "La ultima transformacion de la saga no canon.", "Atomicos"));
        itemLists.add(new Item("Super Sayayiness Blues", "Goku y Vegeta, la transformacion de dioses.", "Atomicos"));
        itemLists.add(new Item("Goku ultrainstinto", "Infaltablñe power-up a Goku.", "Atomicos"));
        itemLists.add(new Item("Super Vegeta Blue x2", "Diferentes transformaciones de super Vegeta.", "Atomicos"));
        itemLists.add(new Item("Vegeta sapbe", "Vegeta sapbe o no sapbe xD.", "Atomicos"));
        itemLists.add(new Item("Saga de Broly", "Ultima pelicula de DB, peleas epicas.", "Atomicos"));
        itemLists.add(new Item("Super sayayines 4", "La ultima transformacion de la saga no canon.","Atomicos"));
        itemLists.add(new Item("Super Sayayiness Blues", "Goku y Vegeta, la transformacion de dioses.", "Atomicos"));
        itemLists.add(new Item("Goku ultrainstinto", "Infaltablñe power-up a Goku.", "Atomicos"));
        itemLists.add(new Item("Super Vegeta Blue x2", "Diferentes transformaciones de super Vegeta.", "Atomicos"));
        itemLists.add(new Item("Vegeta sapbe", "Vegeta sapbe o no sapbe xD.", "Atomicos"));

        return itemLists;
    }
}
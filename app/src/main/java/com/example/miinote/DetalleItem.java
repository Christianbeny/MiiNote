package com.example.miinote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miinote.Modelo.Item;
import com.example.miinote.Modelo.Notas;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DetalleItem extends AppCompatActivity {

    private TextView tvTitulo;
    private TextView tvDescrip;
    private TextView tvNota;
    private TextView tvFecha;
    private Item detalleItem;
    private EditText titulo;
    private EditText descripcion;
    private EditText nota;
    int id, resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_item);


        titulo = (EditText)findViewById(R.id.txtTitulo);
        descripcion = (EditText)findViewById(R.id.txtDescripcion);
        nota = (EditText)findViewById(R.id.txtNota);

        initViews();
        initValues();
    }

    private void initViews() {
        tvTitulo = findViewById(R.id.txtTitulo);
        tvDescrip = findViewById(R.id.txtDescripcion);
        tvNota = findViewById(R.id.txtNota);
        tvFecha = findViewById(R.id.txtFecha);
    }

    private void initValues() {
        detalleItem = (Item) getIntent().getExtras().getSerializable("detalleItem");
        id=detalleItem.getId();
        tvTitulo.setText(detalleItem.getTitulo());
        tvDescrip.setText(detalleItem.getDescrip());
        tvNota.setText(detalleItem.getNota());
        tvFecha.setText(detalleItem.getFecha());
    }

    public void Actualizar(View view)
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
            bd.update("notas",registro,"Idnota="+id,null);
            bd.close();
            Toast.makeText(this, "MiiNota Acualizada", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getBaseContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Toast.makeText(this, "Algun Campo Esta Vacio", Toast.LENGTH_SHORT).show();
        }
    }

    public void Eliminar(View view)
    {
        BaseDeDatos admin =new BaseDeDatos(this,"MiiNota",null,1);
        SQLiteDatabase bd= admin.getWritableDatabase();
        resultado = bd.delete("notas","Idnota="+id,null);
        bd.close();
        if (resultado>0){
            Toast.makeText(this, "MiiNota Eliminada", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getBaseContext(),MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "MiiNota No Eliminada", Toast.LENGTH_SHORT).show();
        }
    }

    private String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
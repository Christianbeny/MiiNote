package com.example.miinote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class LlenadoNota extends AppCompatActivity {

    private EditText tiutulo;
    private EditText descripcion;
    private EditText nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llenado_nota);

        tiutulo = (EditText)findViewById(R.id.txt_Titulo);
        descripcion = (EditText)findViewById(R.id.txt_Descripcion);
        nota = (EditText)findViewById(R.id.txt_Texto);

    }
}
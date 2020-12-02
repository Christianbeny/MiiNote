package com.example.miinote.Modelo;

import java.io.Serializable;

public class Item implements Serializable {

    private int id;
    private String titulo;
    private String descrip;
    private String fecha;
    private String Nota;

    public Item(int id, String titulo, String descrip,String fecha,String nota) {
        this.id = id;
        this.titulo = titulo;
        this.descrip = descrip;
        this.Nota = nota;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescrip() {
        return descrip;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNota() {
        return Nota;
    }
}


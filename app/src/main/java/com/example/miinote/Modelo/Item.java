package com.example.miinote.Modelo;

public class Item {

    private String titulo;
    private String descrip;
    private String fecha;

    public Item(String titulo, String descrip,String fecha) {
        this.titulo = titulo;
        this.descrip = descrip;
        this.fecha = fecha;
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

}


package com.example.miinote.Modelo;

public class Item {

    private String titulo;
    private String descrip;
    private String nota;

    public Item(String titulo, String descrip, String nota) {
        this.titulo = titulo;
        this.descrip = descrip;
        this.nota = nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescrip() {
        return descrip;
    }

    public String getNota() {
        return nota;
    }
}

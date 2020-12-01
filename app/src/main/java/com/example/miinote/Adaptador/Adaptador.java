package com.example.miinote.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miinote.Modelo.Item;
import com.example.miinote.R;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter {

    private Context contexto;
    private ArrayList<Item> listaItem;

    public Adaptador(Context contexto, ArrayList<Item> listaItem) {
        this.contexto = contexto;
        this.listaItem = listaItem;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(contexto).inflate(R.layout.layout_item_list,null);
        return new Holder(contentView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item item = listaItem.get(position);
        Holder Hol = (Holder) holder;
        Hol.txtTitu.setText(item.getTitulo());
        Hol.txtDes.setText(item.getDescrip());
        Hol.txtfecha.setText(item.getFecha());
    }

    @Override
    public int getItemCount() {
        return listaItem.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{

        TextView txtTitu;
        TextView txtDes;
        TextView txtfecha;

        public Holder(View itemView) {
            super(itemView);

            txtTitu = (TextView) itemView.findViewById(R.id.txtTitulo);
            txtDes = (TextView) itemView.findViewById(R.id.txtDesc);
            txtfecha = (TextView) itemView.findViewById(R.id.txtFecha);
        }
    }
}

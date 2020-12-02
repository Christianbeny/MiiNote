package com.example.miinote.Adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miinote.DetalleItem;
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
        final Item item = listaItem.get(position);
        final Holder Hol = (Holder) holder;
        Hol.txtTitu.setText(item.getTitulo());
        Hol.txtDes.setText(item.getDescrip());
        Hol.txtfecha.setText(item.getFecha());

        Hol.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hol.itemView.getContext(), DetalleItem.class);
                intent.putExtra("detalleItem", item);
                Hol.itemView.getContext().startActivity(intent);
            }
        });
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

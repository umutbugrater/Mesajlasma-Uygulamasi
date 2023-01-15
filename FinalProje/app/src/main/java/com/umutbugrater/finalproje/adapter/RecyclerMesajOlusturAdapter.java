package com.umutbugrater.finalproje.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.umutbugrater.finalproje.R;
import com.umutbugrater.finalproje.model.MesajOlusturModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerMesajOlusturAdapter extends RecyclerView.Adapter<RecyclerMesajOlusturAdapter.ViewHolder> {

    ArrayList<MesajOlusturModel> mesajOlusturDizisi;
    Context context;

    public RecyclerMesajOlusturAdapter(ArrayList<MesajOlusturModel> mesajOlusturDizisi, Context context) {
        this.mesajOlusturDizisi = mesajOlusturDizisi;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerMesajOlusturAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.mesajolustur,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerMesajOlusturAdapter.ViewHolder holder, int position) {
        holder.baslik.setText(mesajOlusturDizisi.get(position).getBaslik());
        holder.aciklama.setText(mesajOlusturDizisi.get(position).getAciklama());
    }

    @Override
    public int getItemCount() {
        return mesajOlusturDizisi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView baslik;
        TextView aciklama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            baslik = itemView.findViewById(R.id.tv_card_mesajBaslik);
            aciklama = itemView.findViewById(R.id.tv_card_mesajAciklama);
        }
    }
}

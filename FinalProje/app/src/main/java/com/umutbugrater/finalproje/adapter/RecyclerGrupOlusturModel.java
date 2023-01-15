package com.umutbugrater.finalproje.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.umutbugrater.finalproje.R;
import com.umutbugrater.finalproje.model.GrupOlusturModel;

import java.util.ArrayList;

public class RecyclerGrupOlusturModel extends RecyclerView.Adapter<RecyclerGrupOlusturModel.ViewHolder> {
    ArrayList<GrupOlusturModel> grupOlusturDizisi;
    Context context;

    public RecyclerGrupOlusturModel(ArrayList<GrupOlusturModel> grupOlusturDizisi, Context context) {
        this.grupOlusturDizisi = grupOlusturDizisi;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerGrupOlusturModel.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.grupolustur,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerGrupOlusturModel.ViewHolder holder, int position) {
        holder.grupAdi.setText(grupOlusturDizisi.get(position).getGrupAdi());
        holder.grupAciklama.setText(grupOlusturDizisi.get(position).getGrupAciklama());
    }

    @Override
    public int getItemCount() {
        return grupOlusturDizisi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView grupAdi,grupAciklama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            grupAdi = itemView.findViewById(R.id.tv_card_grupAdi);
            grupAciklama = itemView.findViewById(R.id.tv_card_grupAciklama);
        }
    }
}

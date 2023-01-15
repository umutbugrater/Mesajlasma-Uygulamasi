package com.umutbugrater.finalproje;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.umutbugrater.finalproje.adapter.RecyclerMesajOlusturAdapter;
import com.umutbugrater.finalproje.model.MesajOlusturModel;

import java.util.ArrayList;


public class nav_mesajOlustur extends Fragment {

    EditText mesajBaslik, mesajAciklama;
    RecyclerView recyclerView;
    Button mesajOlustur;

    DatabaseReference reference;
    RecyclerMesajOlusturAdapter adapter;
    ArrayList<MesajOlusturModel> mesajOlusturDizisi;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nav_mesaj_olustur, container, false);
        mesajBaslik = view.findViewById(R.id.editTextTMesajBaslikInput);
        mesajAciklama = view.findViewById(R.id.editTextMesajAciklamaInput);
        mesajOlustur = view.findViewById(R.id.buttonMesajOlustur);
        context = getContext();

        recyclerView = view.findViewById(R.id.rv_mesajOlustur);
        reference = FirebaseDatabase.getInstance().getReference("Mesaj");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        mesajOlusturDizisi = new ArrayList<MesajOlusturModel>();
        adapter = new RecyclerMesajOlusturAdapter(mesajOlusturDizisi,context);
        recyclerView.setAdapter(adapter);

        mesajOlustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mesajOlusturDizisi.clear();
                MesajOlusturModel model = new MesajOlusturModel(mesajBaslik.getText().toString(),mesajAciklama.getText().toString());
                reference.push().setValue(model);
            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mesajOlusturDizisi.clear();

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    MesajOlusturModel model = dataSnapshot.getValue(MesajOlusturModel.class);
                    mesajOlusturDizisi.add(model);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        return view;
    }
}
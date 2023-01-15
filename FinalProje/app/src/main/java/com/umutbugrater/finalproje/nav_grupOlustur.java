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
import com.umutbugrater.finalproje.adapter.RecyclerGrupOlusturModel;
import com.umutbugrater.finalproje.model.GrupOlusturModel;

import java.util.ArrayList;


public class nav_grupOlustur extends Fragment {
    Button grupOlustur;
    EditText grupAdi, grupAciklama;
    RecyclerView recyclerView;

    DatabaseReference reference;
    RecyclerGrupOlusturModel adapter;
    ArrayList<GrupOlusturModel> grupOlusturDizisi;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_nav_grup_olustur, container, false);
       grupOlustur = view.findViewById(R.id.buttonGrupOlustur);
       grupAdi = view.findViewById(R.id.editTextGrupAdiInput);
       grupAciklama = view.findViewById(R.id.editTextTGrupAciklamaInput);
       context = getContext();

       recyclerView = view.findViewById(R.id.rv_grupOlustur);
       reference = FirebaseDatabase.getInstance().getReference("Grup");
       recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(context));

       grupOlusturDizisi = new ArrayList<>();
       adapter = new RecyclerGrupOlusturModel(grupOlusturDizisi,context);
       recyclerView.setAdapter(adapter);

       grupOlustur.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               grupOlusturDizisi.clear();
               GrupOlusturModel model = new GrupOlusturModel(grupAdi.getText().toString(),grupAciklama.getText().toString());
               reference.push().setValue(model);
           }
       });

       reference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               grupOlusturDizisi.clear();
               for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                   GrupOlusturModel model = dataSnapshot.getValue(GrupOlusturModel.class);
                   grupOlusturDizisi.add(model);
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
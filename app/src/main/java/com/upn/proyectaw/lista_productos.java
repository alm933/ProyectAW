package com.upn.proyectaw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class lista_productos extends AppCompatActivity {

    RecyclerView rvProductos;
    FloatingActionButton btnnuevo2;
    FirebaseDatabase database;
    DatabaseReference reference;
    private List<Productos> listaProductos = new ArrayList<>();
    AdaptadorProductos adaptadorProductos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);
        asignarReferencias();
        inicializarFireBase();
        mostrarDatos();
    }

    private void inicializarFireBase() {
        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
    }

    private void mostrarDatos() {
        reference.child("Productos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listaProductos.clear();
                for(DataSnapshot item:snapshot.getChildren()){
                    Productos p = item.getValue(Productos.class);
                    listaProductos.add(p);
                }
                adaptadorProductos = new AdaptadorProductos(lista_productos.this, listaProductos);
                rvProductos.setAdapter(adaptadorProductos);
                rvProductos.setLayoutManager(new LinearLayoutManager(lista_productos.this));


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    private void asignarReferencias() {
        rvProductos = findViewById(R.id.nvProductos);
        btnnuevo2 = findViewById(R.id.btnproducto);
    }
}
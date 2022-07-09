package com.upn.proyectaw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.upn.proyectaw.entidades.Usuarios;

import java.util.ArrayList;
import java.util.List;

public class ListaUsuarios extends AppCompatActivity {

    RecyclerView rvUsuarios;
    FloatingActionButton btnNuevo;



    FirebaseDatabase database;
    DatabaseReference reference;
    private List<Usuarios> listaUsuarios = new ArrayList<>();
    AdaptadorPersonalizado adaptador;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);
        asignarReferencias();
        inicializarFirebase();
        mostrarDatos();
    }

    private void mostrarDatos() {
        reference.child("Ususarios").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                listaUsuarios.clear();
                for(DataSnapshot item:snapshot.getChildren()){
                    Usuarios u = item.getValue(Usuarios.class);
                    listaUsuarios.add(u);
                }

                adaptador = new AdaptadorPersonalizado(ListaUsuarios.this, listaUsuarios);
                rvUsuarios.setAdapter(adaptador);
                rvUsuarios.setLayoutManager(new LinearLayoutManager(ListaUsuarios.this));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void inicializarFirebase() {

        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();



    }

    private void asignarReferencias() {
        rvUsuarios = findViewById(R.id.nvUsuarios);
        btnNuevo = findViewById(R.id.btnNuevo);



        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int pos = viewHolder.getAdapterPosition();
                String id = listaUsuarios.get(pos).getId();
                listaUsuarios.remove(pos);
                adaptador.notifyDataSetChanged();
                reference.child("Ususarios").child(id).removeValue();
            }

        }).attachToRecyclerView(rvUsuarios);}}
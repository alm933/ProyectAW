package com.upn.proyectaw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Producto extends AppCompatActivity{

    boolean producto = true;
    FirebaseDatabase database;
    DatabaseReference reference ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        int analgesico = getIntent().getIntExtra("analgesico",1);

        if (analgesico == 1) {
            ImageView i = findViewById(R.id.imageProducto);
            i.setImageResource(R.drawable.analgesico512);
        }else{
            Toast.makeText(this,"no se pudo",Toast.LENGTH_LONG).show();
        }

    }
}
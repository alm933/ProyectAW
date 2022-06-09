package com.upn.proyectaw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class Producto extends AppCompatActivity{


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
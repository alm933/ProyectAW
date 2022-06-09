package com.upn.proyectaw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Producto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);


        ImageView i = findViewById(R.id.imageProducto);
        i.setImageResource(R.drawable.gcopia);



    }
}
package com.upn.proyectaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class VistadePrueba2 extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vistade_prueba2);
        Button producto = findViewById(R.id.botonproducto);

        producto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

             int analgesico = 1;

                Intent i = new Intent(VistadePrueba2.this , Producto.class);
                i.putExtra("analgesico" ,1);
                startActivity(i);

            }
        });
    }

}
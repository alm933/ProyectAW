package com.upn.proyectaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class VistadeProducto3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vistade_producto3);
        ImageView ima = findViewById(R.id.nastiflu);
        TextView nastiflut = findViewById(R.id.nastifluT);
        TextView precionas = findViewById(R.id.precionas);
        TextView precionas2 = findViewById(R.id.precionas2);


        //imagen de nastiflu
        ima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(VistadeProducto3.this, Producto.class);
                i.putExtra("analgesico", 1);
                startActivity(i);
            }
        });
        //texto de nastiflu
        nastiflut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VistadeProducto3.this, Producto.class);
                i.putExtra("analgesico", 1);
                startActivity(i);
            }
        });
        //precio texto nastiflu
        precionas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VistadeProducto3.this,Producto.class);
                i.putExtra("analgesico",1);
                startActivity(i);
            }
        });

        precionas2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VistadeProducto3.this,Producto.class);
                i.putExtra("analgesico",1);
                startActivity(i);
            }
        });





    }
}
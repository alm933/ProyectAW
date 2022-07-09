package com.upn.proyectaw;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class RegistrarProducto extends AppCompatActivity {


    EditText namep , priceN , priceD , Stock , descriptionp;
    Button btnregistrarP;
    boolean re = true;
    HashMap map = new HashMap();
    Productos productos;
    String nombre;
    FirebaseDatabase database;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_producto);
         asignar();
         inicializar();
         obtener();
    }
    private void asignar(){
        namep = findViewById(R.id.namep);
        priceN = findViewById(R.id.priceN);
        priceD =  findViewById(R.id.priceD);
        Stock = findViewById(R.id.Stock);
        descriptionp = findViewById(R.id.Stock);
        btnregistrarP = findViewById(R.id.buttonp);
        btnregistrarP.setOnClickListener(v -> {
            capturarDatos();
            String mensajes="";

            if(re){
                reference.child("Prodructos").child(productos.getPnombreproducto()).setValue(productos);
                mensajes = "Producto Registrado";
            }else{
                reference.child("Productos").child(nombre).updateChildren(map);
                mensajes = "El producto ha sido actualizado";
            }


            AlertDialog.Builder ventana = new AlertDialog.Builder(RegistrarProducto.this);
            ventana.setTitle("Mensaje Informativo");
            ventana.setMessage(mensajes);
            ventana.setPositiveButton("Aceptar",null);
            ventana.create().show();
        });

    }

    private void capturarDatos() {
        String name = namep.getText().toString();
        String priceNor = priceN.getText().toString();
        String priceDis = priceD.getText().toString();
        String stock = Stock.getText().toString();
        String description = descriptionp.getText().toString();

        if(re){
            productos = new Productos(name,description,priceNor,priceDis,stock);
        }else{
            map.put("nombreproducto",name);
            map.put("precionormal",priceNor);
            map.put("preciooferta",priceDis);
            map.put("stock",stock);
            map.put("descripcioncorta",description);
        }



    }

    private void inicializar() {
        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
    }

    private void obtener() {

        namep.setText(getIntent().getStringExtra("pnombreproducto"));
        priceN.setText(getIntent().getStringExtra("precionormal"));
        priceD.setText(getIntent().getStringExtra("preciodescuento"));
        Stock.setText(getIntent().getStringExtra("Stock"));
        descriptionp.setText(getIntent().getStringExtra("descripcioncorta"));
}
}
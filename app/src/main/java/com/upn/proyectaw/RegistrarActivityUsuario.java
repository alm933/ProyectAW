package com.upn.proyectaw;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseRegistrar;
import com.google.firebase.database.FirebaseDatabase;
import com.upn.proyectaw.entidades.Usuarios;

import java.util.HashMap;
import java.util.UUID;

public class RegistrarActivityUsuario extends AppCompatActivity {

    EditText userName, userLastname, userAddress, userEmail, userPhone, userPassword;
    Button btnRegistrarse;
    Usuarios usuarios;
    FirebaseDatabase database;
    DatabaseReference reference;
    boolean registrar = true;
    String id;

    HashMap map = new HashMap();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        asignarreferencias();
        inizializarFireBase();
        obtenerValores();
    }

    private void obtenerValores() {
        if(getIntent().hasExtra("pid")){
            registrar = false;
            id = getIntent().getStringExtra("pid");
            userName.setText(getIntent().getStringExtra("pnombre"));
            userLastname.setText(getIntent().getStringExtra("papellido"));
            userEmail.setText(getIntent().getStringExtra("pcorreo"));
            userPhone.setText(getIntent().getStringExtra("pphone"));


        }


    }

    private void asignarreferencias() {
        userName = findViewById(R.id.userName);
        userLastname = findViewById(R.id.userLastName);
        userPhone = findViewById(R.id.userPhone);
        userAddress = findViewById(R.id.userAddress);
        userEmail = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPassword);
        btnRegistrarse = findViewById(R.id.btnRegisteruser);
        btnRegistrarse.setOnClickListener(v -> {
            capturarDatos();
            String mensaje="";

            if(registrar){
                reference.child("Ususarios").child(usuarios.getId()).setValue(usuarios);
                mensaje = "Usuario Registrado";
            }else{
                reference.child("Ususarios").child(id).updateChildren(map);
                mensaje = "Usuario Actualizado";
            }


            AlertDialog.Builder ventana = new AlertDialog.Builder(RegistrarActivityUsuario.this);
            ventana.setTitle("Mensaje Informativo");
            ventana.setMessage(mensaje);
            ventana.setPositiveButton("Aceptar",null);
            ventana.create().show();



        });
    }

    private void capturarDatos(){
        String nombre = userName.getText().toString();
        String apellido = userLastname.getText().toString();
        String email = userEmail.getText().toString();
        String password = userPassword.getText().toString();
        String telefono = userPhone.getText().toString();
        String direccion = userAddress.getText().toString();

        if(registrar){
            usuarios = new Usuarios(UUID.randomUUID().toString(),nombre,apellido,email,password,telefono,direccion);
        }else{
            map.put("nombre",nombre);
            map.put("apellido",apellido);
            map.put("email",email);
            map.put("telefono",telefono);
        }



    }

    private void inizializarFireBase() {
        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
    }
}
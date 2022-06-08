package com.upn.proyectaw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //boton de registrar

        val botons1 = findViewById<Button>(R.id.register)
        botons1.setOnClickListener{
            val lanzar = Intent(this, RegistrarActivity::class.java)
            startActivity(lanzar)
        }

        val btnlogin = findViewById<Button>(R.id.buttonLogin);
        btnlogin.setOnClickListener {
            var usr = findViewById<EditText>(R.id.textEmail);
            val pss = findViewById<EditText>(R.id.passw);

            if(usr.getText().toString().equals("user")&&pss.getText().toString().equals("pass")){

                val lanzar = Intent(this, VistadePrueba2::class.java)
                startActivity(lanzar)


            }else{
                Toast.makeText(this,"cREDENCIALES INCRORRECTAS",Toast.LENGTH_LONG).show();

            }
        }




    }
}
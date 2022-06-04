package com.upn.proyectaw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.widget.Button

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
    }
}
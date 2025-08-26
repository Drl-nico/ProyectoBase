package com.example.proyectobase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.sql.Date

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        val nombreguardarVariable:EditText=findViewById(R.id.ed_nombreguardar)
        val apellidoGuardarVariable:EditText=findViewById(R.id.ed_apellidoguardar)
        val fechanaciminentoguardar: EditText = findViewById(R.id.ed_fechaNacimiento)
        val buttonVolver: Button=findViewById(R.id.volver_retroceder)
        val buttonGuardardatos: Button=findViewById(R.id.guardarDatos)
        val textomostrar1:TextView=findViewById(R.id.textView2)

        var guardardatos=""
        buttonGuardardatos.setOnClickListener{
            guardardatos=nombreguardarVariable.text.toString()
            guardardatos=apellidoGuardarVariable.text.toString()
            guardardatos=fechanaciminentoguardar.text.toString()
        }
        buttonVolver.setOnClickListener{
            val back = Intent(this, MainActivity2::class.java)
            startActivity(back)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
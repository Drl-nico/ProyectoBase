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
        val textomostrar2:TextView=findViewById(R.id.textView3)
        val textomostrarfecha:TextView=findViewById(R.id.textView4)
        val buttonContinuar: Button=findViewById(R.id.ed_continuar)

        var guardardatosnombre=""
        var guardardatosapellidos=""
        var fechaguardar=""
        buttonGuardardatos.setOnClickListener{
            guardardatosnombre=nombreguardarVariable.text.toString()
            guardardatosapellidos=apellidoGuardarVariable.text.toString()
            fechaguardar=fechanaciminentoguardar.text.toString()
            textomostrar1.setText(guardardatosnombre)
            textomostrar2.setText((guardardatosapellidos))
            textomostrarfecha.setText(fechaguardar)
        }
        buttonVolver.setOnClickListener{
            val back = Intent(this, MainActivity2::class.java)
            startActivity(back)
        }

        buttonContinuar.setOnClickListener{
            val continuar = Intent(this, MainActivity4::class.java)
            startActivity(continuar)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
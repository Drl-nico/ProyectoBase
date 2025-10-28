package com.example.proyectobase

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectobase.funciones.InsertarAlumnosAPI
import com.example.proyectobase.DB.AlumnosLocalRepository

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main6)

        val nombre_dato:EditText=findViewById(R.id.ed_Name)
        val apellido_dato:EditText=findViewById(R.id.ed_LastName)
        val guardar_activity_sql:Button=findViewById(R.id.ed_button_foto)
        val saves_datos:Button=findViewById(R.id.ed_save)
        val spSeccion:Spinner=findViewById(R.id.ed_seccion)
        val spgrupo:Spinner=findViewById(R.id.ed_grupo)

        val grupos = listOf("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20")

        val seccion= listOf("1","2","3","4","5","6","7","8","9","10")
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,grupos.apply {  })
        val adapter2=ArrayAdapter(this,android.R.layout.simple_spinner_item,seccion.apply {  })

        spSeccion.adapter=adapter2
        spgrupo.adapter=adapter

        saves_datos.setOnClickListener {
            InsertarAlumnosAPI.insertarAlumno(
                owner = this,
                context = this,
                nombre = nombre_dato.text.toString(),
                apellido = apellido_dato.text.toString(),
                grupo = spgrupo.selectedItem.toString(),
                seccion = spSeccion.selectedItem.toString(),
                archivoBytes = null,
                onSuccess = {
                    println("termino de insert correcto")
                    Toast.makeText(this,"guardado",Toast.LENGTH_SHORT)
                },
                onError = {
                    println("Termino insert incorrecto")
                    Toast.makeText(this,"nO gUardado",Toast.LENGTH_SHORT)
                }
            )
        }
        guardar_activity_sql.setOnClickListener {
            AlumnosLocalRepository.insert(this,nombre_dato.text.toString(),apellido_dato.text.toString(),spgrupo.selectedItem.toString(),spSeccion.selectedItem.toString())
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
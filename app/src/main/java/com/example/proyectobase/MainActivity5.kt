package com.example.proyectobase

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)
        val opcionesLV:ListView=findViewById(R.id.ed_menu_lv)
        val opcionesArr= arrayOf(
            "Sumar",
            "Restar",
            "Multiplicar",
            "Hola mundos",
            "Dividir"
        )
        val adaptador = ArrayAdapter(this,android.R.layout.simple_list_item_1,opcionesArr)
        opcionesLV.adapter = adaptador




        opcionesLV.setOnItemClickListener{ parent,view,position,id->
            val itemlegido=parent.getItemAtPosition(position).toString()
            Toast.makeText(this,itemlegido,Toast.LENGTH_SHORT).show()

        }























        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
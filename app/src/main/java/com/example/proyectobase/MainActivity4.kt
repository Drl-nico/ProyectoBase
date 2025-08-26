package com.example.proyectobase

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        val dato1guardar:EditText=findViewById(R.id.ed_dato1)
        val datos2guardar:EditText=findViewById(R.id.ed_dato2)
        val mostrarResultado:TextView=findViewById(R.id.Mostrar_Resultado)
        val calcularbutton:Button=findViewById(R.id.ed_calcular)



        calcularbutton.setOnClickListener {

            val valor1 = dato1guardar.text.toString().toIntOrNull() ?: 0
            val valor2 = datos2guardar.text.toString().toIntOrNull() ?: 0


            val resultado = valor1 + valor2

            mostrarResultado.text = resultado.toString()
        }












        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
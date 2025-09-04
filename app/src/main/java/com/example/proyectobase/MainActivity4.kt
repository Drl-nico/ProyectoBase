package com.example.proyectobase

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectobase.utils.OPMath

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        val dato1guardar:EditText=findViewById(R.id.ed_dato1)
        val datos2guardar:EditText=findViewById(R.id.ed_dato2)
        val mostrarResultado:TextView=findViewById(R.id.Mostrar_Resultado)
        val calcularbutton:Button=findViewById(R.id.ed_calcular)
        val menu:Spinner=findViewById(R.id.ed_spinner)

        val menuopciones = arrayOf("sumar","restar","multiplicar","dividir")

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,menuopciones)

        menu.adapter=adapter


        calcularbutton.setOnClickListener{
             val valor1 = dato1guardar.text.toString().toIntOrNull() ?: 0
             val valor2 = datos2guardar.text.toString().toIntOrNull() ?: 0
            val opcion=menu.selectedItem.toString()
             val resultado=when(opcion){
                 "sumar"->OPMath.sumar(valor1,valor2)
                 "restar"->OPMath.restar(valor1,valor2)
                 "multiplicar"->OPMath.multi(valor1,valor2)
                 "dividir"->OPMath.divi(valor1,valor2)
                 else -> 0
             }
            mostrarResultado.text=resultado.toString()
        }

        /* opcion 2 dividir error
        calcularbutton.setOnClickListener {
            val valor1 = dato1guardar.text.toString().toIntOrNull() ?: 0
            val valor2 = datos2guardar.text.toString().toIntOrNull() ?: 0
            var resultado=0
           val opcion=menu.selectedItem.toString()
            when(opcion){
                "sumar"->resultado = valor1 + valor2
                "restar"->resultado = valor1 - valor2
                "multiplicar"->resultado = valor1 * valor2
               "dividir"->{
                   resultado;if(valor2!=0) valor1/valor2 else 0
               }
           }
            mostrarResultado.text = resultado.toString()
        }
        */


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
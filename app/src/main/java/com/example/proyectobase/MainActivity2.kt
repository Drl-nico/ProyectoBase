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

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        //ACTIVITY DESTINO
        val ed_buttonPerfil2: Button = findViewById(R.id.ed_buttonPerfil)
        val msjeBienvenida:TextView = findViewById(R.id.tx_bienvenido)
        //creo variable asigno valor recibido desde otro activity
        val usuarioDesdeOtroActivity = intent.getStringExtra("sesion")
        //seteo un TextView reemplazando el texto por el contenido.

        msjeBienvenida.text = usuarioDesdeOtroActivity.toString()

        val recibeContrasena = intent.getStringExtra("par_contrasena")


        var recibeUserName:EditText = findViewById(R.id.ed_username2)
        recibeUserName.setText(usuarioDesdeOtroActivity.toString())

        val recibePass:EditText=findViewById(R.id.ed_contra)
        recibePass.setText(recibeContrasena.toString())


        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(this,usuarioDesdeOtroActivity,duration)
        toast.show()

        ed_buttonPerfil2.setOnClickListener{
            val goperfil = Intent(this, MainActivity3::class.java)
            startActivity(goperfil)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
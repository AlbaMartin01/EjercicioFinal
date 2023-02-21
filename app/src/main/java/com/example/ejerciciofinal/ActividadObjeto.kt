package com.example.ejerciciofinal

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciofinal.ui.login.jugador

class ActividadObjeto : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_objeto)

        var obj = Objeto(5, 10, 20)

        var personaje1 = jugador("Juan")

        var dado = (1..2).random()
        if (dado == 1) {
            findViewById<ImageView>(R.id.imagenObjeto).setImageResource(R.drawable.piedra)
        } else if (dado == 2){
            findViewById<ImageView>(R.id.imagenObjeto).setImageResource(R.drawable.espada)
        }

        findViewById<Button>(R.id.botonRecoger).setOnClickListener {
            personaje1.mochila.addObjeto(obj, applicationContext)
            var intento = Intent(this, ActividadDado::class.java)
            startActivity(intento)
        }

        findViewById<Button>(R.id.botonContinuar).setOnClickListener {
            var intento = Intent(this, ActividadDado::class.java)
            startActivity(intento)
        }

    }
}
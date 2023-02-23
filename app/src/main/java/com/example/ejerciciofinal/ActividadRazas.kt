package com.example.ejerciciofinal

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class ActividadRazas : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_razas)

        var stringRazas = ""
        var clase = intent.getStringExtra("imagenC")

        findViewById<Button>(R.id.botonElfo).setOnClickListener{
            findViewById<ImageView>(R.id.imagenInicio).setImageResource(R.drawable.elfo)
            stringRazas = "elfo"
        }

        findViewById<Button>(R.id.botonHumano).setOnClickListener{
            findViewById<ImageView>(R.id.imagenInicio).setImageResource(R.drawable.humano)
            stringRazas = "humano"
        }

        findViewById<Button>(R.id.botonEnano).setOnClickListener{
            findViewById<ImageView>(R.id.imagenInicio).setImageResource(R.drawable.enano)
            stringRazas = "enano"
        }

        findViewById<Button>(R.id.botonGoblin).setOnClickListener{
            findViewById<ImageView>(R.id.imagenInicio).setImageResource(R.drawable.goblin)
            stringRazas = "goblin"
        }

        findViewById<Button>(R.id.botonAceptar).setOnClickListener{
            val intento = Intent(this,ActividadRazasClases::class.java)
            intento.putExtra("imagenC", clase)
            intento.putExtra("imagenR", stringRazas)
            startActivity(intento)
        }
    }
}
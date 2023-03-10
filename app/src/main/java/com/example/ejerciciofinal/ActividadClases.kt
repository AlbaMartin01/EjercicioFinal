package com.example.ejerciciofinal

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

class ActividadClases : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_clases)

        var stringClase = ""

        var start = findViewById<ImageButton>(R.id.start)
        var pause = findViewById<ImageButton>(R.id.pause)

        start.setOnClickListener{
            startService(Intent(applicationContext,MyService::class.java))
        }
        pause.setOnClickListener{
            stopService(Intent(applicationContext,MyService::class.java))
        }

        findViewById<Button>(R.id.botonGuerrero).setOnClickListener {
            findViewById<ImageView>(R.id.imagen).setImageResource(R.drawable.guerrero)
            stringClase = "guerrero"
        }

        findViewById<Button>(R.id.botonLadron).setOnClickListener {
            findViewById<ImageView>(R.id.imagen).setImageResource(R.drawable.ladron)
            stringClase = "ladron"
        }

        findViewById<Button>(R.id.botonMago).setOnClickListener {
            findViewById<ImageView>(R.id.imagen).setImageResource(R.drawable.mago)
            stringClase = "mago"
        }

        findViewById<Button>(R.id.botonBerserker).setOnClickListener {
            findViewById<ImageView>(R.id.imagen).setImageResource(R.drawable.berserker)
            stringClase = "berserker"
        }

        findViewById<Button>(R.id.botonaceptar).setOnClickListener {
            val intento = Intent(this, ActividadRazas::class.java)
            intento.putExtra("imagenC", stringClase)
            startActivity(intento)
        }

    }
}
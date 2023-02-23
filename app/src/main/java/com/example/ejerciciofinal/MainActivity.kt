package com.example.ejerciciofinal

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mediaPlayer: MediaPlayer = MediaPlayer.create(this,R.raw.musica_epica)
        mediaPlayer.start()

        findViewById<Button>(R.id.botonEmpezar).setOnClickListener {
            var intento = Intent(this,ActividadClases::class.java)
            startActivity(intento)
        }
    }
}
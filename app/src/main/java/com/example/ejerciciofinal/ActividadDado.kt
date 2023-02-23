package com.example.ejerciciofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import kotlin.random.Random

class ActividadDado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_dado)

        var dado = (1..3).random()

        findViewById<ImageButton>(R.id.botonDado).setOnClickListener {
            if (dado == 1){
                var intento = Intent(this,ActividadObjeto::class.java)
                startActivity(intento)
            } else if (dado == 2){
                var intento = Intent(this, ActividadMercader::class.java)
                startActivity(intento)
            } else if (dado == 3){
                var intento = Intent(this, ActividadCombate::class.java)
                startActivity(intento)
            }
        }

    }
}
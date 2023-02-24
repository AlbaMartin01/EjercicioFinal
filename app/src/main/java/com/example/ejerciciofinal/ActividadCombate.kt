package com.example.ejerciciofinal

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.ContentLoadingProgressBar
import com.example.ejerciciofinal.ui.login.jugador
import kotlin.random.Random
import kotlin.random.nextInt

class ActividadCombate : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_combate)

        var dadoEnemigoElegir = Random.nextInt(1..2)

        var vidaEnemigo = 0
        var vidaJugador = 100

        var obj1 = Objeto(10,10,10)
        var obj2 = Objeto(10,10,10)
        var obj3 = Objeto(10,10,10)

        var objetos = ArrayList<Objeto>()

        var jugador1 = jugador(40,objetos,0)

        if (dadoEnemigoElegir == 1){
            findViewById<TextView>(R.id.vidaEnemigoNormal).visibility = View.VISIBLE
            findViewById<ContentLoadingProgressBar>(R.id.progressBar_enemigoNormal).visibility = View.VISIBLE
            vidaEnemigo = 100
        } else if (dadoEnemigoElegir == 2){
            findViewById<TextView>(R.id.vidaEnemigoJefe).visibility = View.VISIBLE
            findViewById<ContentLoadingProgressBar>(R.id.progressBar_enemigoJefe).visibility = View.VISIBLE
            vidaEnemigo = 200
        }

        findViewById<Button>(R.id.atacar).setOnClickListener {
            var dadoAtacar = Random.nextInt(1..6)
            if (dadoAtacar > 3 && vidaEnemigo > 0){
                vidaEnemigo -= jugador1.fuerza
                if (dadoEnemigoElegir == 1) {
                    findViewById<TextView>(R.id.vidaEnemigoNormal).setText("Vida enemigo normal: " + vidaEnemigo)
                    findViewById<ContentLoadingProgressBar>(R.id.progressBar_enemigoNormal).progress -= jugador1.fuerza
                } else if (dadoEnemigoElegir == 2){
                    findViewById<TextView>(R.id.vidaEnemigoJefe).setText("Vida jefe: " + vidaEnemigo)
                    findViewById<ContentLoadingProgressBar>(R.id.progressBar_enemigoJefe).progress -= jugador1.fuerza
                }
            } else if (dadoAtacar <= 3 && vidaEnemigo > 0){
                Toast.makeText(this,"Ataque rechazado", Toast.LENGTH_SHORT).show()
            }else if (vidaEnemigo <= 0){
                Toast.makeText(this,"Ya no queda más vida al enemigo", Toast.LENGTH_SHORT).show()
                objetos.add(obj1)
                objetos.add(obj2)
                objetos.add(obj3)
                jugador1 = jugador(40,objetos,100)
            }
            if (vidaJugador > 0 && vidaEnemigo > 0) {
                if (dadoEnemigoElegir == 1) {
                    vidaJugador -= 20
                    findViewById<TextView>(R.id.vidaJugador).setText("Vida: " + vidaJugador)
                    findViewById<ContentLoadingProgressBar>(R.id.progressBar_jugador).progress -= 20
                } else if (dadoEnemigoElegir == 2) {
                    vidaJugador -= 30
                    findViewById<TextView>(R.id.vidaJugador).setText("Vida: " + vidaJugador)
                    findViewById<ContentLoadingProgressBar>(R.id.progressBar_jugador).progress -= 30
                }
            }
            if (vidaJugador <= 0){
                var intento = Intent(this,PaginaNegro::class.java)
                startActivity(intento)
            }
        }

        findViewById<Button>(R.id.huir).setOnClickListener{
            var dadoHuir = Random.nextInt(1..6)
            if (dadoHuir > 4){
                Toast.makeText(this,"Has conseguido huir", Toast.LENGTH_SHORT).show()
                var intento = Intent(this,ActividadDado::class.java)
                startActivity(intento)
            } else{
                Toast.makeText(this,"No has conseguido huir",Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<Button>(R.id.objeto).setOnClickListener {
            var obj4 = Objeto(10,10,20)
            objetos.add(obj4)
            vidaJugador += 20
            jugador1 = jugador(20,objetos,0)
            findViewById<TextView>(R.id.vidaJugador).setText("Vida: " + vidaJugador)
            findViewById<ContentLoadingProgressBar>(R.id.progressBar_jugador).progress += 20
        }
    }
}
package com.example.ejerciciofinal

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.ejerciciofinal.ui.login.jugador

class ActividadMercader : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var obj = Objeto(125, 10, 20)
        var objeto1 = ArrayList<Objeto>()
        objeto1.add(obj)

        var personaje1 = jugador(10,objeto1,10)

        findViewById<Button>(R.id.continuar).setOnClickListener {
            var intento = Intent(this, ActividadDado::class.java)
            startActivity(intento)
        }

        findViewById<Button>(R.id.comerciar).setOnClickListener {
            findViewById<Button>(R.id.comerciar).visibility = View.GONE
            findViewById<Button>(R.id.continuar).visibility = View.GONE
            findViewById<Button>(R.id.comprar).visibility = View.VISIBLE
            findViewById<Button>(R.id.vender).visibility = View.VISIBLE
            findViewById<Button>(R.id.cancelar).visibility = View.VISIBLE
        }

        findViewById<Button>(R.id.comprar).setOnClickListener {
            findViewById<ImageView>(R.id.imagenMercader).setImageResource(R.drawable.escalera)
            findViewById<TextView>(R.id.textView).visibility = View.VISIBLE
            findViewById<EditText>(R.id.editText).visibility = View.VISIBLE
            findViewById<TextView>(R.id.textView2).visibility = View.GONE
            findViewById<EditText>(R.id.editText2).visibility = View.GONE
            findViewById<TextView>(R.id.editText2).setText("")
            findViewById<Button>(R.id.aceptar1).visibility = View.VISIBLE
            findViewById<Button>(R.id.aceptar2).visibility = View.GONE
            findViewById<TextView>(R.id.textView).setText("Peso del objeto: " + obj.getPeso())
        }

        findViewById<TextView>(R.id.textView).setText("Peso del objeto: " + obj.getPeso())

        var objetos = mutableListOf<Objeto>()

        findViewById<Button>(R.id.aceptar1).setOnClickListener {
            var pesoObjeto = obj.getPeso()
            var num = findViewById<EditText>(R.id.editText).text.toString().toIntOrNull()

            var pesoTotal = num?.let { pesoObjeto.times(it) }
            var pesoTotal2 = 0
            for (i in 1..objetos.size){
                pesoTotal2 += obj.getPeso()
            }

            if(pesoTotal!! <= personaje1.mochila.getPeso()){
                Toast.makeText(this, "Lo has podido comprar", Toast.LENGTH_SHORT).show()
                for (i in 1..num!!){
                    objetos.add(obj)
                }
                findViewById<TextView>(R.id.editText).setText("")
            } else{
                Toast.makeText(this, "No lo has podido comprar", Toast.LENGTH_SHORT).show()
                findViewById<TextView>(R.id.editText).setText("")
            }
        }

        findViewById<Button>(R.id.vender).setOnClickListener {
            findViewById<ImageView>(R.id.imagenMercader).setImageResource(R.drawable.mochila)
            findViewById<TextView>(R.id.textView).visibility = View.GONE
            findViewById<EditText>(R.id.editText).visibility = View.GONE
            findViewById<TextView>(R.id.textView2).visibility = View.VISIBLE
            findViewById<EditText>(R.id.editText2).visibility = View.VISIBLE
            findViewById<Button>(R.id.aceptar1).visibility = View.GONE
            findViewById<Button>(R.id.aceptar2).visibility = View.VISIBLE
            findViewById<TextView>(R.id.editText).setText("")
            findViewById<TextView>(R.id.textView2).setText("Dispones de " + objetos.count() + " objetos")
            if (objetos.isEmpty()){
                Toast.makeText(this,"No se disponen de objetos", Toast.LENGTH_SHORT).show()
                findViewById<TextView>(R.id.editText2).setText("")
            } else if (!objetos.isEmpty()) {
                findViewById<TextView>(R.id.textView2).setText("Dispones de " + objetos.count() + " objetos")
                findViewById<Button>(R.id.aceptar2).setOnClickListener {

                    if (objetos.count() >= findViewById<EditText>(R.id.editText2).text.toString().toIntOrNull()!!) {
                        for (i in 1..findViewById<EditText>(R.id.editText2).text.toString().toInt()) {
                            objetos.removeFirst()
                            findViewById<TextView>(R.id.textView2).setText("Dispones de " + objetos.count() + " objetos")
                        }
                    } else{
                        Toast.makeText(this,"No puedes vender tantos objetos", Toast.LENGTH_SHORT).show()
                    }
                    findViewById<TextView>(R.id.editText2).setText("")

                }
            }
        }

        findViewById<Button>(R.id.cancelar).setOnClickListener {
            findViewById<Button>(R.id.comerciar).visibility = View.VISIBLE
            findViewById<Button>(R.id.continuar).visibility = View.VISIBLE
            findViewById<Button>(R.id.comprar).visibility = View.GONE
            findViewById<Button>(R.id.vender).visibility = View.GONE
            findViewById<Button>(R.id.cancelar).visibility = View.GONE
            findViewById<ImageView>(R.id.imagenMercader).setImageResource(R.drawable.mercader)
            findViewById<TextView>(R.id.editText).setText("")
            findViewById<TextView>(R.id.editText2).setText("")
            findViewById<TextView>(R.id.textView).visibility = View.GONE
            findViewById<EditText>(R.id.editText).visibility = View.GONE
            findViewById<TextView>(R.id.textView2).visibility = View.GONE
            findViewById<EditText>(R.id.editText2).visibility = View.GONE
            findViewById<Button>(R.id.aceptar1).visibility = View.GONE
            findViewById<Button>(R.id.aceptar2).visibility = View.GONE
        }

    }
}
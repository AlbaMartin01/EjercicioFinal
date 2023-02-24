package com.example.ejerciciofinal

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var fireBase: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener
    private lateinit var serviceIntent: Intent
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fireBase = Firebase.auth
        startService(Intent(this,MyService::class.java))

        findViewById<Button>(R.id.boton).setOnClickListener{
            comprobar(findViewById<EditText>(R.id.usuario).text.toString(),findViewById<EditText>(R.id.contraseña).text.toString())
        }

    }

    private fun comprobar(correo: String, contraseña: String){
        fireBase.signInWithEmailAndPassword(correo,contraseña).addOnCompleteListener(this){ task ->
            if (task.isSuccessful){
                val usuario = fireBase.currentUser
                Toast.makeText(baseContext,findViewById<EditText>(R.id.usuario).text.toString(),
                    Toast.LENGTH_LONG).show()
                var intento = Intent(this,ActividadClases::class.java)
                startActivity(intento)
            } else{
                Toast.makeText(baseContext, "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show()
            }
        }
    }
}
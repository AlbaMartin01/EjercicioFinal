package com.example.ejerciciofinal

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Registro : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val emailUsuario = findViewById<EditText>(R.id.usuario2)
        val password1 = findViewById<EditText>(R.id.contraseña2)
        val password2 = findViewById<EditText>(R.id.confirmarContraseña)

        val botonRegistrarse = findViewById<Button>(R.id.botonRegistro)

        botonRegistrarse.setOnClickListener {
            var pass1 = password1.text.toString()
            var pass2 = password2.text.toString()
            if (pass1.equals(pass2)){
                createAccess(emailUsuario.text.toString(), password1.text.toString())
            }else{
                Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_LONG).show()
                password1.requestFocus()
            }
        }

        auth = Firebase.auth
    }

    private fun createAccess(email:String, password:String){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener (this){task ->
            if (task.isSuccessful){
                Toast.makeText(this, "Cuenta creada",Toast.LENGTH_SHORT).show()
                var intento = Intent(this,ActividadClases::class.java)
                startActivity(intento)
            } else{
                Toast.makeText(this, "Algo salio mal", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
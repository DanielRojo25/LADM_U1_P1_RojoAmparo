package com.example.ladm_u1_p1_menuprincipal_rojoamparo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ladm_u1_p1_menuprincipal_rojoamparo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculadora.setOnClickListener {
            startActivity(Intent(this,MainActivity2::class.java))
        }
        binding.archivos.setOnClickListener {
            startActivity(Intent(this,MainActivity4::class.java))
        }
        binding.lista.setOnClickListener {
            startActivity(Intent(this,MainActivity5::class.java))
        }
        binding.fotos.setOnClickListener {
            startActivity(Intent(this,MainActivity6::class.java))
        }
        binding.acerca.setOnClickListener {
            Toast.makeText(this,"#NoMeRepruebesBenigno",Toast.LENGTH_LONG)
                .show()
            startActivity(Intent(this,MainActivity3::class.java))
        }
    }
}
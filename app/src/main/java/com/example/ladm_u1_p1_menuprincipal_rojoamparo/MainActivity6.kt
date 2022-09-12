package com.example.ladm_u1_p1_menuprincipal_rojoamparo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ladm_u1_p1_menuprincipal_rojoamparo.databinding.ActivityMain6Binding

class MainActivity6 : AppCompatActivity() {
    lateinit var binding: ActivityMain6Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val vector = arrayOf(R.drawable.icono1, R.drawable.icono2, R.drawable.icono3, R.drawable.icono4,
                             R.drawable.icono5, R.drawable.icono6, R.drawable.icono7)

        var indice = 0;

        binding.anterior.setOnClickListener {
            indice--
            if (indice <0) indice = vector.size-1
                binding.imagen.setImageResource(vector[indice])
        }

        binding.siguiente.setOnClickListener {
            indice++
            if (indice == vector.size) indice = 0
            binding.imagen.setImageResource(vector[indice])
        }

        binding.regresar.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}
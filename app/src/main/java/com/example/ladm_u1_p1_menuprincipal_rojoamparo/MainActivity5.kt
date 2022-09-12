package com.example.ladm_u1_p1_menuprincipal_rojoamparo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.ladm_u1_p1_menuprincipal_rojoamparo.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {
    lateinit var binding: ActivityMain5Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listamenu.setOnItemClickListener { adapterView, view, i, l ->
            when(i){
                0 -> {
                    binding.texto.text = "Has presionado la opción 1"
                }

                1 -> {
                    binding.texto.text = "Has presionado la opción 2"
                }

                2 -> {
                    binding.texto.text = "Has presionado la opción 3"
                }

                3 -> {
                    binding.texto.text = "Has presionado la opción 4"
                }

            }
        }
        binding.regresar.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}
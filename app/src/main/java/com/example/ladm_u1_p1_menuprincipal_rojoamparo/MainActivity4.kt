package com.example.ladm_u1_p1_menuprincipal_rojoamparo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.ladm_u1_p1_menuprincipal_rojoamparo.databinding.ActivityMain4Binding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.lang.Exception

class MainActivity4 : AppCompatActivity() {
    lateinit var binding: ActivityMain4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.guardar.setOnClickListener {
            guardarArchivo()
        }
        binding.leer.setOnClickListener {
            leerArchivo()
        }
        binding.regresar.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

    fun guardarArchivo() {
        try{

            if (binding.nombre.text.toString() == "" && binding.carrera.text.toString() == "" && binding.semestre.text.toString()
            == ""){

                AlertDialog.Builder(this)
                    .setTitle("IMPORTANTE")
                    .setMessage("¡Ingresa los datos requeridos")
                    .setPositiveButton("Aceptar"){d,i->}
                    .show()

            }else{


                if (binding.nombre.text.toString() == ""){
                    AlertDialog.Builder(this)
                        .setTitle("IMPORTANTE")
                        .setMessage("¡Ingresa tu nombre")
                        .setPositiveButton("Aceptar"){d,i->}
                        .show()
                }else{

                    if (binding.carrera.text.toString() == ""){
                        AlertDialog.Builder(this)
                            .setTitle("IMPORTANTE")
                            .setMessage("¡Ingresa la carrera")
                            .setPositiveButton("Aceptar"){d,i->}
                            .show()
                    }else{

                        if (binding.semestre.text.toString() == ""){
                            AlertDialog.Builder(this)
                                .setTitle("IMPORTANTE")
                                .setMessage("¡Ingresa el semestre")
                                .setPositiveButton("Aceptar"){d,i->}
                                .show()
                        }

                    }


                }

                var archivo = OutputStreamWriter(openFileOutput("datosAlumno.txt", MODE_PRIVATE))

                var cadena = binding.nombre.text.toString()+"&&"+
                             binding.carrera.text.toString()+"&&"+
                             binding.semestre.text.toString().toInt()

                archivo.write(cadena)
                archivo.flush()
                archivo.close()

                binding.nombre.setText("")
                binding.carrera.setText("")
                binding.semestre.setText("")

                AlertDialog.Builder(this)
                    .setTitle("AVISO")
                    .setMessage("¡Se guardo el archivo!")
                    .setPositiveButton("Aceptar"){d,i->}
                    .show()

            }

        }catch (e:Exception){

            AlertDialog.Builder(this)
                .setMessage(e.message)
                .show()

        }
    }

    fun leerArchivo() {
        try {

            var archivo = BufferedReader(InputStreamReader(openFileInput("datosAlumno.txt")))

            var cadena = archivo.readLine()

            cadena = cadena.replace("&&","\n")

            AlertDialog.Builder(this)
                .setTitle("Datos Leídos")
                .setMessage(cadena)
                .setPositiveButton("Aceptar"){d,i->}
                .show()

        }catch (e:Exception){

            AlertDialog.Builder(this)
                .setMessage(e.message)
                .show()

        }
    }

}
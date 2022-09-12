package com.example.ladm_u1_p1_menuprincipal_rojoamparo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.ladm_u1_p1_menuprincipal_rojoamparo.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcular.setOnClickListener {
            if(binding.num1.text.toString() == "" && binding.num2.text.toString() == ""){
                AlertDialog.Builder(this)
                    .setTitle("IMPORTANTE")
                    .setMessage("¡No has introducido ningun número!")
                    .setPositiveButton("Aceptar"){d,i->}
                    .show()

            }else{
                if (binding.num1.text.toString() == ""){
                    AlertDialog.Builder(this)
                        .setTitle("IMPORTANTE")
                        .setMessage("¡Introduce el primer número!")
                        .setPositiveButton("Aceptar"){d,i->}
                        .show()
                }else{
                    if (binding.num2.text.toString() == ""){
                        AlertDialog.Builder(this)
                            .setTitle("IMPORTANTE")
                            .setMessage("¡Introduce el segundo número!")
                            .setPositiveButton("Aceptar"){d,i->}
                            .show()
                    }else{
                        if (binding.sumar.isChecked == false && binding.restar.isChecked ==false && binding.multiplica.isChecked
                        == false && binding.divide.isChecked == false){

                            AlertDialog.Builder(this)
                                .setTitle("IMPORTANTE")
                                .setMessage("¡No has seleccionado ninguna operación!")
                                .setPositiveButton("Aceptar"){d,i->}
                                .show()

                        }else{

                            if(binding.sumar.isChecked){
                                var suma = binding.num1.text.toString().toInt() + binding.num2.text.toString().toInt()
                                val mensaje = "La suma es: " +suma
                                AlertDialog.Builder(this)
                                    .setTitle("Su resultado")
                                    .setMessage(mensaje)
                                    .setPositiveButton("Acepar"){d,i->}
                                    .show()

                            } else {

                                if (binding.restar.isChecked){
                                    var resta = binding.num1.text.toString().toInt() - binding.num2.text.toString().toInt()
                                    val mensaje = "La resta es: " +resta
                                    AlertDialog.Builder(this)
                                        .setTitle("Su resultado")
                                        .setMessage(mensaje)
                                        .setPositiveButton("Acepar"){d,i->}
                                        .show()
                                } else {

                                    if (binding.multiplica.isChecked){
                                        var mult = binding.num1.text.toString().toInt() * binding.num2.text.toString().toInt()
                                        val mensaje = "La multiplicación es: " +mult
                                        AlertDialog.Builder(this)
                                            .setTitle("Su resultado")
                                            .setMessage(mensaje)
                                            .setPositiveButton("Acepar"){d,i->}
                                            .show()

                                    } else {

                                        if (binding.divide.isChecked){

                                            if (binding.num2.text.toString().toInt()==0){
                                                Toast.makeText(this,"¡Error! ¡No se puede dividir entre CERO! ",Toast.LENGTH_LONG)
                                                    .show()
                                            } else {
                                                var div = binding.num1.text.toString().toDouble() / binding.num2.text.toString().toDouble()
                                                val mensaje = "La división es: " +div
                                                AlertDialog.Builder(this)
                                                    .setTitle("Su resultado")
                                                    .setMessage(mensaje)
                                                    .setPositiveButton("Acepar"){d,i->}
                                                    .show()
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }



        }

        binding.regresar.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}
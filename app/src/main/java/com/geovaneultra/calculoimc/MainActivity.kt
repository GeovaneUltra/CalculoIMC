package com.geovaneultra.calculoimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var button_calcular: Button
    lateinit var editPeso: EditText
    lateinit var editAltura: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        button_calcular = findViewById(R.id.button_calcular)
        editPeso = findViewById(R.id.edit_peso)
        editAltura = findViewById(R.id.edit_altura)

        button_calcular.setOnClickListener {

            val intent = Intent(this, ResultadoActivity::class.java)

            val peso = editPeso.text.toString()
            val altura = editAltura.text.toString()


            if (peso.isNotEmpty() && altura.isNotEmpty()) {

                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura", altura.toDouble())

            }


            fun validarCampos(vPeso: String, vAltura: String): Boolean {
                editPeso.error = null
                editAltura.error = null
                if (peso.isEmpty()) {

                    editPeso.error = "Digite a seu peso"
                    return false
                } else if (altura.isEmpty()) {

                    editAltura.error = "Digite a sua altura"
                    return false
                }
                return true
            }


            startActivity(intent)

        }

    }
}

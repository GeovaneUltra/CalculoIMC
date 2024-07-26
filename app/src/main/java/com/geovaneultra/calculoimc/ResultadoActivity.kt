package com.geovaneultra.calculoimc

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {

    lateinit var  button_voltar: Button
    private lateinit var textPeso: TextView
    private lateinit var textAltura: TextView
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)

        textPeso = findViewById(R.id.text_peso)
        textAltura = findViewById(R.id.text_altura)
        textResultado = findViewById(R.id.text_resultado)
        button_voltar = findViewById(R.id.button_voltar)

        val bundle = intent.extras
        if (bundle != null) {

            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso informado $peso kg"
            textAltura.text = "Altura informada $altura m"

            val imc = peso / (altura * altura)

            textResultado.text = if (imc < 18.5) {
                "IMC baixo."
            } else if (imc in 18.5 .. 24.9) {
                "IMC normal."
            } else if (imc in 25.0 .. 29.9) {
                "IMC em grau de sobrepeso"
            } else {
                "IMC em grau de obesidade"
            }

        }

        button_voltar.setOnClickListener {

            finish()
        }

    }
}

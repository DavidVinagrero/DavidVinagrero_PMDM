package com.example.iniciot2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.roundToInt

class DetailsActivity : AppCompatActivity() {

    private var imcRecuperado: Double = 0.0
    private lateinit var sexoRecuperado: String
    private lateinit var textoIMC: TextView
    private lateinit var textoEstado: TextView
    private lateinit var imagenEstado: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        instancias()
        recuperarDatos()
        iniciar()
    }

    private fun recuperarDatos() {
        imcRecuperado = intent.extras?.getDouble("imc", 0.0) ?: 0.0
        sexoRecuperado = intent.extras?.getString("sexo", "Hombre") ?: "Defecto"
        imcRecuperado = Math.round(imcRecuperado * 100.0) / 100.0
    }

    private fun instancias() {
        textoEstado = findViewById(R.id.texto_estado)
        textoIMC = findViewById(R.id.texto_imc)
        imagenEstado= findViewById(R.id.imagen_resultado)
    }

    private fun iniciar() {
        textoIMC.setText(imcRecuperado.toString())
        textoEstado.setText(calcularEstado(sexoRecuperado).toString())
    }

    private fun calcularEstado(sexoRecuperado: String): Any {
        if (sexoRecuperado.equals("hombre") || sexoRecuperado.equals("Hombre")) {
            if (imcRecuperado < 18.5) {
                imagenEstado.setImageResource(R.drawable.thinking)
                return "Bajo de peso"
            }
            else if (imcRecuperado in 18.5..24.9) {
                imagenEstado.setImageResource(R.drawable.smiling_face)
                return "Peso normal"
            }
            else if (imcRecuperado in 25.0..29.9) {
                imagenEstado.setImageResource(R.drawable.meh)
                return "Sobrepeso"
            }
            else if (imcRecuperado in 30.0..34.9) {
                imagenEstado.setImageResource(R.drawable.emoji)
                return "Obesidad clase I"
            }
            else if (imcRecuperado in 35.0..39.9) {
                imagenEstado.setImageResource(R.drawable.frown)
                return "Obesidad clase II"
            }
            else if (imcRecuperado > 40) {
                imagenEstado.setImageResource(R.drawable.shocked)
                return "Obesidad clase III"
            }
        } else if (sexoRecuperado.equals("Mujer") || sexoRecuperado.equals("mujer")) {
            if (imcRecuperado < 16.5) {
                imagenEstado.setImageResource(R.drawable.thinking)
                return "Baja de peso"
            }
            else if (imcRecuperado in 16.5..22.9) {
                imagenEstado.setImageResource(R.drawable.smiling_face)
                return "Peso normal"
            }
            else if (imcRecuperado in 23.0..25.9) {
                imagenEstado.setImageResource(R.drawable.meh)
                return "Sobrepeso"
            }
            else if (imcRecuperado in 26.0..30.9) {
                imagenEstado.setImageResource(R.drawable.emoji)
                return "Obesidad clase I"
            }
            else if (imcRecuperado in 26.0..30.9) {
                imagenEstado.setImageResource(R.drawable.frown)
                return "Obesidad clase II"
            }
            else if (imcRecuperado > 30.9) {
                imagenEstado.setImageResource(R.drawable.shocked)
                return "Obesidad clase III"
            }
        }
        return ""
    }

}
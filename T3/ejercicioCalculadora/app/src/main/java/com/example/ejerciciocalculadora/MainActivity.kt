package com.example.ejerciciocalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var botonSumar: Button
    lateinit var botonRestar: Button
    lateinit var botonIgual: Button
    lateinit var botonLimpiar: Button
    lateinit var pantallaResultado: TextView

    lateinit var numeroCero: Button
    lateinit var numeroUno: Button
    lateinit var numeroDos: Button
    lateinit var numeroTres: Button
    lateinit var numeroCuatro: Button
    lateinit var numeroCinco: Button
    lateinit var numeroSeis: Button
    lateinit var numeroSiete: Button
    lateinit var numeroOcho: Button
    lateinit var numeroNueve: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        inicio()
    }

    private fun inicio() {
        botonIgual.setOnClickListener(this)
        botonRestar.setOnClickListener(this)
        botonSumar.setOnClickListener(this)
        botonLimpiar.setOnClickListener(this)
        numeroCero.setOnClickListener(this)
        numeroUno.setOnClickListener(this)
        numeroDos.setOnClickListener(this)
        numeroTres.setOnClickListener(this)
        numeroCuatro.setOnClickListener(this)
        numeroCinco.setOnClickListener(this)
        numeroSeis.setOnClickListener(this)
        numeroSiete.setOnClickListener(this)
        numeroOcho.setOnClickListener(this)
        numeroNueve.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        var operando1: ArrayList<Double> = ArrayList()
        var operando2: Double= 0.0
        when (p0!!.id) {
            R.id.limpiar -> {
                pantallaResultado.text = " "
            }

            R.id.numero_uno -> {
                operando1.add(1.0)
                for (d in operando1) {
                    pantallaResultado.setText(""+d.toInt()).toString()
                }
            }

            R.id.numero_cero -> {
                operando1.add(0.0)
                for (d in operando1) {
                    pantallaResultado.setText(""+d.toInt()).toString()
                }
            }
        }
    }

    private fun instancias() {
        this.botonRestar = findViewById(R.id.operacion_restar)
        this.botonSumar = findViewById(R.id.operacion_sumar)
        this.botonIgual = findViewById(R.id.operacion_resultado)
        this.botonLimpiar = findViewById(R.id.limpiar)
        this.pantallaResultado = findViewById(R.id.resultado)

        this.numeroCero = findViewById(R.id.numero_cero)
        this.numeroUno = findViewById(R.id.numero_uno)
        this.numeroDos = findViewById(R.id.numero_dos)
        this.numeroTres = findViewById(R.id.numero_tres)
        this.numeroCuatro = findViewById(R.id.numero_cuatro)
        this.numeroCinco = findViewById(R.id.numero_cinco)
        this.numeroSeis = findViewById(R.id.numero_seis)
        this.numeroSiete = findViewById(R.id.numero_siete)
        this.numeroOcho = findViewById(R.id.numero_ocho)
        this.numeroNueve = findViewById(R.id.numero_nueve)
    }


}

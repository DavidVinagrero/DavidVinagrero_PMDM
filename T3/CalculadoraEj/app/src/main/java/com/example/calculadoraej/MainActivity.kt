package com.example.calculadoraej

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Botones dígitos
    lateinit var botonUno: Button
    lateinit var botonDos: Button
    lateinit var botonTres: Button
    lateinit var botonCuatro: Button
    lateinit var botonCinco: Button
    lateinit var botonSeis: Button
    lateinit var botonSiete: Button
    lateinit var botonOcho: Button
    lateinit var botonNueve: Button
    lateinit var botonCero: Button

    // Botones operaciones
    lateinit var botonIgual: Button
    lateinit var botonSumar: Button
    lateinit var botonRestar: Button
    lateinit var botonDividir: Button
    lateinit var botonMultiplicar: Button
    lateinit var botonLimpiar: Button

    lateinit var etiquetaOperacion: TextView
    lateinit var etiquetaResultado: TextView

    var operando1: Double = 0.0
    var operando2: Double = 0.0
    var operacion: Int = 0
    var resultado: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        acciones()
    }

    private fun acciones() {
        etiquetaOperacion.setText("")
        etiquetaResultado.setText("")

        botonLimpiar.setOnClickListener(this)
        botonUno.setOnClickListener(this)
        botonDos.setOnClickListener(this)
        botonTres.setOnClickListener(this)
        botonCuatro.setOnClickListener(this)
        botonCinco.setOnClickListener(this)
        botonSeis.setOnClickListener(this)
        botonSiete.setOnClickListener(this)
        botonOcho.setOnClickListener(this)
        botonNueve.setOnClickListener(this)
        botonCero.setOnClickListener(this)

        botonSumar.setOnClickListener(this)
        botonRestar.setOnClickListener(this)
        botonDividir.setOnClickListener(this)
        botonMultiplicar.setOnClickListener(this)
        botonIgual.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {

            R.id.boton_uno -> {
                numeroPresionado("1")
            }

            R.id.boton_dos -> {
                numeroPresionado("2")
            }

            R.id.boton_tres -> {
                numeroPresionado("3")
            }
            R.id.boton_cuatro -> {
                numeroPresionado("4")
            }

            R.id.boton_cinco -> {
                numeroPresionado("5")
            }

            R.id.boton_seis -> {
                numeroPresionado("6")
            }

            R.id.boton_siete -> {
                numeroPresionado("7")
            }

            R.id.boton_ocho -> {
                numeroPresionado("8")
            }

            R.id.boton_nueve -> {
                numeroPresionado("9")
            }

            R.id.boton_cero -> {
                numeroPresionado("0")
            }

            R.id.boton_sumar -> {
                operacion = 1
                etiquetaOperacion.text = ""
            }

            R.id.boton_restar -> {
                operacion = 2
                etiquetaOperacion.text = ""
            }

            R.id.boton_dividir -> {
                operacion = 3
                etiquetaOperacion.text = ""
            }

            R.id.boton_multiplicar -> {
                operacion = 4
                etiquetaOperacion.text = ""
            }

            R.id.boton_igual -> {
                if (operacion != 0) {
                    when (operacion) {
                        1 -> {
                            resultado = operando1 + operando2
                            etiquetaOperacion.text = ""
                            etiquetaOperacion.text = "$operando1 + $operando2"
                            etiquetaResultado.text = resultado.toString()
                        }

                        2 -> {
                            resultado = operando1 - operando2
                            etiquetaOperacion.text = ""
                            etiquetaOperacion.text = "$operando1 - $operando2"
                            etiquetaResultado.text = resultado.toString()
                        }

                        3 -> {
                            resultado = operando1 / operando2
                            etiquetaOperacion.text = ""
                            etiquetaOperacion.text = "$operando1 / $operando2"
                            etiquetaResultado.text = resultado.toString()
                        }

                        4 -> {
                            resultado = operando1 * operando2
                            etiquetaOperacion.text = ""
                            etiquetaOperacion.text = "$operando1 x $operando2"
                            etiquetaResultado.text = resultado.toString()
                        }
                    }
                } else {

                }
            }

            R.id.boton_limpiar -> {
                etiquetaOperacion.text = ""
                etiquetaResultado.text = ""
            }
        }
    }

    private fun numeroPresionado(digito: String) {
        etiquetaOperacion.text = "${etiquetaOperacion.text}$digito"
        if (operacion != 0) {
            operando1 = etiquetaOperacion.text.toString().toDouble()
        } else {
            operando2 = etiquetaOperacion.text.toString().toDouble()
        }
    }

    private fun instancias() {
        this.botonCero = findViewById(R.id.boton_cero)
        this.botonUno = findViewById(R.id.boton_uno)
        this.botonDos = findViewById(R.id.boton_dos)
        this.botonTres = findViewById(R.id.boton_tres)
        this.botonCuatro = findViewById(R.id.boton_cuatro)
        this.botonCinco = findViewById(R.id.boton_cinco)
        this.botonSeis = findViewById(R.id.boton_seis)
        this.botonSiete = findViewById(R.id.boton_siete)
        this.botonOcho = findViewById(R.id.boton_ocho)
        this.botonNueve = findViewById(R.id.boton_nueve)

        this.botonSumar = findViewById(R.id.boton_sumar)
        this.botonRestar = findViewById(R.id.boton_restar)
        this.botonDividir = findViewById(R.id.boton_dividir)
        this.botonMultiplicar = findViewById(R.id.boton_multiplicar)
        this.botonLimpiar = findViewById(R.id.boton_limpiar)
        this.botonIgual= findViewById(R.id.boton_igual)

        this.etiquetaResultado = findViewById(R.id.etiqueta_resultado)
        this.etiquetaOperacion = findViewById(R.id.etiqueta_operacion)
    }


}
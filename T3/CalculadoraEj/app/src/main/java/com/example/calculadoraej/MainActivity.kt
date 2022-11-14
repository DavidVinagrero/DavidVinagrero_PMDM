package com.example.calculadoraej

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.calculadoraej.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Variables globales
    private lateinit var binding: ActivityMainBinding
    var aux: String = ""
    var tipoOperacion: Int = 0
    var comaPuesta: Boolean = false
    var operandoUno: Double = 0.0
    var operandoDos: Double = 0.0
    var operacion: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        acciones()
    }

    private fun acciones() {
        // Eliminar el texto de prueba
        binding.etiquetaOperacion.text = ""
        binding.etiquetaResultado.text = ""

        // Botones con signos
        binding.botonSumar.setOnClickListener(this)
        binding.botonRestar.setOnClickListener(this)
        binding.botonMultiplicar.setOnClickListener(this)
        binding.botonDividir.setOnClickListener(this)
        binding.botonComa.setOnClickListener(this)
        binding.botonLimpiar.setOnClickListener(this)
        binding.botonIgual.setOnClickListener(this)
        binding.botonPorcentaje.setOnClickListener(this)

        // Botones con números
        binding.botonCero.setOnClickListener(this)
        binding.botonUno.setOnClickListener(this)
        binding.botonDos.setOnClickListener(this)
        binding.botonTres.setOnClickListener(this)
        binding.botonCuatro.setOnClickListener(this)
        binding.botonCinco.setOnClickListener(this)
        binding.botonSeis.setOnClickListener(this)
        binding.botonSiete.setOnClickListener(this)
        binding.botonOcho.setOnClickListener(this)
        binding.botonNueve.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        // Poner el texto de los botones en la etiquieta
        binding.etiquetaOperacion.append((p0 as Button).text)
        binding.etiquetaResultado.append((p0 as Button).text)

        when (p0!!.id) {

            R.id.boton_limpiar -> {
                binding.etiquetaOperacion.text = ""
                binding.etiquetaResultado.text = ""
                operandoUno = 0.0
                operandoDos = 0.0
            }

            R.id.boton_sumar -> {
                // Operación 1 (sumar)
                tipoOperacion = 1
                operandoUno =
                    binding.etiquetaOperacion.text.toString().replace("+", "").toDouble()
                // Vacía el texto de resultado
                binding.etiquetaResultado.text = ""
            }

            R.id.boton_restar -> {
                tipoOperacion = 2
                operandoUno =
                    binding.etiquetaOperacion.text.toString().replace("-", "").toDouble()
                // Vacía el texto de resultado
                binding.etiquetaResultado.text = ""
            }

            R.id.boton_multiplicar -> {
                tipoOperacion = 3
                operandoUno =
                    binding.etiquetaOperacion.text.toString().replace("x", "").toDouble()
                binding.etiquetaResultado.text = ""
            }

            R.id.boton_dividir -> {
                tipoOperacion = 4
                operandoUno =
                    binding.etiquetaOperacion.text.toString().replace("÷", "").toDouble()
                binding.etiquetaResultado.text = ""
            }

            R.id.boton_porcentaje ->{
                asignarOperandoDos()
            }

            R.id.boton_igual -> {
                if (tipoOperacion != 0) {
                    when (tipoOperacion) {
                        1 -> {
                            asignarOperandoDos()
                            operacion = operandoUno + operandoDos
                            mostrarResultadoYReinicio()
                        }

                        2 -> {
                            asignarOperandoDos()
                            operacion = operandoUno - operandoDos
                            mostrarResultadoYReinicio()
                        }

                        3 -> {
                            asignarOperandoDos()
                            operacion = operandoUno * operandoDos
                            mostrarResultadoYReinicio()
                        }

                        4 -> {
                            asignarOperandoDos()
                            operacion = operandoUno / operandoDos
                            mostrarResultadoYReinicio()
                        }
                    }
                } else {
                    binding.etiquetaOperacion.text = ""
                    binding.etiquetaResultado.text = ""
                }
            }
        }

    }

    private fun mostrarResultadoYReinicio() {
        binding.etiquetaResultado.text =
            ((operacion * 1000.0).roundToInt() / 1000.0).toString()
        reiniciarValores()
    }

    private fun asignarOperandoDos() {
        // Asigna el operando dos a la variable
        operandoDos =
            binding.etiquetaResultado.text.toString().replace("=", "")
                .toDouble()
    }

    private fun reiniciarValores() {
        operacion = 0.0
        operandoUno = 0.0
        operandoDos = 0.0
        tipoOperacion = 0
    }
}

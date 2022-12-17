package com.example.calculadoraej

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.calculadoraej.databinding.ActivityMainBinding
import kotlin.math.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Variables globales
    private lateinit var binding: ActivityMainBinding
    var aux: String = ""
    var tipoOperacion: Int = 0
    var tipoPorcentaje: Int = 0
    var comaPuesta: Boolean = false
    var operandoUno: Double = 0.0
    var operandoDos: Double = 0.0
    var resultado: Double = 0.0
    var porcentaje: Double = 0.0
    var potencia: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        acciones()

            if (resources.configuration.orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {

            } else if (resources.configuration.orientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {

            }
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

        binding.botonPi?.setOnClickListener(this)
        binding.botonRaizCuadrada?.setOnClickListener(this)
        binding.botonE?.setOnClickListener(this)
        binding.botonInvertir?.setOnClickListener(this)
        binding.botonElevar?.setOnClickListener(this)
        binding.botonLogaritmo?.setOnClickListener(this)
        binding.botonIn?.setOnClickListener(this)
        binding.botonSin?.setOnClickListener(this)
        binding.botonCos?.setOnClickListener(this)
        binding.botonTan?.setOnClickListener(this)

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

            R.id.boton_raizCuadrada -> {
                tipoOperacion = 6
            }

            R.id.boton_elevar -> {
                tipoOperacion = 7
                operandoUno =
                    binding.etiquetaOperacion.text.toString().replace("^", "").toDouble()
                binding.etiquetaResultado.text = ""
            }

            R.id.boton_porcentaje -> {
                // Asigna a la variable el contenido de la etiqueta
                operandoDos =
                    binding.etiquetaResultado.text.toString().replace("%", "")
                        .toDouble()
                // calcula el porcentaje para su posterior uso
                porcentaje = (operandoDos * 100) / operandoUno

                when (tipoOperacion) {
                    // operandoDos aumento del operandoUno
                    1 -> {
                        tipoPorcentaje = 1
                        resultado = porcentaje
                        binding.etiquetaResultado.text =
                            ((resultado * 1000.0).roundToInt() / 1000.0).toString()
                    }

                    // operandoDos "descuento" del operandoUno
                    2 -> {
                        tipoPorcentaje = 2
                        resultado = porcentaje
                        binding.etiquetaResultado.text =
                            ((resultado * 1000.0).roundToInt() / 1000.0).toString()
                    }

                    // operandoDos porcentaje de operandoUno
                    // Porcentaje = (Puntaje obtenido x 100) / Puntaje total
                    3 -> {
                        resultado = porcentaje
                        binding.etiquetaResultado.text =
                            ((resultado * 1000.0).roundToInt() / 1000.0).toString()
                        // Como este soo muestra el porcentaje se pueden reiniciar los valores
                        mostrarResultadoYReinicio()
                    }
                }
                tipoOperacion = 5
            }

            R.id.boton_igual -> {
                when (tipoOperacion) {
                    1 -> {
                        asignarOperandoDos()
                        resultado = operandoUno + operandoDos
                        mostrarResultadoYReinicio()
                    }

                    2 -> {
                        asignarOperandoDos()
                        resultado = operandoUno - operandoDos
                        mostrarResultadoYReinicio()
                    }

                    3 -> {
                        asignarOperandoDos()
                        resultado = operandoUno * operandoDos
                        mostrarResultadoYReinicio()
                    }

                    4 -> {
                        asignarOperandoDos()
                        resultado = operandoUno / operandoDos
                        mostrarResultadoYReinicio()
                    }

                    5 -> {
                        when (tipoPorcentaje) {
                            1 -> {
                                resultado += operandoUno
                                mostrarResultadoYReinicio()
                            }

                            2 -> {
                                operandoUno -= resultado
                                resultado = operandoUno
                                mostrarResultadoYReinicio()
                            }
                        }
                    }

                    6 -> {
                        operandoUno = binding.etiquetaResultado.text.toString().replace("√", "")
                            .replace("=", "").toDouble()

                        resultado = sqrt(operandoUno)
                        mostrarResultadoYReinicio()
                    }

                    7 -> {
                        asignarOperandoDos()
                        resultado = Math.pow(operandoUno, operandoDos)
                        mostrarResultadoYReinicio()
                    }
                }
            }

            R.id.boton_pi -> {
                binding.etiquetaResultado.append("3.14159")
                binding.etiquetaOperacion.text = 3.14159.toString()
            }

            R.id.boton_e -> {
                binding.etiquetaResultado.append("2.71828")
                binding.etiquetaOperacion.text = 2.71828.toString()
            }

            R.id.boton_invertir -> {
               var cambiarSigno1: Double = 0.0
               cambiarSigno1 = binding.etiquetaOperacion.text.toString().replace("+/-", "").toDouble()
               if (cambiarSigno1 > 0){
                   binding.etiquetaOperacion.text = (cambiarSigno1 * -1).toString()
                   binding.etiquetaResultado.text = (cambiarSigno1 * -1).toString()
               }
            }

            R.id.boton_logaritmo -> {
                operandoUno = binding.etiquetaOperacion.text.toString().replace("log", "").toDouble()
                binding.etiquetaOperacion.text = "Log("+operandoUno+")"
                binding.etiquetaResultado.text = log10(operandoUno).toString()
            }

            R.id.boton_in -> {
                operandoUno = binding.etiquetaOperacion.text.toString().replace("in","").toDouble()
                binding.etiquetaOperacion.text = "In("+operandoUno+")"
                binding.etiquetaResultado.text = (ln(operandoUno)).toString()
            }

            R.id.boton_sin -> {
                operandoUno = binding.etiquetaOperacion.text.toString().replace("sin","").toDouble()
                binding.etiquetaOperacion.text = "sin("+operandoUno+")"
                binding.etiquetaResultado.text = (sin(operandoUno)).toString()
            }

            R.id.boton_cos -> {
                operandoUno = binding.etiquetaOperacion.text.toString().replace("cos","").toDouble()
                binding.etiquetaOperacion.text = "cos("+operandoUno+")"
                binding.etiquetaResultado.text = (cos(operandoUno)).toString()
            }

            R.id.boton_tan -> {
                operandoUno = binding.etiquetaOperacion.text.toString().replace("tan","").toDouble()
                binding.etiquetaOperacion.text = "tan("+operandoUno+")"
                binding.etiquetaResultado.text = (tan(operandoUno)).toString()
            }


        }

    }

    private fun mostrarResultadoYReinicio() {
        binding.etiquetaResultado.text =
            ((resultado * 1000.0).roundToInt() / 1000.0).toString()
        reiniciarValores()
    }

    private fun asignarOperandoDos() {
        // Asigna el operando dos a la variable
        operandoDos =
            binding.etiquetaResultado.text.toString().replace("=", "")
                .toDouble()
    }

    private fun reiniciarValores() {
        resultado = 0.0
        operandoUno = 0.0
        operandoDos = 0.0
        tipoOperacion = 0
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("resultado", binding.etiquetaResultado.text.toString())
        outState.putString("operacion", binding.etiquetaOperacion.text.toString())

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        binding.etiquetaResultado.text = savedInstanceState.getString("resultado")
        binding.etiquetaOperacion.text = savedInstanceState.getString("operacion")

    }
}

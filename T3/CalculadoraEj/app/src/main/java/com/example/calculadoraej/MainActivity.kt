package com.example.calculadoraej

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import com.example.calculadoraej.databinding.ActivityMainBinding
import kotlin.math.roundToInt
import kotlin.math.sqrt

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

        outState.putString("resultado", binding.etiquetaOperacion.text.toString())
        outState.putString("operacion", binding.etiquetaOperacion.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        binding.etiquetaResultado.text = savedInstanceState.getString("resultado")
        binding.etiquetaOperacion.text = savedInstanceState.getString("operacion")

    }
}

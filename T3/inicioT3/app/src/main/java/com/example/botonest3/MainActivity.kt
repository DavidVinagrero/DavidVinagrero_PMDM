package com.example.botonest3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    lateinit var botonPulsar: Button
    lateinit var grupoRadios: RadioGroup
    lateinit var radioUno: RadioButton
    lateinit var radioDos: RadioButton
    lateinit var radioTres: RadioButton
    lateinit var toggleEstado: ToggleButton
    lateinit var checkEstado: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        acciones()
    }

    private fun acciones() {
        toggleEstado.setOnClickListener(this)
        botonPulsar.setOnClickListener(this)
        grupoRadios.setOnCheckedChangeListener { grupoRadios, i ->
            var radioSeleccionado: RadioButton = findViewById(i)
            Snackbar.make(grupoRadios, radioSeleccionado.text, Snackbar.LENGTH_SHORT).show()
        }
        toggleEstado.setOnCheckedChangeListener(this)
    }

    private fun instancias() {
        this.botonPulsar = findViewById(R.id.boton_pulsar)
        this.grupoRadios = findViewById(R.id.grupo_radios)
        this.radioUno = findViewById(R.id.radio_1)
        this.radioDos = findViewById(R.id.radio_2)
        this.radioTres = findViewById(R.id.radio_3)
        this.toggleEstado = findViewById(R.id.toggle_estado)
        this.checkEstado= findViewById(R.id.check_estado)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.toggle_estado -> {
                Snackbar.make(p0, "Toggle pulsado", Snackbar.LENGTH_SHORT).show()
            }
            R.id.boton_pulsar -> {
                //toggleEstado.isChecked = !toggleEstado.isChecked
                checkEstado.isChecked= !checkEstado.isChecked
                // Snackbar.make(p0, toggleEstado.isChecked.toString(), Snackbar.LENGTH_SHORT).show()
                /* // Obtener el radio seleccionado
                lateinit var radioSeleccionado: RadioButton
                // INT --> id ----> View
                radioSeleccionado = findViewById(grupoRadios.checkedRadioButtonId)
                if (grupoRadios.checkedRadioButtonId >= 0) {
                    Snackbar.make(p0, radioSeleccionado.text, Snackbar.LENGTH_SHORT).show()

                    when (radioSeleccionado.id) {
                        R.id.radio_1 -> {}
                        R.id.radio_2 -> {}
                        R.id.radio_3 -> {}
                    }
                }*/
            }

            R.id.toggle_estado -> {

            }
        }
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        when(p0!!.id){
            R.id.toggle_estado->{
                radioUno.isEnabled= p1
                radioDos.isEnabled= p1
                radioTres.isEnabled= p1
            }

            R.id.check_estado->{
                toggleEstado.isChecked= p1
            }
        }
    }
}
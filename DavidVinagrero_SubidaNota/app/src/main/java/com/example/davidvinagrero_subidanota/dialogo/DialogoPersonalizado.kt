package com.example.davidvinagrero_subidanota.dialogo

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.core.view.get
import androidx.fragment.app.DialogFragment
import com.example.davidvinagrero_subidanota.R
import com.google.android.material.snackbar.Snackbar


class DialogoPersonalizado : DialogFragment(), AdapterView.OnItemSelectedListener {

    lateinit var vista: View
    lateinit var spinner1: Spinner
    lateinit var spinner2: Spinner
    lateinit var textoCantidad: EditText
    lateinit var botonCambio: Button
    private lateinit var listener: OnDialogoPersonalizadoListener
    private lateinit var contexto: Context
    var moneda1: String = ""
    var moneda2: String = ""

    // Contenido de los spinners
    private var listaDatos: ArrayList<String> = ArrayList()

    override fun onStart() {
        super.onStart()
        textoCantidad = vista.findViewById(R.id.texto_dinero)
        botonCambio = vista.findViewById(R.id.boton_cambiar)
    }

    override fun onResume() {
        super.onResume()
        botonCambio.setOnClickListener {
            if (textoCantidad.text.isEmpty()) {
                var notification =
                    Snackbar.make(it, "Tienes que poner una cantidad", Snackbar.LENGTH_INDEFINITE)
                notification.setAction("OK") {}
                notification.show()
            } else {
                Log.v(
                    "datosPasar",
                    "\nMoneda 1-> " + moneda1 + "\nMoneda 2-> " + moneda2 + "\nCantidad-> " + textoCantidad.text.toString()
                )

                listener.onDialogoPersonalizadoSet(moneda1, moneda2, textoCantidad.text.toString().toInt())
            }
        }
        spinner1.onItemSelectedListener = this
        spinner2.onItemSelectedListener = this
    }

    override fun onAttach(context: Context) {
        //instancias()
        super.onAttach(context)
        this.contexto = context
        this.listener = context as OnDialogoPersonalizadoListener
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_view, null);

        val adapter = ArrayAdapter.createFromResource(
            context,
            R.array.divisas,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1 = vista.findViewById(R.id.spiner_cantidad1)
        spinner2 = vista.findViewById(R.id.spiner_cantidad2)
        spinner1.adapter = adapter
        spinner2.adapter = adapter
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireContext())
        builder.setView(vista)

        return builder.create()
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when(p0!!.id){
            spinner2.id -> {
                moneda2 = spinner2.getItemAtPosition(p2).toString()
            }
            spinner1.id -> {
                moneda1 = spinner1.getItemAtPosition(p2).toString()
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    interface OnDialogoPersonalizadoListener {
        fun onDialogoPersonalizadoSet(moneda1: String, moneda2:String, cantidad:Int)
    }
}



package com.example.t6_examen_2.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import androidx.fragment.app.DialogFragment
import com.example.t6_examen_2.R
import com.example.t6_examen_2.model.Juego

class DialogoFiltro : DialogFragment() {
    private lateinit var vista: View

    private lateinit var checkPS5: CheckBox
    private lateinit var checkPS4: CheckBox
    private lateinit var checkXBOX: CheckBox
    private lateinit var checkPC: CheckBox
    private lateinit var botonAplicar: Button
    private lateinit var listener: OnRecyclerJuegosListener

    override fun onStart() {
        super.onStart()
        checkPS5 = vista.findViewById(R.id.check_ps5)
        checkXBOX = vista.findViewById(R.id.check_xbox)
        checkPS4 = vista.findViewById(R.id.check_ps4)
        checkPC = vista.findViewById(R.id.check_pc)
        botonAplicar = vista.findViewById(R.id.boton_aplicar)
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        builder.setView(vista)
        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnRecyclerJuegosListener
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_filtrar,null)
    }

    interface OnRecyclerJuegosListener {
        fun juegoSelected(juego: Juego)
    }
}

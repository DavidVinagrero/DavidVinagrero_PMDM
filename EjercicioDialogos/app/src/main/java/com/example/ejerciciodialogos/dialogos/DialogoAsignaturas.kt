package com.example.ejerciciodialogos.dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import androidx.fragment.app.DialogFragment
import com.example.ejerciciodialogos.R

class DialogoAsignaturas : DialogFragment() {
    private lateinit var checkPMDM: CheckBox
    private lateinit var checkDI: CheckBox
    private lateinit var checkAD: CheckBox
    private lateinit var checkSGE: CheckBox
    private lateinit var checkEIE: CheckBox
    private lateinit var checkING: CheckBox
    private lateinit var botonAceptar: Button
    private lateinit var vista: View
    private lateinit var listener: OnAsignaturasSelected

    private var marcados: String = ""


    interface OnAsignaturasSelected {
        fun onDialogoAsignaturasSelected(asignaturas: String)
    }


    override fun onStart() {
        super.onStart()
        botonAceptar = vista.findViewById(R.id.boton_asingaturas)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_asignautras, null)
        listener = context as OnAsignaturasSelected
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireContext())
        builder.setView(vista)
        checkPMDM = vista.findViewById(R.id.check_pmdm)
        checkDI = vista.findViewById(R.id.check_di)
        checkAD = vista.findViewById(R.id.check_ad)
        checkSGE = vista.findViewById(R.id.check_sge)
        checkEIE = vista.findViewById(R.id.check_eie)
        checkING = vista.findViewById(R.id.check_ing)

        checkPMDM.setOnClickListener { marcados += "PMDM " }
        checkDI.setOnClickListener { marcados += "DI " }
        checkAD.setOnClickListener { marcados += "AD " }
        checkSGE.setOnClickListener { marcados += "SGE " }
        checkEIE.setOnClickListener { marcados += "EIE " }
        checkING.setOnClickListener { marcados += "ING " }
        return builder.create()
    }

    override fun onResume() {
        super.onResume()
        botonAceptar.setOnClickListener {
            // Log.v("asignaturas_marcadas", "Se han marcado: $marcados")
            listener.onDialogoAsignaturasSelected(marcados)
            dismiss()
        }
    }
}

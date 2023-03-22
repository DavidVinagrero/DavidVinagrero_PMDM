package com.example.t8_sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t8_sqlite.database.DatabaseAlumnos
import com.example.t8_sqlite.model.Alumno
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            val database = DatabaseAlumnos.getInstance(applicationContext)
            database.alumnoDAO()
                .insertarAlumno(Alumno("Davi", "Vinagrero", 20, "correo@eamil.com"))
        }
    }
}
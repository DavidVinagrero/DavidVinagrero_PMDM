package com.example.t8_registro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t8_registro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
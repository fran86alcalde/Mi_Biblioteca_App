package com.example.mibibliotecaapp.presentationdomain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mibibliotecaapp.Interfaces.Exit
import com.example.mibibliotecaapp.R


lateinit var boton_salir: Button
lateinit var botonFav: Button
lateinit var botonLeidos: Button
lateinit var botonPorLeer: Button



class MainActivity : AppCompatActivity(), Exit {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_MiBibliotecaApp)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton_salir =findViewById(R.id.button_salir)
        botonFav =findViewById(R.id.button_Fav)
        botonLeidos =findViewById(R.id.button_Leidos)
        botonPorLeer =findViewById(R.id.button_Por_Leer)

        boton_salir.setOnClickListener{exitProgram()}

        botonFav.setOnClickListener{
            val favoritosIntent=Intent(this, favoritos::class.java)
            startActivity(favoritosIntent)
        }

        botonLeidos.setOnClickListener{
            val LeidosIntent=Intent(this, leidos::class.java)
            startActivity(LeidosIntent)
        }

        botonPorLeer.setOnClickListener{
            val PorLeerIntent=Intent(this, PorLeer::class.java)
            startActivity(PorLeerIntent)
        }





    }

}
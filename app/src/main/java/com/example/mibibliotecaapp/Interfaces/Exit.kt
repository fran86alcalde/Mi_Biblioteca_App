package com.example.mibibliotecaapp.Interfaces

import kotlin.system.exitProcess

interface Exit {
    fun exitProgram(){
        exitProcess(0)
    }
}
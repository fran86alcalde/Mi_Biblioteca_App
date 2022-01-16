package com.example.mibibliotecaapp.ui

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.mibibliotecaapp.ui.bbddStructureFavoritos.BbddStructureFavoritos.SQL_CREATE_ENTRIES_FAV
import com.example.mibibliotecaapp.ui.bbddStructureFavoritos.BbddStructureFavoritos.SQL_DELETE_ENTRIES_FAV
import com.example.mibibliotecaapp.ui.bbddStructurePorLeer.BbddStructurePorLeer.SQL_CREATE_ENTRIES_POR_LEER
import com.example.mibibliotecaapp.ui.bbddStructureLeidos.BbddStructureLeidos.SQL_CREATE_ENTRIES_LEIDOS
import com.example.mibibliotecaapp.ui.bbddStructureLeidos.BbddStructureLeidos.SQL_DELETE_ENTRIES_LEIDOS
import com.example.mibibliotecaapp.ui.bbddStructurePorLeer.BbddStructurePorLeer.SQL_DELETE_ENTRIES_POR_LEER

class bbddHelper(context:Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {


companion object{
    const val DATABASE_NAME="bbddLibros.db"
    const val DATABASE_VERSION=2
}

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES_FAV)

        //Crear un if si la tabla está vacía
        db?.execSQL(SQL_CREATE_ENTRIES_POR_LEER)
        //Crear un if si la tabla está vacía
        db?.execSQL(SQL_CREATE_ENTRIES_LEIDOS)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_ENTRIES_FAV)
        //Crear un if si la tabla está vacía
        db?.execSQL(SQL_DELETE_ENTRIES_LEIDOS)
        //Crear un if si la tabla está vacía
        db?.execSQL(SQL_DELETE_ENTRIES_POR_LEER)
        onCreate(db)
    }

}
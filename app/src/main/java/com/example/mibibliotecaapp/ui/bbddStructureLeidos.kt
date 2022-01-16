package com.example.mibibliotecaapp.ui

import android.provider.BaseColumns

class bbddStructureLeidos {

    object BbddStructureLeidos: BaseColumns {
        const val TABLE_NAME = "Leidos"
        const val NOMBRE_COLUMNA1 = "Titulo"
        const val NOMBRE_COLUMNA2 = "Puntuacion"


        const val SQL_CREATE_ENTRIES_LEIDOS =
            "CREATE TABLE ${BbddStructureLeidos.TABLE_NAME} (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "${BbddStructureLeidos.NOMBRE_COLUMNA1} TEXT," +
                    "${BbddStructureLeidos.NOMBRE_COLUMNA2} TEXT)"

        const val SQL_DELETE_ENTRIES_LEIDOS = "DROP TABLE IF EXISTS ${BbddStructureLeidos.TABLE_NAME}"

    }
}
package com.example.mibibliotecaapp.ui

import android.provider.BaseColumns

class bbddStructurePorLeer {
    object BbddStructurePorLeer: BaseColumns {
        const val TABLE_NAME = "PorLeer"
        const val NOMBRE_COLUMNA1 = "Titulo"



        const val SQL_CREATE_ENTRIES_POR_LEER =
            "CREATE TABLE ${BbddStructurePorLeer.TABLE_NAME} (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "${BbddStructurePorLeer.NOMBRE_COLUMNA1} TEXT)"

        const val SQL_DELETE_ENTRIES_POR_LEER = "DROP TABLE IF EXISTS ${BbddStructurePorLeer.TABLE_NAME}"

    }
}
package com.example.mibibliotecaapp.ui

import android.provider.BaseColumns

class bbddStructureFavoritos {

    object BbddStructureFavoritos: BaseColumns {
        const val TABLE_NAME = "favoritos"
        const val NOMBRE_COLUMNA1 = "Titulo"



        const val SQL_CREATE_ENTRIES_FAV =
            "CREATE TABLE ${BbddStructureFavoritos.TABLE_NAME} (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "${BbddStructureFavoritos.NOMBRE_COLUMNA1} TEXT)"

        const val SQL_DELETE_ENTRIES_FAV = "DROP TABLE IF EXISTS ${BbddStructureFavoritos.TABLE_NAME}"

}}
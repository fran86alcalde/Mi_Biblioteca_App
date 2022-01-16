package com.example.mibibliotecaapp.presentationdomain

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.ScrollView
import com.example.mibibliotecaapp.R
import com.example.mibibliotecaapp.ui.bbddHelper
import com.example.mibibliotecaapp.ui.bbddStructureFavoritos
import com.example.mibibliotecaapp.ui.bbddStructureFavoritos.BbddStructureFavoritos.NOMBRE_COLUMNA1
import com.example.mibibliotecaapp.ui.bbddStructureFavoritos.BbddStructureFavoritos.TABLE_NAME
import kotlin.reflect.typeOf

class favoritos : AppCompatActivity() {

    lateinit var editTextFavoritos:EditText
    lateinit var scrollFavoritos:ScrollView
    lateinit var ListaFavoritos:ListView
    lateinit var db: SQLiteDatabase
    lateinit var proyection:Array<String>
    lateinit var arrayAdapter:ArrayAdapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)
        //variables reflejadas por Id
        editTextFavoritos=findViewById(R.id.editTextFavoritos)
        scrollFavoritos=findViewById(R.id.scrollFavoritos)
        ListaFavoritos=findViewById((R.id.ListaFavoritos))

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        //ahora vamos a consultar la tabla para visulizar los datos en el scrollview

        val helper=bbddHelper(this)
        db=helper.readableDatabase
        proyection= arrayOf(NOMBRE_COLUMNA1)//+nombre columna2

        readBBDD()


    }//Fin de OnCreate


    //poner este nombre en el OnClick del XML
    fun insertDataTable(view:View){
       val helper=bbddHelper(this)
        val db=helper.writableDatabase
        //a continuacion a se introducen los datos de la tabla
        val values=ContentValues().apply {
            put(bbddStructureFavoritos.BbddStructureFavoritos.NOMBRE_COLUMNA1,editTextFavoritos.text.toString())
        }
        val newRowId=db?.insert(bbddStructureFavoritos.BbddStructureFavoritos.TABLE_NAME,null,values)

        readBBDD()
    }

    //Método para leer datos de la BBDD
    private fun readBBDD(){
        val cursor=db.query(
            TABLE_NAME,
            proyection,
            null,//probar con el * sino
            null,
            null,
            null,
            null
        )

        var contador=0
        val itemsId= mutableListOf<String>()//en vez de string,
        with(cursor){
            while (moveToNext()){
                itemsId.add(cursor.getString(0))
            }
        }

        arrayAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,itemsId)

        ListaFavoritos.adapter=arrayAdapter
    }



}
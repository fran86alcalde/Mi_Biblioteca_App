package com.example.mibibliotecaapp.presentationdomain

import android.content.ContentValues
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
import com.example.mibibliotecaapp.ui.bbddStructureLeidos

class leidos : AppCompatActivity() {

    lateinit var editTextLeidos: EditText
    lateinit var editTextLeidosPunt:EditText
    lateinit var scrollLeidos: ScrollView
    lateinit var ListaLeidos: ListView
    lateinit var db: SQLiteDatabase
    lateinit var proyection:Array<String>
    lateinit var arrayAdapter: ArrayAdapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leidos)

        editTextLeidos=findViewById(R.id.editTextLeidos)
        editTextLeidosPunt=findViewById(R.id.editTextLeidosPunt)
        scrollLeidos=findViewById(R.id.scrollLeidos)
        ListaLeidos=findViewById((R.id.ListaLeidos))

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        val helper=bbddHelper(this)
        db=helper.readableDatabase
        proyection= arrayOf(bbddStructureLeidos.BbddStructureLeidos.NOMBRE_COLUMNA1,
                            bbddStructureLeidos.BbddStructureLeidos.NOMBRE_COLUMNA2)//+nombre columna2

        readBBDD()
    }

    fun insertDataTable2(view: View){
        val helper= bbddHelper(this)
        val db=helper.writableDatabase
        //a continuacion se introducen los datos de la tabla
        val values= ContentValues().apply {
            put(bbddStructureLeidos.BbddStructureLeidos.NOMBRE_COLUMNA1,editTextLeidos.text.toString())
            put(bbddStructureLeidos.BbddStructureLeidos.NOMBRE_COLUMNA2,editTextLeidosPunt.text.toString())
        }
        val newRowId=db?.insert(bbddStructureLeidos.BbddStructureLeidos.TABLE_NAME,null,values)

        readBBDD()
    }

    private fun readBBDD(){
        val cursor=db.query(
            bbddStructureLeidos.BbddStructureLeidos.TABLE_NAME,
            proyection,
            null,//probar con el * sino
            null,
            null,
            null,
            null
        )

        val itemsId= mutableListOf<String>()//en vez de string,
        with(cursor){
            while (moveToNext()){
                itemsId.add("Título: "+cursor.getString(0)+".\n Puntuación: "+cursor.getString(1))
            }
        }

        arrayAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,itemsId)

        ListaLeidos.adapter=arrayAdapter
    }
}
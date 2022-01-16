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
import com.example.mibibliotecaapp.ui.bbddStructureFavoritos
import com.example.mibibliotecaapp.ui.bbddStructurePorLeer
import com.example.mibibliotecaapp.ui.bbddStructurePorLeer.BbddStructurePorLeer.NOMBRE_COLUMNA1
import com.example.mibibliotecaapp.ui.bbddStructurePorLeer.BbddStructurePorLeer.TABLE_NAME

class PorLeer : AppCompatActivity() {

    lateinit var editTextPorLeer: EditText
    lateinit var scrollPorLeer: ScrollView
    lateinit var ListaPorLeer: ListView
    lateinit var db: SQLiteDatabase
    lateinit var proyection:Array<String>
    lateinit var arrayAdapter: ArrayAdapter<*>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_por_leer)

        editTextPorLeer=findViewById(R.id.editTextPorLeer)
        scrollPorLeer=findViewById(R.id.scrollPorLeer)
        ListaPorLeer=findViewById((R.id.ListaPorLeer))

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        val helper=bbddHelper(this)
        db=helper.readableDatabase
        proyection= arrayOf(bbddStructurePorLeer.BbddStructurePorLeer.NOMBRE_COLUMNA1)

        readBBDD()
    }
    //poner este nombre en el OnClick del XML
    fun insertDataTable(view: View){
        val helper= bbddHelper(this)
        val db=helper.writableDatabase
        //a continuacion se introducen los datos de la tabla
        val values= ContentValues().apply {
            put(bbddStructurePorLeer.BbddStructurePorLeer.NOMBRE_COLUMNA1,editTextPorLeer.text.toString())
        }
        val newRowId=db?.insert(TABLE_NAME,null,values)

        readBBDD()
    }

    private fun readBBDD(){
        val cursor=db.query(
            bbddStructurePorLeer.BbddStructurePorLeer.TABLE_NAME,
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

        ListaPorLeer.adapter=arrayAdapter
    }


}
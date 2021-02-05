package com.example.miprimeraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miprimeraapp.TaskApplication.Companion.prefs

class MainActivity : AppCompatActivity() {

    // lateinit var example: String
    // Button porque la etiqueta de añadir tarea es Button
    lateinit var btnAddTask:Button
    lateinit var btnOrderTasks:Button
    lateinit var etTask:EditText
    var isOrderDescending: Boolean = true
    // El recyclerView se va a usar para las listas de tareas
    lateinit var rvTasks:RecyclerView
    lateinit var adapter:TaskAdapter
    var tasks = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
        //test("Pablo")
    }

    private fun initUi() {
        initView()
        // El listener va después de initView, cuando está
        // instanciado to do
        initListeners()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        // Configura el RecyclerView y le añade el adapter
        tasks = prefs.getTasks()
        rvTasks.layoutManager = LinearLayoutManager(this)
        adapter = TaskAdapter(tasks) {deleteTask(it)}
        rvTasks.adapter = adapter
    }

    private fun deleteTask(position: Int) {
        tasks.removeAt(position)
        adapter.notifyDataSetChanged()
        prefs.saveTasks(tasks)
    }

    // Los listener son los encargados de decirle a la clase
    // que alguien ha pulsado un botón, y que haga algo
    private fun initListeners() {

        btnAddTask.setOnClickListener{
            addTask()
        }

        btnOrderTasks.setOnClickListener {
            orderTasks()
        }
    }

    private fun addTask() {
        val taskToAdd:String = etTask.text.toString()
        
        if ((taskToAdd.length > 0 && taskToAdd.length <= 28)) {
            tasks.add(taskToAdd)
            adapter.notifyDataSetChanged()
            etTask.setText("")
            prefs.saveTasks(tasks)
        } else {
            etTask.setText("")
        }
    }

    private fun orderTasks() {

        if (isOrderDescending) {
            tasks.sort()
            isOrderDescending = false
        }
        else {
            tasks.sortDescending()
            isOrderDescending = true
        }
        adapter.notifyDataSetChanged()
    }

    private fun initView() {
        // Conectamos las vistas
        btnAddTask = findViewById(R.id.btnAddTask)
        btnOrderTasks = findViewById(R.id.btnOrderTask)
        etTask = findViewById(R.id.etTask)
        rvTasks = findViewById(R.id.rvTasks)
    }

    // -----------------------------------------------------
    /*fun test() {
        // val nombre:Boolean = true
        // val sería un valor constante
        val example:String = "Hola"
        var example2:String = "Hola"
        example2 = "Hola2"
    }*/

    // ------------------------------------------------------

    /*fun test(name:String = "desconocido"):String {
        // Le doy un valor por defecto
        // Devuelve un string

        return "Hola $name"
    }*/

    // --> Simplificamos la función de arriba
    // fun test(name:String = "desconocido") = "Hola $name"

    // ------------------------------------------------------

    /*  fun test(name: String = "desconocido") {

          // Listas mutables y no mutables

          val list: List<String> = listOf("val1", "val2")
          val list2: MutableList<String> = mutableListOf("val1", "val2")
          list2.add("val3")
      }*/

    // ------------------------------------------------------

    /*fun test(name: String = "desconocido") {

        example = name
    }*/

    // ------------------------------------------------------
    // --> NULABILIDAD

    /*var name:String? = null
    // La ? indica que puede ser de tipo string, pero todavia no tiene información

    fun test():Int {
        return name?.length ?:4
        // Si name No es nulo, dame la longitud
        // Operador elvis --> si no funciona la primera parte, devuelvo 4

        // --> Hay otra opción, poner exclamación. Pero para eso debemos
        // estar seguros de que name tiene un valor:

        // return name!!.length

        // Con !! aseguramos que name no es nulo, pero si lo es, la aplicación peta
    }*/

}
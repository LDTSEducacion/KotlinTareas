package com.example.miprimeraapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_readfirebase.*

class ReadFirebaseActivity: AppCompatActivity() {

    // FIREBASE
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_readfirebase)

        database = FirebaseDatabase.getInstance()
        reference = database.getReference("Tareas")

        getTasks()
    }

    private fun getTasks() {

        reference.addValueEventListener(object :ValueEventListener
        {
            override fun onCancelled(error: DatabaseError) {

                Log.e("cancel", error.toString())
            }

            override fun onDataChange(snapshot: DataSnapshot) {

                var list = ArrayList<TaskFirebaseModel>()

                for (data in snapshot.children) {

                    val model = data.getValue(TaskFirebaseModel::class.java)
                    list.add(model as TaskFirebaseModel)
                }

                if (list.size > 0) {

                    val adapter = FirebaseAdapter(list)
                    recyclerview.adapter = adapter
                }

            }
        })
    }
}
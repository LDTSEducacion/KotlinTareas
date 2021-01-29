package com.example.miprimeraapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Hereda de RecuclerView, y necesita una vista a la que ligarse (view)
class TaskViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val tvTask:TextView = view.findViewById(R.id.tvTask)
    private val ivTaskDone:ImageView = view.findViewById(R.id.ivTaskDone)

    fun render(task:String, onItemDone: (Int) -> Unit) {
        tvTask.text = task
        ivTaskDone.setOnClickListener{ onItemDone (adapterPosition) }
    }
}
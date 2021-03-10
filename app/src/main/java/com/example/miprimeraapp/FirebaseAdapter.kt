package com.example.miprimeraapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_firebase.view.*

class FirebaseAdapter(var list:ArrayList<TaskFirebaseModel>) :RecyclerView.Adapter<FirebaseAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var texto = itemView.tv_texto
        var fecha = itemView.tv_fecha
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_firebase, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.texto.text=list[position].texto
        holder.fecha.text=list[position].fecha
    }
}
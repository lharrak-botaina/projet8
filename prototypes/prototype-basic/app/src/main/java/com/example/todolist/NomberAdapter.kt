package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class NomberAdapter(private val itemClickListener: OnItemClickListener): ListAdapter<Nombre, NomberAdapter.ViewHolder>(DiffCallback()){
    private class DiffCallback:DiffUtil.ItemCallback<Nombre>(){
        override fun areItemsTheSame(oldItem: Nombre, newItem: Nombre): Boolean {
           return oldItem.nombre==newItem.nombre
        }

        override fun areContentsTheSame(oldItem: Nombre, newItem: Nombre): Boolean {
            return oldItem==newItem
        }
    }
    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        private val tvNombre=itemView.findViewById(R.id.tvNombre)as TextView
        private val btnEdit= itemView.findViewById(R.id.btnEdit)as Button
        private val btndelete= itemView.findViewById(R.id.btnDelete)as Button

        fun bind(item:Nombre){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val vista =LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position),itemClickListener)
    }

    interface  OnItemClickListener{
        fun onItemEdit(position: Int,item:Nombre)
        fun onItemDelete(position: Int)
    }
}
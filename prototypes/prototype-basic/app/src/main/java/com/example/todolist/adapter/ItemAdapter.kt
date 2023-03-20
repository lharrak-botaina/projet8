package com.example.todolist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R

class ItemAdapter(
    private val context: Context,
    private val data: MutableList<String>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

   inner class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val btnDelete:Button = view.findViewById(R.id.btnDelete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.toString()
        holder.btnDelete.setOnClickListener{remove(position)}
       /* holder.btnDelete.setOnClickListener {
            data.removeAt(position)
            this.notifyItemRemoved(position)
            Toast.makeText(context, "Task Deleted", Toast.LENGTH_SHORT).show()
        }*/

    }
private fun remove(position:Int){
    data.removeAt(position)
    notifyItemRemoved(position)
}
    override fun getItemCount() = data.size

}
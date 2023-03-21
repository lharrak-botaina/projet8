package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.adapter.ItemAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var itemAdapter: ItemAdapter
    private val myDataset = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input: EditText = findViewById(R.id.input)
        val btnAdd: Button = findViewById(R.id.buttonAdd)
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        itemAdapter = ItemAdapter(this, myDataset, {position -> update(position)})
        recyclerView.adapter = itemAdapter

        btnAdd.setOnClickListener {
            val value = input.text.toString()
            myDataset.add(value)
            itemAdapter.notifyDataSetChanged()
            input.setText("")
        }

    }
    fun update(position: Int){
        var dataItem = myDataset[position]
        var input:EditText=findViewById(R.id.input)
        input.setText(dataItem)
        dataItem = input.text.toString()
        itemAdapter.setItems(dataItem)
    }
}

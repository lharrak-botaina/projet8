package com.example.affirmations
import android.annotation.SuppressLint


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val myDataset = Datasource().loadAffirmations()
        val myDataset = mutableListOf<String>()


        val input :EditText = findViewById(R.id.input)
        val btn :Button = findViewById(R.id.buttonAdd)
        val btnDelete :Button= findViewById(R.id.btnDelete)

       btn.setOnClickListener(){
          val value = input.text
           myDataset.add(value.toString())
           val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
           recyclerView.adapter = ItemAdapter(this, myDataset)

           input.setText("")

       }


        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)

    }
}



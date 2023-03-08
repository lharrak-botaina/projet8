package com.example.todolist.data

import com.example.todolist.model.Task

class datasource {
    val dataSet = mutableListOf<Task>()
    fun delete(index:Int){
        this.dataSet.removeAt(index)
    }
}
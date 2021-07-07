package com.example.homework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter : RecyclerView.Adapter<ViewHolder>() {

    var users: List<User> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    var onRecyclerItemClicked: () -> Unit = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.activity_main,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.populateModel(users[position], onRecyclerItemClicked)
    }

    override fun getItemCount() = users.size

}
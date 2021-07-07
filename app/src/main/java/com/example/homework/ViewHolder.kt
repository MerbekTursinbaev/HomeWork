package com.example.homework

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main2.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun populateModel(user: User, onRecyclerItemClicked: () -> Unit ) {
        itemView.tvName.text = user.name
        itemView.tvSurname.text = user.surname
        itemView.setOnClickListener {
            onRecyclerItemClicked.invoke()
        }
    }

}
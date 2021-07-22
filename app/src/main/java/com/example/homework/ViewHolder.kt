package com.example.homework

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.data.User
import kotlinx.android.synthetic.main.activity_main2.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun populateModel(user: User) {
        itemView.tvName.text = user.name
        itemView.tvPhoneNumber.text = user.phone.toString()
        itemView.tvTelegramId.text = user.telegramId
        itemView.tvUserName.text = user.userName
    }
}
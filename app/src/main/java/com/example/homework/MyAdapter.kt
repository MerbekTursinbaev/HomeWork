package com.example.homework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.data.User
import kotlinx.android.synthetic.main.activity_main2.view.*

class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    var onMoreClicked: (user: User, view: View) -> Unit = { _, _ -> }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun populateModel(user: User) {
            itemView.tvName.text = user.name
            itemView.tvPhoneNumber.text = user.phoneNumber
            itemView.tvTelegramId.text = user.telegramId
            itemView.tvUserName.text = user.telegramUsername
            itemView.more.setOnClickListener {
                onMoreClicked.invoke(user, it)
            }
        }
    }

    fun removeItem(user: User) {
       val list = models.toMutableList()
        val index = models.indexOf(user)
        list.remove(user)
        models = list
        notifyItemRemoved(index)
        notifyItemRangeChanged(0,models.size)
    }

    var models: List<User> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_main2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount() = models.size
}
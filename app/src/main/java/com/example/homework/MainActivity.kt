package com.example.homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var myAdapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = myAdapter
        setData()
        myAdapter.onRecyclerItemClicked = {
            var intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }

    fun setData() {
        var models: MutableList<User> = mutableListOf()
        for (i in 1..100) {
            var model = User("Mirbek $i","Tursinbaev $i")
            models.add(model)
        }
        myAdapter.users = models
    }
}
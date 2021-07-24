package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.homework.data.MyDao
import com.example.homework.data.MyDataBase
import com.example.homework.data.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_add.*
import kotlinx.android.synthetic.main.dialog_add.view.*

class MainActivity : AppCompatActivity() {

    private val mAdapter = MyAdapter()
    private lateinit var dao: MyDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter.onMoreClicked = { user, view ->
            val popupMenu = PopupMenu(this, view)
            popupMenu.menuInflater.inflate(R.menu.item_menu, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.itemEdit -> {
                      return@setOnMenuItemClickListener true
                    }
                    R.id.itemDelete -> {
                        dao.delete(user)
                        mAdapter.removeItem(user)
                        return@setOnMenuItemClickListener true
                    }
                    else -> {
                        Toast.makeText(this, "ITEM SELECTED", Toast.LENGTH_SHORT).show()
                        return@setOnMenuItemClickListener false
                    }
                }
            }
            popupMenu.show()
        }
        recyclerView.adapter = mAdapter
        setData()
    }

    private fun setData() {
        dao = MyDataBase.getIntance(this).personDao()
        mAdapter.models = dao.getAllPerson()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add -> {
                val view = LayoutInflater.from(this).inflate(R.layout.dialog_add, null)
                val dialog = AlertDialog.Builder(this)
                    .setTitle("Adding new user")
                    .setView(view)
                    .setPositiveButton("Add new user") { dialog, which ->
                        val user = User(
                            name = view.etName.text.toString(),
                            phoneNumber = view.etPhone.text.toString(),
                            telegramUsername = view.etTelegramUsername.text.toString(),
                            telegramId = view.etTelegramId.text.toString()
                        )
                        addDataToDB(user)
                    }
                    .setNegativeButton("Cancel") { dialog, which ->
                        dialog.dismiss()
                    }
                dialog.show()
                return true
            }
        }
        return true
    }

    private fun addDataToDB(user: User) {
        dao.insert(user)
        setData()
    }
}
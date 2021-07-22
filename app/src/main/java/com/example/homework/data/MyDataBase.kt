package com.example.homework.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class MyDataBase : RoomDatabase() {

    companion object {
        lateinit var INTANCE: MyDataBase
        fun getIntance(context: Context): MyDataBase {
            if (!::INTANCE.isInitialized) {
                INTANCE = Room.databaseBuilder(
                    context,
                    MyDataBase::class.java, "person-database"
                )
                    .allowMainThreadQueries()
                    .createFromAsset("Dizim.db")
                    .build()
            }
            return INTANCE
        }
    }
    abstract fun personDao() : MyDao
}
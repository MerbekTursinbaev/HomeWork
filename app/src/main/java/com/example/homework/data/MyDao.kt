package com.example.homework.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface MyDao {
    @Query("SELECT * FROM person")
    fun getAllPerson() : List<User>
}
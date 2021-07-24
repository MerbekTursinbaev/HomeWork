package com.example.homework.data

import androidx.room.*

@Dao
interface MyDao {
    @Query("SELECT * FROM person")
    fun getAllPerson() : List<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)
}
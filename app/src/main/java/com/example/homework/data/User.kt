package com.example.homework.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class User(
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val phoneNumber: String,
    val telegramUsername: String?,
    val telegramId: String
)
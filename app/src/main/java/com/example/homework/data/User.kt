package com.example.homework.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class User(
    @PrimaryKey
    val id: Int,
    val name: String,
    @ColumnInfo(name = "phoneNumber")
    val phone: Int,
    @ColumnInfo(name = "telegramUsername")
    val userName: String,
    val telegramId: String
)
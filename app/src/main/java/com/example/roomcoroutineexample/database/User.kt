package com.example.roomcoroutineexample.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
@Entity(tableName = "user")
data class User(

    @PrimaryKey(autoGenerate = true)
    val userId: Int=0,

    @ColumnInfo(name = "userName")
    val userName: String,

    @ColumnInfo(name = "userSurname")
    val userSurname: String
)
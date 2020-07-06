package com.example.roomcoroutineexample.database

import androidx.room.Database
import androidx.room.RoomDatabase


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
@Database(entities = [User::class], version = 2)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDAO(): UserDAO
}
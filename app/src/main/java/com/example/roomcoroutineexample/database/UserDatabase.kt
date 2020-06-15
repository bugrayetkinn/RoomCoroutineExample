package com.example.roomcoroutineexample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
@Database(entities = [User::class], version = 2)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDAO(): UserDAO

    companion object {
        var database: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {

            if (database == null) {
                database = Room.databaseBuilder(context, UserDatabase::class.java, "user.db")
                    .build()
            }
            return database!!
        }
    }
}
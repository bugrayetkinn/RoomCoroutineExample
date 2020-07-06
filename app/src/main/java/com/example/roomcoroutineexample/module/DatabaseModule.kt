package com.example.roomcoroutineexample.module

import androidx.room.Room
import com.example.roomcoroutineexample.database.UserDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

val databaseModule = module {


    single {
        Room.databaseBuilder(
            androidContext(),
            UserDatabase::class.java,
            "user.db"
        ).build()
    }

    single {
        get<UserDatabase>().userDAO()
    }
}
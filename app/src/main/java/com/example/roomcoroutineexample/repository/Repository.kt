package com.example.roomcoroutineexample.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.roomcoroutineexample.database.User
import com.example.roomcoroutineexample.database.UserDAO
import com.example.roomcoroutineexample.database.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class Repository {


    companion object {

        fun initializeDatabase(context: Context): UserDatabase {
            return UserDatabase.getDatabase(context)
        }

        fun getAllUser(context: Context): LiveData<List<User>> {
            return initializeDatabase(context).userDAO().getAllUser()
        }

        fun insertUser(context: Context, user: User) {

            CoroutineScope(Dispatchers.IO).launch {
                initializeDatabase(context).userDAO().insert(user)
            }
        }

        fun delete(context: Context, user: User) {

            CoroutineScope(Dispatchers.IO).launch {
                initializeDatabase(context).userDAO().delete(user)
            }
        }
    }
}

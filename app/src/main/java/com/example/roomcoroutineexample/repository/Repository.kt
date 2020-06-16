package com.example.roomcoroutineexample.repository

import androidx.lifecycle.LiveData
import com.example.roomcoroutineexample.database.User
import com.example.roomcoroutineexample.database.UserDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class Repository(val userDAO: UserDAO) {

    fun getAllUser(): LiveData<List<User>> = userDAO.getAllUser()


    suspend fun insertUser(user: User) {

        CoroutineScope(Dispatchers.IO).launch {
            userDAO.insert(user)
        }
    }

    suspend fun delete(user: User) {

        CoroutineScope(Dispatchers.IO).launch {
            userDAO.delete(user)
        }
    }

}

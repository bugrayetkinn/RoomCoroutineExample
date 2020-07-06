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
class Repository(private val userDAO: UserDAO) {

    fun getAllUser(): LiveData<List<User>> = userDAO.getAllUser()


    fun insertUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            userDAO.insert(user)
        }
    }

    fun deleteUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            userDAO.delete(user)
        }
    }

}

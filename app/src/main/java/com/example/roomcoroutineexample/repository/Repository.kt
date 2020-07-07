package com.example.roomcoroutineexample.repository

import androidx.lifecycle.LiveData
import com.example.roomcoroutineexample.database.User
import com.example.roomcoroutineexample.database.UserDAO

/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

class Repository(private val userDAO: UserDAO) {

    fun getAllUser(): LiveData<List<User>> = userDAO.getAllUser()

    suspend fun insertUser(user: User) {
        userDAO.insert(user)

    }

    suspend fun deleteUser(user: User) {
        userDAO.delete(user)
    }
}

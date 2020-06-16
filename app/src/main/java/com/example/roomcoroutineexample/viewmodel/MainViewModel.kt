package com.example.roomcoroutineexample.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomcoroutineexample.database.User
import com.example.roomcoroutineexample.database.UserDatabase
import com.example.roomcoroutineexample.repository.Repository
import kotlinx.coroutines.launch


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class MainViewModel(private val context: Context) : ViewModel() {

    val userDao = UserDatabase.getDatabase(context).userDAO()
    val repository = Repository(userDao)


    fun insertUser(user: User) {

        viewModelScope.launch {
            repository.insertUser(user)
        }

    }

    val getAllUser: LiveData<List<User>> = repository.getAllUser()

}
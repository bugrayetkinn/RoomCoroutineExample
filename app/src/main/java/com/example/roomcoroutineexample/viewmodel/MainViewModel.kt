package com.example.roomcoroutineexample.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomcoroutineexample.database.User
import com.example.roomcoroutineexample.database.UserDatabase
import com.example.roomcoroutineexample.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class MainViewModel(private val context: Context) : ViewModel() {

    fun insertUser(user: User) {

        viewModelScope.launch {
            Repository.insertUser(context, user)
        }

    }

    fun getAllUser(): LiveData<List<User>> {

        return Repository.getAllUser(context)
    }
}
package com.example.roomcoroutineexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomcoroutineexample.database.User
import com.example.roomcoroutineexample.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class MainViewModel(private val repository: Repository) : ViewModel() {

    fun insertUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertUser(user)
        }

    }

    val getAllUser: LiveData<List<User>> = repository.getAllUser()

}
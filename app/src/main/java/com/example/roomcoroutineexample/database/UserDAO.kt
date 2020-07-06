package com.example.roomcoroutineexample.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

@Dao
interface UserDAO {

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT*FROM user")
    fun getAllUser(): LiveData<List<User>>

}
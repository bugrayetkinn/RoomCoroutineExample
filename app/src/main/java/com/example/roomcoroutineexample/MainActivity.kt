package com.example.roomcoroutineexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.roomcoroutineexample.database.User
import com.example.roomcoroutineexample.databinding.ActivityMainBinding
import com.example.roomcoroutineexample.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val mainViewModel: MainViewModel by lazy {
        MainViewModel(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(activityMainBinding.root)

        activityMainBinding.buttonSave.setOnClickListener {


            val userName = activityMainBinding.editTextName.text.toString()
            val userSurname = activityMainBinding.editTextSurname.text.toString()

            val user = User(userName = userName, userSurname = userSurname)

            mainViewModel.insertUser(user)
        }


        var result: String = ""
        mainViewModel.getAllUser.observe(this, Observer { it ->

            result = ""

            it.forEach {
                result += "${it.userName} - ${it.userSurname}\n"
            }
            activityMainBinding.textView.text = result

        })


    }
}
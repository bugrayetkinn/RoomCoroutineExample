package com.example.roomcoroutineexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.roomcoroutineexample.database.User
import com.example.roomcoroutineexample.databinding.ActivityMainBinding
import com.example.roomcoroutineexample.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val activityMainBinding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)

    private val mainViewModel: MainViewModel by viewModel()

    private lateinit var userName: String
    private lateinit var userSurname: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)

        activityMainBinding.buttonSave.setOnClickListener {

            userName = activityMainBinding.editTextName.text.toString()
            userSurname = activityMainBinding.editTextSurname.text.toString()

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
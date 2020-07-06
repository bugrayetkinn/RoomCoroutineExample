package com.example.roomcoroutineexample.module

import com.example.roomcoroutineexample.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

val mainViewModelModule = module {
    viewModel { MainViewModel(get()) }
}
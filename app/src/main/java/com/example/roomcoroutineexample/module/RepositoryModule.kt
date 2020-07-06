package com.example.roomcoroutineexample.module

import com.example.roomcoroutineexample.repository.Repository
import org.koin.dsl.module


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

val repositoryModule = module {
    single { Repository(get()) }
}
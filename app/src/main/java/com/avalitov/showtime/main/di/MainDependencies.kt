package com.avalitov.showtime.main.di

import com.avalitov.showtime.network.WebRepository
import org.koin.dsl.module

object MainDependencies {
    val mainModule = module {
        single {
            WebRepository()
        }
    }
}
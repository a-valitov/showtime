package com.avalitov.showtime.pages.populars.di

import com.avalitov.showtime.pages.populars.PopularsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val popularsModule = module {
    viewModel {
        PopularsViewModel()
    }
}
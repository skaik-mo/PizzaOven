package com.example.pizza.di

import com.example.pizza.screen.viewmodel.PizzaViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::PizzaViewModel)
}
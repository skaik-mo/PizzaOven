package com.example.pizza.screen.viewmodel

import com.example.test.PizzaSize

data class PizzaUiState(
    var size: PizzaSize = PizzaSize.MEDIUM,
    var price: Float = 18f,
    var withBasil: Boolean = false,
    var withBroccoli: Boolean = false,
    var withOnion: Boolean = false,
    var withSausage: Boolean = false,
    var withMushroom: Boolean = false,
    var breads: List<Int> = emptyList<Int>().toMutableList(),
)

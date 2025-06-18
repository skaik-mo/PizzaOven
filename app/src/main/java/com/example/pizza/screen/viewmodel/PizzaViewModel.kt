package com.example.pizza.screen.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pizza.R
import com.example.test.PizzaSize
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PizzaViewModel() : ViewModel() {
    private var _state = MutableStateFlow(PizzaUiState())
    val state: StateFlow<PizzaUiState> = _state.asStateFlow()

    init {
        setUpData()
    }

    private fun setUpData() {
        _state.update {
            it.copy(
                breads = listOf(
                    R.drawable.img_bread_5,
                    R.drawable.img_bread_2,
                    R.drawable.img_bread_3,
                    R.drawable.img_bread_4,
                    R.drawable.img_bread_1,
                )
            )
        }
    }

    fun onSmallSizeSelected() {
        _state.update { it.copy(size = PizzaSize.SMALL) }
    }

    fun onMediumSizeSelected() {
        _state.update { it.copy(size = PizzaSize.MEDIUM) }
    }

    fun onLargeSizeSelected() {
        _state.update { it.copy(size = PizzaSize.LARGE) }
    }

    fun toggleBasilSelection() {
        _state.update { it.copy(withBasil = !it.withBasil) }
    }

    fun toggleBroccoliSelection() {
        _state.update { it.copy(withBroccoli = !it.withBroccoli) }
    }

    fun toggleOnionSelection() {
        _state.update { it.copy(withOnion = !it.withOnion) }
    }

    fun toggleSausageSelection() {
        _state.update { it.copy(withSausage = !it.withSausage) }
    }

    fun toggleMushroomSelection() {
        _state.update { it.copy(withMushroom = !it.withMushroom) }
    }
}
package com.example.test;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.dp

class ElevationSize(
    val small: Dp,
    val medium: Dp,
    val large: Dp,
)

enum class PizzaSize {
    SMALL, MEDIUM, LARGE;

    fun getHeight(): Dp {
        return when (this) {
            SMALL -> 200.dp
            MEDIUM -> 250.dp
            LARGE -> 300.dp
        }
    }

    fun elevation(): ElevationSize {
        return when (this) {
            SMALL -> ElevationSize(small = 5.dp, medium = 0.dp, large = 0.dp)
            MEDIUM -> ElevationSize(small = 0.dp, medium = 5.dp, large = 0.dp)
            LARGE -> ElevationSize(small = 0.dp, medium = 0.dp, large = 5.dp)
        }
    }
}
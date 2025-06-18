package com.example.pizza.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pizza.R
import com.example.pizza.screen.viewmodel.PizzaUiState
import com.example.test.toPainter

@Composable
fun PizzaCategories(
    state: PizzaUiState,
    toggleBasilSelection: () -> Unit,
    toggleBroccoliSelection: () -> Unit,
    toggleOnionSelection: () -> Unit,
    toggleSausageSelection: () -> Unit,
    toggleMushroomSelection: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth()
            .padding(horizontal = 16.dp)
    ) {
        CategoryPizza(
            categoryImage = R.drawable.img_basil_1.toPainter(),
            isSelected = state.withBasil,
            onClick = toggleBasilSelection
        )
        CategoryPizza(
            categoryImage = R.drawable.img_broccoli_1.toPainter(),
            isSelected = state.withBroccoli,
            onClick = toggleBroccoliSelection
        )
        CategoryPizza(
            categoryImage = R.drawable.img_onion_1.toPainter(),
            isSelected = state.withOnion,
            onClick = toggleOnionSelection
        )
        CategoryPizza(
            categoryImage = R.drawable.img_sausage_1.toPainter(),
            isSelected = state.withSausage,
            onClick = toggleSausageSelection
        )
        CategoryPizza(
            categoryImage = R.drawable.img_mushroom_1.toPainter(),
            isSelected = state.withMushroom,
            onClick = toggleMushroomSelection
        )
    }
}
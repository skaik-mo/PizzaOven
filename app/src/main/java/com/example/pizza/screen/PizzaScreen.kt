package com.example.pizza.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizza.R
import com.example.pizza.screen.components.PizzaBreadRow
import com.example.pizza.screen.components.PizzaCategories
import com.example.pizza.screen.components.PizzaSizeSelector
import com.example.pizza.screen.viewmodel.PizzaUiState
import com.example.pizza.screen.viewmodel.PizzaViewModel
import com.example.test.toPainter
import org.koin.androidx.compose.koinViewModel


@Composable
fun PizzaScreen(
    pizzaViewModel: PizzaViewModel = koinViewModel()
) {
    val state by pizzaViewModel.state.collectAsState()
    PizzaContent(
        state = state,
        onSmallSizeSelected = pizzaViewModel::onSmallSizeSelected,
        onMediumSizeSelected = pizzaViewModel::onMediumSizeSelected,
        onLargeSizeSelected = pizzaViewModel::onLargeSizeSelected,
        toggleBasilSelection = pizzaViewModel::toggleBasilSelection,
        toggleBroccoliSelection = pizzaViewModel::toggleBroccoliSelection,
        toggleOnionSelection = pizzaViewModel::toggleOnionSelection,
        toggleSausageSelection = pizzaViewModel::toggleSausageSelection,
        toggleMushroomSelection = pizzaViewModel::toggleMushroomSelection,
    )
}

@Composable
fun PizzaContent(
    state: PizzaUiState,
    onSmallSizeSelected: () -> Unit,
    onMediumSizeSelected: () -> Unit,
    onLargeSizeSelected: () -> Unit,
    toggleBasilSelection: () -> Unit,
    toggleBroccoliSelection: () -> Unit,
    toggleOnionSelection: () -> Unit,
    toggleSausageSelection: () -> Unit,
    toggleMushroomSelection: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
            .statusBarsPadding()
    ) {
        Text(
            text = "Pizza",
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            letterSpacing = 0.7.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 50.dp)
        )
        Box(
            modifier = Modifier
                .height(330.dp)
        ) {
            Image(
                painter = R.drawable.img_plate.toPainter(),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
            )
            PizzaBreadRow(
                state = state,
            )
        }
        Text(
            text = "$${state.price}",
            fontWeight = FontWeight.Black,
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            letterSpacing = 0.7.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
        )
        PizzaSizeSelector(
            size = state.size,
            onSmallSizeSelected = onSmallSizeSelected,
            onMediumSizeSelected = onMediumSizeSelected,
            onLargeSizeSelected = onLargeSizeSelected
        )
        Text(
            text = "CUSTOMIZE YOUR PIZZA",
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            color = Color.Gray.copy(alpha = 0.7f),
            letterSpacing = 0.7.sp,
            modifier = Modifier
                .padding(bottom = 20.dp, top = 40.dp)
                .padding(horizontal = 16.dp)
        )
        PizzaCategories(
            state = state,
            toggleBasilSelection = toggleBasilSelection,
            toggleBroccoliSelection = toggleBroccoliSelection,
            toggleOnionSelection = toggleOnionSelection,
            toggleSausageSelection = toggleSausageSelection,
            toggleMushroomSelection = toggleMushroomSelection,
        )
    }
}
package com.example.pizza.screen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.pizza.R
import com.example.pizza.screen.viewmodel.PizzaUiState
import com.example.test.toPainter
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.random.Random

@Composable
fun BoxScope.PizzaBreadRow(
    state: PizzaUiState,
) {
    val pagerState = rememberPagerState(pageCount = { state.breads.size })
    HorizontalPager(
        state = pagerState,
        modifier = Modifier.align(Alignment.Center)
    ) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                PizzaItem(
                    bread = state.breads[it],
                    state = state
                )
            }
        }
    }

@Composable
private fun BoxScope.PizzaItem(
    bread: Int,
    state: PizzaUiState,
) {
    val pizzaHeight by animateDpAsState(state.size.getHeight())
    Box(
        modifier = Modifier
            .height(pizzaHeight)
            .aspectRatio(1f)
            .align(Alignment.Center)
    ) {
        Image(
            painter = bread.toPainter(),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
        )

        PizzaToppings(state = state)
    }
}

@Composable
private fun BoxScope.PizzaToppings(state: PizzaUiState, ingredientHeight: Dp = 30.dp) {
    val radius = (state.size.getHeight() - ingredientHeight) / 2
    val basilPositions = generateRandomPositions(10, radius)
    val mushroomPositions = generateRandomPositions(10, radius)
    val onionPositions = generateRandomPositions(10, radius)
    val broccoliPositions = generateRandomPositions(10, radius)
    val sausagePositions = generateRandomPositions(10, radius)

    basilPositions.forEach { (x, y) ->
        CategoryImage(
            image = R.drawable.img_basil_1.toPainter(),
            visible = state.withBasil,
            size = ingredientHeight,
            modifier = Modifier
                .offset(
                    x = x,
                    y = y
                )
        )
    }
    mushroomPositions.forEach { (x, y) ->
        CategoryImage(
            image = R.drawable.img_mushroom_1.toPainter(),
            visible = state.withMushroom,
            size = ingredientHeight,
            modifier = Modifier
                .offset(
                    x = x,
                    y = y
                )
        )
    }
    onionPositions.forEach { (x, y) ->
        CategoryImage(
            image = R.drawable.img_onion_1.toPainter(),
            visible = state.withOnion,
            size = ingredientHeight,
            modifier = Modifier
                .offset(
                    x = x,
                    y = y
                )
        )
    }
    broccoliPositions.forEach { (x, y) ->
        CategoryImage(
            image = R.drawable.img_broccoli_1.toPainter(),
            visible = state.withBroccoli,
            size = ingredientHeight,
            modifier = Modifier
                .offset(
                    x = x,
                    y = y
                )
        )
    }
    sausagePositions.forEach { (x, y) ->
        CategoryImage(
            image = R.drawable.img_sausage_1.toPainter(),
            visible = state.withSausage,
            size = ingredientHeight,
            modifier = Modifier
                .offset(
                    x = x,
                    y = y
                )
        )
    }
}

private fun generateRandomPositions(count: Int, radius: Dp): List<Pair<Dp, Dp>> {
    require(count >= 0) { "Count must be non-negative" }
    require(radius > 0.dp) { "Radius must be positive" }

    val positions = mutableListOf<Pair<Dp, Dp>>()
    val radiusValue = radius.value
    val paddingPercentage = 0.1f
    val minDistance = radiusValue * paddingPercentage
    val maxDistance = radiusValue * (1 - paddingPercentage)

    if (minDistance >= maxDistance) {
        // Fallback to center position if pizza is too small
        return List(count) { 0.dp to 0.dp }
    }

    repeat(count) {
        val angle = Random.nextDouble() * 2 * PI
        val distance = sqrt(Random.nextDouble()) * (maxDistance - minDistance) + minDistance
        val x = radius + (distance * cos(angle)).dp
        val y = radius + (distance * sin(angle)).dp
        positions.add(x to y)
    }
    return positions
}

@Composable
private fun BoxScope.CategoryImage(
    modifier: Modifier = Modifier,
    image: Painter,
    visible: Boolean,
    size: Dp
) {
    AnimatedVisibility(
        visible = visible,
        enter = scaleIn(initialScale = 80f, animationSpec = tween(500)),
        exit = fadeOut(tween(100)),
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .size(size)
        )
    }
}
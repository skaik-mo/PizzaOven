package com.example.pizza.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.CategoryPizza(
    categoryImage: Painter,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Image(
        painter = categoryImage,
        contentDescription = null,
        modifier = Modifier
            .weight(1f)
            .aspectRatio(1f)
            .background(
                color = if (isSelected) Color.Green.copy(0.2f) else Color.Transparent,
                shape = CircleShape
            )
            .padding(15.dp)
            .clickable(
                onClick = onClick
            )
    )
}
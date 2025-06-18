package com.example.pizza.screen.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.PizzaSize

@Composable
fun PizzaSizeSelector(
    size: PizzaSize,
    onSmallSizeSelected: () -> Unit,
    onMediumSizeSelected: () -> Unit,
    onLargeSizeSelected: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth()
    ) {
        CircleButton(
            elevationShadow = size.elevation().small,
            text = "S",
            onClick = onSmallSizeSelected
        )
        CircleButton(
            elevationShadow = size.elevation().medium,
            text = "M",
            onClick = onMediumSizeSelected
        )
        CircleButton(
            elevationShadow = size.elevation().large,
            text = "L",
            onClick = onLargeSizeSelected
        )
    }
}

@Composable
private fun CircleButton(elevationShadow: Dp, text: String, onClick: () -> Unit) {
    val elevation by animateDpAsState(
        targetValue = elevationShadow,
        animationSpec = spring(
            dampingRatio = 0.6f,
            stiffness = 300f
        )
    )
    Button(
        onClick = onClick,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = Color.White,
            contentColor = Color.Black,
        ),
        modifier = Modifier
            .size(60.dp)
            .shadow(
                shape = CircleShape,
                elevation = elevation,
            )
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    }
}

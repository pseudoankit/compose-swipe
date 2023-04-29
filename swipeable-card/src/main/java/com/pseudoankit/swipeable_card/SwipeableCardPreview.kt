package com.pseudoankit.swipeable_card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SwipeableCardPreview() {
    SwipeableCardConfig.Direction.values().forEach { direction ->
        SwipeableCard(
            config = SwipeableCardConfig(
                direction = direction,
                maxOffsetToReveal = 200f,
                revealThreshold = 50f
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            color = Color.Blue,
            shape = RoundedCornerShape(12.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = direction.displayName, color = Color.White)
            }
        }
    }
}

private val SwipeableCardConfig.Direction.displayName
    get() = when (this) {
        SwipeableCardConfig.Direction.RTL -> "Right to Left"
        SwipeableCardConfig.Direction.LTR -> "Left to Right"
    }

package com.pseudoankit.swipeable_card

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

private const val MIN_OFFSET_TO_REVEAL: Float = 0f
private const val ANIMATION_DURATION = 500

/**
 * wrapper to create a swipeable view
 * @param config [SwipeableCardConfig] configurations of swipeable view
 * @param content actual content inside the view
 */
@Composable
fun SwipeableCard(
    config: SwipeableCardConfig,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    color: Color = MaterialTheme.colors.surface,
    content: @Composable () -> Unit
) = with(config) {
    var dragAmount by remember { mutableStateOf(0f) }
    var currentOffset by remember(offsetValue) { mutableStateOf(offsetValue) }
    val displayOffset by remember {
        derivedStateOf {
            when (direction) {
                SwipeableCardConfig.Direction.RTL -> {
                    when {
                        currentOffset < MIN_OFFSET_TO_REVEAL -> -MIN_OFFSET_TO_REVEAL
                        currentOffset > maxOffsetToReveal -> -maxOffsetToReveal
                        else -> -currentOffset
                    }
                }
                SwipeableCardConfig.Direction.LTR -> {
                    when {
                        currentOffset < MIN_OFFSET_TO_REVEAL -> MIN_OFFSET_TO_REVEAL
                        currentOffset > maxOffsetToReveal -> maxOffsetToReveal
                        else -> currentOffset
                    }
                }
            }
        }
    }

    Surface(
        modifier = modifier
            .offset { IntOffset((displayOffset).roundToInt(), 0) }
            .pointerInput(Unit) {
                detectHorizontalDragGestures(
                    onDragEnd = {
                        currentOffset = when (direction) {
                            SwipeableCardConfig.Direction.RTL -> {
                                if (-currentOffset < revealThreshold || dragAmount > 0) MIN_OFFSET_TO_REVEAL else -maxOffsetToReveal
                            }
                            SwipeableCardConfig.Direction.LTR -> {
                                if (currentOffset < revealThreshold || dragAmount < 0) MIN_OFFSET_TO_REVEAL else maxOffsetToReveal
                            }
                        }
                    }
                ) { change, dragValue ->
                    dragAmount = dragValue
                    currentOffset += dragValue
                    if (change.positionChange() != Offset.Zero) change.consume()
                }
            },
        elevation = animateDpAsState(
            targetValue = if (displayOffset != 0f) elevationWhenRevealed else 0.dp,
            animationSpec = tween(durationMillis = ANIMATION_DURATION)
        ).value,
        shape = shape,
        color = color,
        content = content,
    )
}

private fun log(message: String) {
    println("SwipeableCardLogs : $message")
}

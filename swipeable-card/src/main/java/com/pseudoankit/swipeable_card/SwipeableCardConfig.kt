package com.pseudoankit.swipeable_card

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pseudoankit.swipeable_card.SwipeableCardConfig.Direction

/**
 * config for [SwipeableCard]
 * @param direction specify the [Direction] of swipe in which user can move
 * @param maxOffsetToReveal maximum limit until which user can swipe the view and swiping further will have no effect
 * @param revealThreshold value till which if user drags, then view will be swiped to [maxOffsetToReveal],
 * eg: if [revealThreshold] is 20 then if user swipe value is >= 20 then it will automatically be swiped to [maxOffsetToReveal]
 * @param offsetValue initial offset value, value by which card will be swiped as per [direction] specified
 * @param elevationWhenRevealed elevation value when view is swiped
 */
data class SwipeableCardConfig(
    val direction: Direction,
    private val maxOffsetToReveal: Float,
    val revealThreshold: Float,
    val offsetValue: Float = 0f,
    val elevationWhenRevealed: Dp = 8.dp,
) {

    /** direction of swipe movement */
    enum class Direction {
        /** Right to Left */
        RTL,

        /** Left to Right */
        LTR
    }

    internal val maximumOffsetToReveal
        get() = when (direction) {
            Direction.RTL -> -maxOffsetToReveal
            Direction.LTR -> maxOffsetToReveal
        }
}
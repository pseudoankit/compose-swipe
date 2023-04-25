package com.pseudoankit.draggablecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pseudoankit.draggablecard.ui.theme.DraggableCardTheme
import com.pseudoankit.swipeable_card.SwipeableCard
import com.pseudoankit.swipeable_card.SwipeableCardConfig

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DraggableCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

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
                                    Text(text = direction.dipsplayName, color = Color.White)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private val SwipeableCardConfig.Direction.dipsplayName
        get() = when (this) {
            SwipeableCardConfig.Direction.RTL -> "Right to Left"
            SwipeableCardConfig.Direction.LTR -> "Left to Right"
        }
}
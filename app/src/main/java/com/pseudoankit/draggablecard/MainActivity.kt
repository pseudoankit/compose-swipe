package com.pseudoankit.draggablecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
                    Column(modifier = Modifier.fillMaxSize().padding(12.dp)) {
                        SwipeableCard(
                            config = SwipeableCardConfig(
                                direction = SwipeableCardConfig.Direction.LTR,
                                maxOffsetToReveal = 200f,
                                revealThreshold = 50f
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            color = Color.Blue
                        ) {

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DraggableCardTheme {
        Greeting("Android")
    }
}
package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.animation.core.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTutorialTheme {

                var sizeState by remember { mutableStateOf(200.dp) }
                val size by animateDpAsState(
                    targetValue = sizeState,
                    label = "",
                    //animationSpec = spring(Spring.DampingRatioMediumBouncy)
                    animationSpec = keyframes {
                        durationMillis = 5000
                        sizeState at 0 with LinearEasing
                        sizeState * 1.5f at 1000 with FastOutLinearInEasing
                        sizeState* 2f at 5000
                    }
                  //  animationSpec =
                //tween(durationMillis = 3000, delayMillis = 300, easing = LinearOutSlowInEasing)
                )


                val infiniteTransition = rememberInfiniteTransition()
                val color by infiniteTransition.animateColor(
                    initialValue = Color.Red,
                    targetValue = Color.Green,
                    animationSpec = infiniteRepeatable(
                        tween(durationMillis = 2000),
                        repeatMode = RepeatMode.Reverse
                    )
                )
                Box(
                    modifier = Modifier
                        .size(size)
                        .background(color = color),
                    contentAlignment = Alignment.Center
                ) {
                    Button(onClick = {
                        sizeState += 50.dp
                    }) {
                        Text("Increase Size")
                    }
                }
            }
        }
    }
}

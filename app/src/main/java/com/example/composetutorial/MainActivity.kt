package com.example.composetutorial

import android.health.connect.datatypes.units.Percentage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTutorialTheme {
                var percentageState by remember {
                    mutableStateOf(0f)
                }

                Box(
                    contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        CircularProgressBar(
                            percentage = percentageState,
                            number = 100,
                            color = if (percentageState<=0.2f){
                                Color.Red
                            } else {
                                Color.Green
                            })
                        percentageState = percentageInput()

                        Button(onClick = {
                            percentageState += 0.1f
                        }) {
                            Text("Increase by 10%")
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun CircularProgressBar(
    percentage: Float,
    number: Int,
    fontSize: TextUnit = 29.sp,
    radius: Dp = 50.dp,
    color: Color = Color.Green,
    strokeWidth: Dp = 3.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }

    val curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f, animationSpec = tween(
            durationMillis = 3000,
            delayMillis = 1000,
        )
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        contentAlignment = Alignment.Center, modifier = Modifier.size(radius * 2f)
    ) {
        androidx.compose.foundation.Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360 * curPercentage.value,
                useCenter = false,
                style = Stroke(
                    width = strokeWidth.toPx(), cap = StrokeCap.Round
                )
            )
        }
        Text(
            text = (curPercentage.value * number).toInt().toString()+ "%",
            color = Color.Black,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold
        )

    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun percentageInput():Float {
    var input by remember { mutableStateOf("") }
    var percentage by remember { mutableStateOf(0f) }
    var errorMessage by remember { mutableStateOf("") }


    fun validateAndConvertInput (newValue:String){
        if (newValue.isEmpty()) {
            input = newValue
            percentage = 0f
            errorMessage = ""
        }else {
            val number = newValue.toIntOrNull()
            if (number!= null && number in 0..100){
                input = newValue
                percentage = number/100f
                errorMessage = ""
            }else {
                errorMessage = "Please enter a valid number between 0 and 100"
            }
        }
    }


    OutlinedTextField(
        value = input,
        onValueChange = { newValue ->
            // Restrict input to numbers only

            validateAndConvertInput(newValue)
        },
        label = { Text("Enter number (0-100)") },
        isError = errorMessage.isNotEmpty(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )

    if (errorMessage.isNotEmpty()) {
        Text(
            text = errorMessage,
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier.padding(start = 16.dp, top = 8.dp)
        )
    } else {
        // Display the percentage value
        Text(
            text = "Percentage: ${percentage * 100}%",
            modifier = Modifier.padding(start = 16.dp, top = 8.dp)
        )
    }
    return percentage
}

package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animate
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {

    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var text by remember {
                mutableStateOf("")
            }

            ComposeTutorialTheme {


                LaunchedEffectAnimation(10)
                Column {
//                    Text(modifier = Modifier.fillMaxWidth(), text = text,)
//
//                    Button(modifier = Modifier.fillMaxWidth(), onClick = {
//                        i++
//                        text = i.toString()
//                    }) {
//                        Text("Click to add 1 to $text")
//                    }
                DerivedStateOfDemo()
                }
            }
        }
    }
}






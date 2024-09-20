package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.meditation.HomeScreen
import com.example.composetutorial.ui.timer.Timer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            //HomeScreen()

            Surface (
                color = Color(0xFF101010),
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                ){
                  Timer(
                      totalTime = 100L*1000L,
                      handleColor = Color.Green,
                      inactiveBarColor = Color.DarkGray,
                      activeBarColor = Color(0xFF37B900),
                      modifier = Modifier.size(200.dp)
                      )
                }
            }

        }
    }
}You have not agreed to the Xcode license agreements. Please run 'sudo xcodebuild -license' from within
a Terminal window to review and agree to the Xcode and Apple SDKs license.
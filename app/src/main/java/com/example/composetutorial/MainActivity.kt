package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.dropdown.DropDown
import com.example.composetutorial.ui.meditation.HomeScreen
import com.example.composetutorial.ui.timer.Timer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            //HomeScreen()

//            Surface (
//                color = Color(0xFF101010),
//                modifier = Modifier.fillMaxSize()
//            ) {
//                Box(
//                    contentAlignment = Alignment.Center,
//                ){
//                  Timer(
//                      totalTime = 100L*1000L,
//                      handleColor = Color.Green,
//                      inactiveBarColor = Color.DarkGray,
//                      activeBarColor = Color(0xFF37B900),
//                      modifier = Modifier.size(200.dp)
//                      )
//                }
//            }


            Surface(
                color = Color(0xFF101010),
                modifier = Modifier.fillMaxSize()
            ) {
                DropDown (text = "Hello World!",
                    modifier = Modifier.padding(15.dp)){
                    Text(
                        text = "This is now visible",
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(Color.DarkGray)
                    )
                }
            }

        }
    }
}
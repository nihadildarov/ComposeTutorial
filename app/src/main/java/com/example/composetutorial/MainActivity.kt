package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTutorialTheme {
                val snackBarHostState = remember {
                    SnackbarHostState()
                }
                val snackBarScope = rememberCoroutineScope()
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    snackbarHost = {
                        SnackbarHost(snackBarHostState){data->
                            Snackbar (containerColor = Color.Black, actionColor = Color.White, snackbarData = data)
                        }
                    }
                ) {
                    Column {
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Red)
                            .padding(it)
                            .clickable {
                                snackBarScope.launch {
                                    val snackBarResult = snackBarHostState.showSnackbar(
                                        message = "Click recognized 🧐",
                                        duration = SnackbarDuration.Short,
                                        actionLabel = "Retry"
                                    )

                                    if (snackBarResult == SnackbarResult.ActionPerformed) {
                                        snackBarHostState.showSnackbar(message = "Clicked TWIICEE!!! 👏")
                                    }
                                }
                            }
                        )

                    }
                }


            }
        }
    }
}

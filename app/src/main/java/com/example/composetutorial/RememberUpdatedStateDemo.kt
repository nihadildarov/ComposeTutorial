package com.example.composetutorial

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

@Composable
fun RememberUpdatedStateDemo(
    onTimeout: () -> Unit
){
    val updatedOnTimeout by rememberUpdatedState(newValue = onTimeout)
    LaunchedEffect (true){
        delay(3000L)
        updatedOnTimeout()
    }
}
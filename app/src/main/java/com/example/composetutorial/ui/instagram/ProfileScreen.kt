package com.example.composetutorial.ui.instagram

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopBar(
            name = "nihadildarov"
        )

        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(4.dp))
        ProfileDescription(
            displayName = "Nihad Ildarov",
            description = "My name is Nihad. I am a student at the University of Toronto",
            url = "\"https://github.com/nihadildarov\"",
            followedBy = listOf("codingflow","thek4mi","xcodef"),
            otherCount = 18
        )
    }

}










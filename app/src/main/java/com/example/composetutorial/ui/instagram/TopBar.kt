package com.example.composetutorial.ui.instagram

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.R

@Composable
fun TopBar (
    modifier: Modifier = Modifier,
    name: String = "John Doe",

    ) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)

    ){
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = modifier
                .size(20.dp)
                .weight(1f)
        )

        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = modifier.weight(6f)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_music),
            contentDescription = "Notifications",
            tint = Color.Black,
            modifier = modifier
                .size(20.dp)
                .weight(1f)
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_home),
            contentDescription = "Menu",
            tint = Color.Black,
            modifier = modifier
                .size(20.dp)
                .weight(1f)
        )
    }
}
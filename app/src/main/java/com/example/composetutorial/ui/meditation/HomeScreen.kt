package com.example.composetutorial.ui.meditation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.R
import com.example.composetutorial.ui.theme.AquaBlue
import com.example.composetutorial.ui.theme.BlueViolet1
import com.example.composetutorial.ui.theme.BlueViolet3
import com.example.composetutorial.ui.theme.ButtonBlue
import com.example.composetutorial.ui.theme.DarkerButtonBlue
import com.example.composetutorial.ui.theme.DeepBlue
import com.example.composetutorial.ui.theme.LightGreen1
import com.example.composetutorial.ui.theme.LightGreen2
import com.example.composetutorial.ui.theme.LightGreen3
import com.example.composetutorial.ui.theme.LightRed
import com.example.composetutorial.ui.theme.OrangeYellow3
import com.example.composetutorial.ui.theme.TextWhite

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {

        Column {
            GreetingSection()
            ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depression"))
            CurrentMeditation()
            Featured(
                listOf(
                    Feature(
                        "Sleep meditation",
                        R.drawable.ic_headphone,
                        lightColor = LightGreen3,
                        mediumColor = LightGreen2,
                        darkColor = LightGreen1
                    ), Feature(
                        "Tips for sleeping",
                        R.drawable.ic_home,
                        lightColor = DarkerButtonBlue,
                        mediumColor = BlueViolet3,
                        darkColor = BlueViolet1
                    ), Feature(
                        "Night Island",
                        R.drawable.ic_bubble,
                        lightColor = LightRed,
                        mediumColor = OrangeYellow3,
                        darkColor = BlueViolet3
                    ), Feature(
                        "Sleep meditation",
                        R.drawable.ic_profile,
                        lightColor = LightGreen3,
                        mediumColor = LightGreen1,
                        darkColor = DarkerButtonBlue
                    ), Feature(
                        "Sleep meditation",
                        R.drawable.ic_moon,
                        lightColor = LightGreen2,
                        mediumColor = LightGreen1,
                        darkColor = LightGreen3
                    ), Feature(
                        "Sleep meditation",
                        R.drawable.ic_headphone,
                        lightColor = LightGreen1,
                        mediumColor = LightGreen2,
                        darkColor = DarkerButtonBlue
                    ), Feature(
                        "Sleep meditation",
                        R.drawable.ic_headphone,
                        lightColor = LightGreen1,
                        mediumColor = LightGreen2,
                        darkColor = DarkerButtonBlue
                    )
                )
            )
        }
        BottomNavMenu(items = listOf(
            BottomNavMenuContent("Home",R.drawable.ic_home),
            BottomNavMenuContent("Meditate",R.drawable.ic_bubble),
            BottomNavMenuContent("Sleep",R.drawable.ic_moon),
            BottomNavMenuContent("Music",R.drawable.ic_music),
            BottomNavMenuContent("Profile",R.drawable.ic_profile),
        ),
            modifier = Modifier.align(Alignment.BottomCenter))
    }
}


@Composable
fun GreetingSection(
    name: String = "Phillip"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good morning, $name",
                style = MaterialTheme.typography.headlineMedium,
                color = TextWhite
            )
            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.bodyMedium,
                color = TextWhite
            )
        }
        Icon(
            painter = painterResource(R.drawable.ic_search),
            contentDescription = "Search",
            tint = White,
            modifier = Modifier.size(24.dp)
        )
    }
}


@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableIntStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue else DarkerButtonBlue
                    )
                    .padding(15.dp)) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}


@Composable
fun CurrentMeditation(
    color: Color = LightRed
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.headlineMedium,
                color = TextWhite
            )
            Text(
                text = "Meditation • 3-10 min",
                style = MaterialTheme.typography.bodyMedium,
                color = TextWhite
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_play),
                contentDescription = "Play",
                tint = White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun Featured(
    features: List<Feature>,
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            text = "Featured",
            color = TextWhite,
            textAlign = TextAlign.Left,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        LazyVerticalGrid(
            modifier = Modifier.fillMaxHeight(),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp)
        ) {
            items(features.size) {
                FeatureItem(
                    feature = features[it]
                )
            }
        }
    }
}

@Composable
fun FeatureItem(
    feature: Feature
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        //medium color path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.40f, -height.toFloat())

        val mediumColorPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)

            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        //LightColorPath
        val lightColoredPoint1 = Offset(0f, height * 0.35f)
        val lightColoredPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightColoredPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightColoredPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightColoredPoint5 = Offset(width * 1.40f, -height.toFloat() / 3f)

        val lightColorPath = Path().apply {
            moveTo(lightColoredPoint1.x, lightColoredPoint1.y)
            standardQuadFromTo(lightColoredPoint1, lightColoredPoint2)
            standardQuadFromTo(lightColoredPoint2, lightColoredPoint3)
            standardQuadFromTo(lightColoredPoint3, lightColoredPoint4)
            standardQuadFromTo(lightColoredPoint4, lightColoredPoint5)

            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }


        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumColorPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColorPath,
                color = feature.lightColor
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.headlineSmall,
                lineHeight = 26.sp,
                modifier = Modifier
                    .align(Alignment.TopStart),
                color = TextWhite
            )

            Icon(
                painter = painterResource(feature.iconId),
                contentDescription = feature.title,
                tint = White,
                modifier = Modifier.align(Alignment.BottomStart)
            )

            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {
                        //Handle Click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)
            )
        }


    }
}

@Composable
fun BottomNavMenu(
    modifier: Modifier = Modifier,
    items: List<BottomNavMenuContent>,
    activeHighLightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0

) {

    var selectedItemIndex by remember {
        mutableIntStateOf(initialSelectedItemIndex)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomNavMenuItem(
                item = item,
                isSelected = index  ==  selectedItemIndex,
                activeHighLightColor = activeHighLightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomNavMenuItem(
    modifier: Modifier = Modifier,
    item: BottomNavMenuContent,
    isSelected: Boolean = false,
    activeHighLightColor: Color,
    activeTextColor: Color,
    inactiveTextColor: Color,
    onItemClickListener: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable {
                onItemClickListener()
            }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(
                    if (isSelected) activeHighLightColor else Color.Transparent
                )
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveTextColor
        )
    }
}
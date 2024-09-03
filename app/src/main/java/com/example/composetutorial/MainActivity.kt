package com.example.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.composetutorial.ui.theme.ComposeTutorialTheme
import kotlinx.coroutines.launch
import kotlin.random.Random
import kotlin.reflect.typeOf

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            val constraints = ConstraintSet {
                val greenBox = createRefFor("greenBox")
                val redBox = createRefFor("redBox")
                val guideLine = createGuidelineFromTop(0.5f)

                constrain(greenBox){
                    top.linkTo(guideLine)
                    start.linkTo(parent.start)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }

                constrain(redBox){
                    top.linkTo(parent.top)
                    start.linkTo(greenBox.end)
                    end.linkTo(parent.end)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }

                createHorizontalChain(greenBox,redBox, chainStyle = ChainStyle.Packed)
            }

            ConstraintLayout (constraints, modifier = Modifier.fillMaxSize()){
                Box(modifier = Modifier.background(Color.Green).layoutId("greenBox"))
                Box(modifier = Modifier.background(Color.Red).layoutId("redBox"))


            }

//            ComposeTutorialTheme {
//
//                val snackBarHostState = remember {
//                    SnackbarHostState()
//                }
//
//                var textFieldState by remember {
//                    mutableStateOf("")
//                }
//                val snackBarScope = rememberCoroutineScope()
//                Scaffold(
//                    modifier = Modifier
//                        .fillMaxSize(),
//                    snackbarHost = {
//                        SnackbarHost(snackBarHostState) { data ->
//                            Snackbar(
//                                containerColor = Color.Black,
//                                actionColor = Color.White,
//                                snackbarData = data
//                            )
//                        }
//                    }
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(it)
//                            ,
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.Center
//                    ) {
//
//                        OutlinedTextField(
//                            value = textFieldState,
//                            label = {
//                                Text(text = "Enter name")
//                            },
//                            onValueChange = {
//                                textFieldState = it
//                            },
//                            singleLine = true,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(horizontal = 10.dp)
//                        )
//
//
//                            Spacer(modifier = Modifier
//                                .height(4.dp)
//                                .fillMaxWidth())
//                            Button(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(horizontal = 10.dp),
//                                onClick = {
//                                    snackBarScope.launch {
//                                        val snackBarResult = snackBarHostState.showSnackbar(
//                                            message = "Congratulations! $textFieldState has created!",
//                                            withDismissAction = true,
//                                            actionLabel = "Cancel")
//
//                                        if(snackBarResult == SnackbarResult.ActionPerformed){
//                                            snackBarHostState.showSnackbar("Action Canceled.")
//                                        }
//                                    }
//                                }
//                            ) {
//                                Text(
//                                    text = if (textFieldState.isBlank()) {
//                                    "Create"
//                                } else {
//                                    "Create \"$textFieldState\""
//                                }
//                                )
//                        }
//                    }
//                }
//            }


            // For showing list please comment above codes

            LazyColumn {

                itemsIndexed(
                    listOf("this", "is", "jetpack", "compose")
                ) { index, string ->

                    Text(
                        text = string,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp)
                    )

                }
            }
        }
    }
}





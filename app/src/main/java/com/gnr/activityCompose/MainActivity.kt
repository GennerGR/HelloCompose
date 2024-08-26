package com.gnr.activityCompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewContainer()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun ViewContainer(){
    Scaffold (
        topBar = {Toolbar()},
        content = { paddingValues ->
            Content(modifier = Modifier.padding(paddingValues))
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(){
    TopAppBar(title = { Text(text = "GennerDevProfile")})
}

@Composable
fun Content(modifier: Modifier = Modifier) {

    var counter by rememberSaveable { mutableStateOf(0) }

    LazyColumn(
        modifier = Modifier
            .background(Color.Gray)
            .padding(16.dp)
            .fillMaxSize()
    ) {
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp),
                painter = painterResource(id = R.drawable.top),
                contentDescription = null
            )
            Row (modifier = Modifier.padding(top = 8.dp, start = 5.dp)){
                Image(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "like",
                    modifier = Modifier.clickable { counter++ }
                )
                Text(text = counter.toString(), color = Color.White, modifier = Modifier.padding(start = 4.dp))
            }
            Text(
                text = "GennerDev",
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                textAlign = TextAlign.Center
            )
            Text(text = "Android Dev", color = Color.White, modifier = Modifier.padding(top = 8.dp))
            Text(
                text = "2 Semanas exp",
                color = Color.White,
                modifier = Modifier.padding(top = 5.dp)
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 5.dp)
            ) {
                item {
                    Text(
                        text = "Stack: ",
                        color = Color.White,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = "Kotlin",
                        color = Color.White,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = "Python",
                        color = Color.White,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(text = "Js", color = Color.White, modifier = Modifier.padding(end = 8.dp))
                    Text(
                        text = "Flet",
                        color = Color.White,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(text = "JAVA", color = Color.White)
                }
            }
        }
    }
}






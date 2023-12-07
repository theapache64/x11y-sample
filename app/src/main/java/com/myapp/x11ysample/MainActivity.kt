package com.myapp.x11ysample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.myapp.x11ysample.ui.theme.X11ySampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            X11ySampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LandingPage()
                }
            }
        }
    }
    @Composable
    private fun SmallBox() {
        var clicked by remember { mutableStateOf(false) }
        Box(
            Modifier
                .size(100.dp)
                .background(if (clicked) Color.DarkGray else Color.LightGray)
        ) {
            Box(
                Modifier
                    .align(Alignment.Center)
                    .clickable { clicked = !clicked }
                    .background(Color.Black)
                    .size(1.dp)
            )
        }
    }

    @Composable
    private fun LargeBox() {
        var clicked by remember { mutableStateOf(false) }
        Box(
            Modifier
                .size(100.dp)
                .background(if (clicked) Color.DarkGray else Color.LightGray)
        ) {
            Box(
                Modifier
                    .align(Alignment.Center)
                    .clickable { clicked = !clicked }
                    .background(Color.Black)
                    .sizeIn(minWidth = 48.dp, minHeight = 48.dp)
            )
        }
    }
}

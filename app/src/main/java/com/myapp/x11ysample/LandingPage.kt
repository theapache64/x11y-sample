package com.myapp.x11ysample

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

@Composable
fun LandingPage(
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        item {
            MastheadWidget()
        }

        items(10) { index ->
            HorizontalMovies(trayIndex = index)
        }
    }
}

val Purple = Color(0xFF794CE2)

@Composable
fun MastheadWidget() {
    Box(
        modifier = Modifier.semantics(mergeDescendants = true) { heading() }
    ) {

        val context = LocalContext.current

        // Image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(Purple),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "I AM IRON MAN")
        }

        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp),
            onClick = {
                Toast.makeText(context, "Opening watch page", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "WATCH NOW")
        }
    }
}


const val TAG_CATEGORY_HEADING = "category_heading"

@Composable
fun HorizontalMovies(
    trayIndex: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(top = 7.dp)
    ) {
        Text(
            text = "Category $trayIndex",
            modifier = Modifier
                .padding(bottom = 5.dp)
                .testTag(TAG_CATEGORY_HEADING)
                .semantics { heading() }
        )
        LazyRow {
            items(20) { index ->
                Column(
                    modifier = Modifier
                        .padding(horizontal = 5.dp)
                        .semantics(mergeDescendants = true) {}
                ) {
                    Box(
                        modifier = Modifier
                            .width(120.dp)
                            .height(170.dp)
                            .background(Purple, shape = RoundedCornerShape(4.dp))
                            .clearAndSetSemantics { },
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(text = "MOVIE $trayIndex-$index")
                    }

                    Text(text = "MOVIE $trayIndex-$index")
                }
            }
        }
    }
}

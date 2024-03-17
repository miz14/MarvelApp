package com.example.marvel

import android.util.Size
import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.marvel.ui.theme.MarvelTheme

@Composable
fun MarvelApp() {

        Scaffold(
            topBar = {
                MarvelAppBar(false, {})
            },
        ) { innerPadding ->

            MarvelAppBackground {
                Box(
                    modifier = Modifier
                        .padding(innerPadding)
                        .background(MaterialTheme.colorScheme.primary)
                ) {
                    Text("1")
                }
            }
        }

}

@Composable
fun MarvelAppBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
) {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(R.drawable.marvel_logo),
                contentDescription = null,
                modifier = Modifier.height(40.dp),
                contentScale = ContentScale.Inside
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        )
    )
}

@Composable
fun MarvelAppBackground(
    content: @Composable() () -> Unit,
) {
    var color2 = MaterialTheme.colorScheme.onBackground
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)

            .drawBehind {
                val path = Path().apply {
                    val x = size.width
                    val y = size.height
                    moveTo(x, 0f)
                    lineTo(x, y)
                    lineTo(0f, y)
                    close()
                }

                drawPath(
                    path = path,
                    color = color2
                )
            }



    ) {
        content()
    }
}

@Preview
@Composable
fun TestApp() {

    MarvelTheme {
        MarvelApp()
    }
}




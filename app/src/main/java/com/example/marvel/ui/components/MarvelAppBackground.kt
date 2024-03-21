package com.example.marvel.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Path

@Composable
fun MarvelAppBackground(
    content: @Composable () -> Unit,
) {
    val color2 = MaterialTheme.colorScheme.onBackground
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)

            .drawBehind {
                val path = Path().apply {
                    val x = size.width
                    val y = size.height
                    moveTo(x, y / 2.5f)
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
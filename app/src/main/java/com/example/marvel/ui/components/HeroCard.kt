package com.example.marvel.ui.components

import androidx.compose.runtime.Composable
import coil.compose.AsyncImage

@Composable
fun HeroCard(

) {
    AsyncImage(
        model = "https://example.com/image.jpg",
        contentDescription = null,
    )
}
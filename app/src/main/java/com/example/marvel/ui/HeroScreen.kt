package com.example.marvel.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun HeroScreen(
    hero: Hero
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AsyncImage(
            model = hero.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            modifier = Modifier
                .padding(20.dp, 40.dp)
                .align(Alignment.BottomStart)
        ) {
            Text(
                text = hero.name,
                style = MaterialTheme.typography.titleLarge,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = hero.desc,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}
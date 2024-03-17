@file:Suppress("UNUSED_EXPRESSION")

package com.example.marvel.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.marvel.ui.Hero

@Composable
fun HeroCard(
    hero: Hero,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .width(400.dp)
            .padding(20.dp)
            .clip(RoundedCornerShape(18.dp))
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
                .padding(30.dp)
                .align(Alignment.BottomStart)


        ) {
            Text(
                text = hero.name,
                style = MaterialTheme.typography.titleLarge,
            )
        }
    }
}
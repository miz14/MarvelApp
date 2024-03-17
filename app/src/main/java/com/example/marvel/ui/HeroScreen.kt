package com.example.marvel.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
@Composable
fun HeroScreen(
    hero: Hero
) {
    Column {
        Text(text = hero.name)
        Text(text = hero.desc)
    }
}
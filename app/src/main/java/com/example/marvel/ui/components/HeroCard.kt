package com.example.marvel.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.ImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.compose.ImagePainter.State
import com.example.marvel.R

@Composable
fun HeroCard(

) {
    val painter = rememberImagePainter(
        data = "https://cdn0.iconfinder.com/data/icons/video-games-8/24/video_game_play_pokemon_pikachu-1024.png",
        builder = {

        }
    )
    val painterState = painter.state
    Image(
        painter = painter,
        contentDescription = null
    )

}
@Preview
@Composable
fun PreviewHeroCard() {
    HeroCard()
}


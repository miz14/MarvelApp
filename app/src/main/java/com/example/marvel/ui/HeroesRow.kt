package com.example.marvel.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HeroesRow() {
    val state = rememberLazyListState()

    val snappingLayout = remember(state) { SnapLayoutInfoProvider(state) }
    val flingBehavior = rememberSnapFlingBehavior(snappingLayout)
    LazyRow(
        modifier = Modifier
            .fillMaxSize(),

        state = state,
        verticalAlignment = Alignment.CenterVertically,
        flingBehavior = flingBehavior

    ){
        items(100) { index ->
            Box(
                modifier = Modifier
                    .size(300.dp)
                    .padding(10.dp)
                    .background(Color.Red)
            ) {
                Text(text = index.toString())
            }
        }

    }
}

@Preview
@Composable
fun PreviewHeroesRow(){
    HeroesRow()
}

// https://i.pinimg.com/736x/6f/3a/a5/6f3aa5c8784e60563d787bceab7c8253.jpg
// Deadpool
// Please don’t make the super suit green...or animated!

// https://cdn1.ozone.ru/s3/multimedia-x/6296330757.jpg
// Iron Man
//I AM IRON MAN

// https://comicvine.gamespot.com/a/uploads/original/11148/111483657/8268003-spider-man_%28no_way_home%29.jpg
// Spider Man
// In iron suit
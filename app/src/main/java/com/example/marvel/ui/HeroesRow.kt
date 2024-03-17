package com.example.marvel.ui

import android.icu.text.IDNA.Info
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.marvel.R
import com.example.marvel.ui.theme.MarvelTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HeroesRow() {
    val state = rememberLazyListState()

    val snappingLayout = remember(state) { SnapLayoutInfoProvider(state) }
    val flingBehavior = rememberSnapFlingBehavior(snappingLayout)

    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        state = state,
        verticalAlignment = Alignment.CenterVertically,
        flingBehavior = flingBehavior

    ){
        items(10) { index ->
            val painter = painterResource(R.drawable.test_image)
            Card(
                modifier = Modifier
                    .fillParentMaxWidth()
                    .padding(20.dp)
                    .clip(RoundedCornerShape(18.dp))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Image(
                        painter = painter,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.BottomStart)


                    ) {
                        Text(
                            text = "title",
                            style = MaterialTheme.typography.titleLarge,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "descr",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

            }
        }

    }
}

@Preview
@Composable
fun PreviewHeroesRow(){
    MarvelTheme {
        HeroesRow()
    }
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
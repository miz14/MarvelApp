package com.example.marvel.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.marvel.R
import com.example.marvel.ui.components.HeroCard
import com.example.marvel.ui.components.MarvelAppBackground

@ExperimentalFoundationApi
@Composable
fun StartScreen(
    onClick: (Int) -> Unit,
    innerPadding: PaddingValues,
    heroes: List<Hero>
) {
    MarvelAppBackground {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)

        ) {
            Text(
                stringResource(R.string.choose_hero),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(40.dp))
            val state = rememberLazyListState()

            val snappingLayout = remember(state) { SnapLayoutInfoProvider(state) }
            val flingBehavior = rememberSnapFlingBehavior(snappingLayout)

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                state = state,
                verticalAlignment = Alignment.CenterVertically,
                flingBehavior = flingBehavior

            ) {
                items(heroes.size) { idx ->
                    HeroCard(
                        hero = Heroes[idx],
                        modifier = Modifier
                            .clickable { onClick(idx) }
                    )
                }
            }
        }
    }
}
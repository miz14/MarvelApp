package com.example.marvel.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.marvel.R
import com.example.marvel.models.Hero
import com.example.marvel.navigation.MarvelResponseHeroesState
import com.example.marvel.ui.components.HeroCard
import com.example.marvel.ui.components.MarvelAppBackground

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StartScreen(
    onClick: (Int) -> Unit,
    innerPadding: PaddingValues,
    heroes: List<Hero>,
    responseHeroState: String
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

            val flingBehavior = rememberSnapFlingBehavior(state)

            if (responseHeroState != MarvelResponseHeroesState.SUCCESS) {
                Box(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    if (responseHeroState == MarvelResponseHeroesState.LOADING) {
                        Text(
                            text = "Loading Data",
                            modifier = Modifier
                                .padding(20.dp),
                            textAlign = TextAlign.Center
                        )
                    } else {
                        Text(
                            text = "Loading Error",
                            modifier = Modifier
                                .padding(20.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }

            } else {

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    state = state,
                    verticalAlignment = Alignment.CenterVertically,
                    flingBehavior = flingBehavior

                ) {
                    items(heroes) { hero ->
                        HeroCard(
                            hero = hero,
                            onClick = { onClick(hero.id) },
                            modifier = Modifier
                                .fillParentMaxWidth()
                        )
                    }
                }
            }

        }
    }
}

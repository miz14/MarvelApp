package com.example.marvel.navigation

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.marvel.models.Hero
import com.example.marvel.network.MarvelApiService
import com.example.marvel.ui.HeroScreen
import com.example.marvel.ui.StartScreen

enum class MarvelScreen {
    StartScreen,
    HeroScreen
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AppNavigator(
    innerPadding: PaddingValues,
    navController: NavHostController,
    canGoBack: MutableState<Boolean>,
    appBarNavigateBack: MutableState<() -> Unit>

) {
    val heroes = remember { mutableStateOf<List<Hero>>(emptyList()) }
    NavHost(
        navController = navController,
        startDestination = MarvelScreen.StartScreen.name,
    ) {

        composable(route = MarvelScreen.StartScreen.name){
            LaunchedEffect(key1 = true) {
                heroes.value = MarvelApiService.getHeroes(5)
            }
            StartScreen(
                onClick = { i ->
                    if (navController.currentBackStackEntry?.destination?.route == MarvelScreen.StartScreen.name) {
                        navController.navigate(MarvelScreen.HeroScreen.name + "/$i")
                        canGoBack.value = true

                    }
                },
                innerPadding = innerPadding,
                heroes = heroes.value
            )
            val activity = (LocalContext.current as? Activity)
            BackHandler(
                onBack = {
                    activity?.finish()
                }
            )
        }
        composable(
            route = MarvelScreen.HeroScreen.name + "/{id}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType }
            )
        ) { navBackStackEntry ->

            val id = navBackStackEntry.arguments?.getInt("id")
            val hero = heroes.value.find {hero -> hero.id == id}
            if (hero != null) {
                HeroScreen(
                    hero = hero
                )
            }

            appBarNavigateBack.value = {
                navController.navigate(MarvelScreen.StartScreen.name)
                canGoBack.value = false
            }
            BackHandler(
                onBack = {
                    navController.navigate(MarvelScreen.StartScreen.name)
                    canGoBack.value = false
                }
            )
        }
    }
}
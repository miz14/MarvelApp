package com.example.marvel.navigation

import android.app.Activity
import android.app.ActivityManager
import android.app.ActivityOptions
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.marvel.ui.HeroScreen
import com.example.marvel.ui.Heroes
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
    NavHost(
        navController = navController,
        startDestination = MarvelScreen.StartScreen.name,
    ) {
        composable(route = MarvelScreen.StartScreen.name) {

            StartScreen(
                onClick = { i ->
                    if (navController.currentBackStackEntry?.destination?.route == MarvelScreen.StartScreen.name) {
                        navController.navigate(MarvelScreen.HeroScreen.name + "/$i")
                        canGoBack.value = true

                    }
                },
                innerPadding = innerPadding,
                heroes = Heroes
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

            val a = navBackStackEntry.arguments?.getInt("id")
            HeroScreen(
                hero = Heroes[a!!]
            )

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
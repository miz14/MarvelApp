package com.example.marvel

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.marvel.navigation.AppNavigator
import com.example.marvel.ui.components.MarvelAppBar
import com.example.marvel.ui.theme.MarvelTheme


@Composable
fun MarvelScreen(
    navController: NavHostController = rememberNavController(),
) {
    val canGoBack = remember {
        mutableStateOf(false)
    }
    val appBarNavigateBack = remember {
        mutableStateOf({})
    }

    Scaffold(
        topBar = {
            MarvelAppBar(canGoBack, appBarNavigateBack)
        },
    ) { innerPadding ->

        AppNavigator(innerPadding, navController, canGoBack, appBarNavigateBack)
    }
}



@Preview
@Composable
fun TestApp() {
    MarvelTheme {
        MarvelScreen()
    }
}




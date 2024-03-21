package com.example.marvel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import com.example.marvel.ui.theme.MarvelTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.marvel.navigation.AppNavigator
import com.example.marvel.ui.HeroScreen
import com.example.marvel.ui.Heroes
import com.example.marvel.ui.StartScreen
import com.example.marvel.ui.components.MarvelAppBar


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




package com.example.marvel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.example.marvel.ui.HeroScreen
import com.example.marvel.ui.Heroes
import com.example.marvel.ui.StartScreen

enum class MarvelScreen() {
    StartScreen,
    HeroScreen
}

@Composable
fun AppNavigator(
    innerPadding: PaddingValues,
    navController: NavHostController,
    canGoBack: MutableState<Boolean>

) {
    NavHost(
        navController = navController,
        startDestination = MarvelScreen.StartScreen.name,
    ) {
        composable(route = MarvelScreen.StartScreen.name) {
            StartScreen(
                onClick = {
                    i -> navController.navigate(MarvelScreen.HeroScreen.name + "/$i")
                    canGoBack.value = true

                },
                innerPadding = innerPadding,
                heroes = Heroes)

        }
        composable(
            route = MarvelScreen.HeroScreen.name + "/{id}",
            arguments = listOf(
                navArgument("id") {type = NavType.IntType}
            )
        ) { navBackStackEntry ->
            val a = navBackStackEntry.arguments?.getInt("id")
            HeroScreen(hero = Heroes[a!!])
        }
    }
}

@Composable
fun MarvelApp(
    navController: NavHostController = rememberNavController(),
) {
    val canGoBack = remember {
        mutableStateOf(false)
    }
        Scaffold(
            topBar = {
                MarvelAppBar(canGoBack, {navController.navigateUp()})
            },
        ) { innerPadding ->
                AppNavigator(innerPadding, navController, canGoBack)
        }
}

@Composable
fun MarvelAppBar(
    canGoBack: MutableState<Boolean>,
    navigateUp: () -> Unit,
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        title = {
            if (!canGoBack.value) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(R.drawable.marvel_logo),
                        contentDescription = null,
                        modifier = Modifier.height(40.dp),
                        contentScale = ContentScale.Inside
                    )
                }
            }
        },
        navigationIcon = {
            if (canGoBack.value) {
                IconButton(onClick = {canGoBack.value = false
                    navigateUp()}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }
            }
        },
        actions = {
            Box(
                modifier = Modifier.size(40.dp)
            )
        }
    )
}

@Composable
fun MarvelAppBackground(
    content: @Composable() () -> Unit,
) {
    val color2 = MaterialTheme.colorScheme.onBackground
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)

            .drawBehind {
                val path = Path().apply {
                    val x = size.width
                    val y = size.height
                    moveTo(x, y / 2.5f)
                    lineTo(x, y)
                    lineTo(0f, y)
                    close()
                }

                drawPath(
                    path = path,
                    color = color2
                )
            }



    ) {
        content()
    }
}

@Preview
@Composable
fun TestApp() {

    MarvelTheme {
        MarvelApp()
    }
}




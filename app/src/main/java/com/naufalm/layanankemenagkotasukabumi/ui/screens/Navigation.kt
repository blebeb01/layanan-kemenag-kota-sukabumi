package com.naufalm.layanankemenagkotasukabumi.ui.screens

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.naufalm.layanankemenagkotasukabumi.ui.screens.bimas_screen.BimasScreen
import com.naufalm.layanankemenagkotasukabumi.ui.screens.haji_screen.HajiScreen
import com.naufalm.layanankemenagkotasukabumi.ui.screens.home_screen.HomeScreen
import com.naufalm.layanankemenagkotasukabumi.ui.screens.login_screen.LoginScreen
import com.naufalm.layanankemenagkotasukabumi.ui.screens.pai_screen.PaiScreen
import com.naufalm.layanankemenagkotasukabumi.ui.screens.register_screen.RegisterScreen
import com.naufalm.layanankemenagkotasukabumi.ui.screens.subbag_tu_screen.SubbagTuScreen

const val SCREEN_TRANSITION_MILLIS = 500

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home_screen",
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                animationSpec = tween(SCREEN_TRANSITION_MILLIS)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                animationSpec = tween(SCREEN_TRANSITION_MILLIS)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.End,
                animationSpec = tween(SCREEN_TRANSITION_MILLIS)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.End,
                animationSpec = tween(SCREEN_TRANSITION_MILLIS)
            )
        }
    ) {
        composable(
            "home_screen"
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            "subbag_tu_screen",
        ) {
            SubbagTuScreen(
                navController = navController
            )
        }

        composable("haji_screen") {
            HajiScreen(
                navController = navController
            )
        }

        composable("bimas_screen") {
            BimasScreen(
                navController = navController
            )
        }

        composable("pontren_screen") {
            BimasScreen(
                navController = navController
            )
        }

        composable("penmad_screen") {
            BimasScreen(
                navController = navController
            )
        }

        composable("zakat_screen") {
            BimasScreen(
                navController = navController
            )
        }

        composable("pai_screen") {
            PaiScreen(
                navController = navController
            )
        }

        composable("login_screen") {
            LoginScreen(
                navController = navController
            )
        }

        composable("register_screen") {
            RegisterScreen(
                navController = navController
            )
        }
    }
}
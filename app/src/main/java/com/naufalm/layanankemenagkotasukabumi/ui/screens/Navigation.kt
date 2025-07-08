package com.naufalm.layanankemenagkotasukabumi.ui.screens

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.naufalm.layanankemenagkotasukabumi.ui.screens.bimas_screen.BimasScreen
import com.naufalm.layanankemenagkotasukabumi.ui.screens.bimas_screen.BimasViewModel
import com.naufalm.layanankemenagkotasukabumi.ui.screens.haji_screen.HajiScreen
import com.naufalm.layanankemenagkotasukabumi.ui.screens.haji_screen.HajiViewModel
import com.naufalm.layanankemenagkotasukabumi.ui.screens.home_screen.HomeScreen
import com.naufalm.layanankemenagkotasukabumi.ui.screens.pai_screen.PaiScreen
import com.naufalm.layanankemenagkotasukabumi.ui.screens.pai_screen.PaiViewModel
import com.naufalm.layanankemenagkotasukabumi.ui.screens.profil_kemenag_screen.ProfilKemenagScreen
import com.naufalm.layanankemenagkotasukabumi.ui.screens.profil_kemenag_screen.ProfilKemenagViewModel
import com.naufalm.layanankemenagkotasukabumi.ui.screens.subbag_tu_screen.SubbagTuScreen
import com.naufalm.layanankemenagkotasukabumi.ui.screens.subbag_tu_screen.SubbagTuViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val profilKemenagViewModel = ProfilKemenagViewModel()
    val infoSubbagTuViewModel = SubbagTuViewModel()
    val infoHajiViewModel = HajiViewModel()
    val infoBimasViewModel = BimasViewModel()




    val infoPaiViewModel = PaiViewModel()

    NavHost(navController = navController,
        startDestination = "home_screen",
        enterTransition = { slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Up) }
    ) {
        composable(
            "home_screen"
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            "profil_kemenag_screen"
        ) {
            ProfilKemenagScreen(
                navController = navController,
                profilKemenag = profilKemenagViewModel.profilKemenagResponse
            )
            profilKemenagViewModel.getProfilKemenag()
        }

        composable("subbag_tu_screen") {
            SubbagTuScreen(
                navController = navController,
                infoSubbagTu = infoSubbagTuViewModel.infoSubbagTuResponse
            )
            infoSubbagTuViewModel.getInfoSubbagTu()
        }

        composable("haji_screen") {
            HajiScreen(
                navController = navController,
                infoHaji = infoHajiViewModel.infoHajiResponse
            )
            infoHajiViewModel.getInfoHaji()
        }

        composable("bimas_screen") {
            BimasScreen(
                navController = navController,
                infoBimas = infoBimasViewModel.infoBimasResponse
            )
            infoBimasViewModel.getInfoBimas()
        }

        composable("pontren_screen") {
            BimasScreen(
                navController = navController,
                infoBimas = infoBimasViewModel.infoBimasResponse
            )
            infoBimasViewModel.getInfoBimas()
        }

        composable("penmad_screen") {
            BimasScreen(
                navController = navController,
                infoBimas = infoBimasViewModel.infoBimasResponse
            )
            infoBimasViewModel.getInfoBimas()
        }

        composable("zakat_screen") {
            BimasScreen(
                navController = navController,
                infoBimas = infoBimasViewModel.infoBimasResponse
            )
            infoBimasViewModel.getInfoBimas()
        }

        composable("pai_screen") {
            PaiScreen(
                navController = navController,
                infoPai = infoPaiViewModel.infoPaiResponse

            )
            infoPaiViewModel.getInfoPai()
        }
    }
}
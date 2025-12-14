package com.naufalm.layanankemenagkotasukabumi.ui.screens.pai_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.naufalm.layanankemenagkotasukabumi.components.MyLargeTopAppBar
import com.naufalm.layanankemenagkotasukabumi.ui.theme.jakartaSansFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaiScreen(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    val viewModel: PaiViewModel = viewModel()
    val infoPai = viewModel.infoPaiResponse

    LaunchedEffect(Unit) {
        viewModel.getInfoPai()
    }

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MyLargeTopAppBar(
                title = "Pendidikan Agama Islam",
                navigateBack = { navController.navigateUp() },
                scrollBehavior = scrollBehavior
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            infoPai.forEach { pai ->
                Text(
                    text = pai,
                    fontFamily = jakartaSansFontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            }
        }
    }
}
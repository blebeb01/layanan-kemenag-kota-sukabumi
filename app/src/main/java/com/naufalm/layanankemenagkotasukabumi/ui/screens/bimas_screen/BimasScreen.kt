package com.naufalm.layanankemenagkotasukabumi.ui.screens.bimas_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.naufalm.layanankemenagkotasukabumi.components.MyLargeTopAppBar
import com.naufalm.layanankemenagkotasukabumi.ui.theme.jakartaSansFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BimasScreen(navController: NavController, infoBimas: String) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MyLargeTopAppBar(
                title = "Bimbingan Masyarakat",
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
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = infoBimas,
                fontFamily = jakartaSansFontFamily,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(5000.dp))
            Text(text = "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW")
        }
    }
}
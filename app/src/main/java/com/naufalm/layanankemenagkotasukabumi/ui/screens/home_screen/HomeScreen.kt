package com.naufalm.layanankemenagkotasukabumi.ui.screens.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.naufalm.layanankemenagkotasukabumi.R
import com.naufalm.layanankemenagkotasukabumi.components.AboutButton
import com.naufalm.layanankemenagkotasukabumi.components.SquareButton
import com.naufalm.layanankemenagkotasukabumi.ui.theme.jakartaSansFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val profilViewModel: ProfilKemenagViewModel = viewModel()
    val profilKemenag = profilViewModel.profilKemenagResponse
    val isLoading = profilViewModel.isLoading

    LaunchedEffect(Unit) {
        profilViewModel.getProfilKemenag()
    }

    Scaffold(
        topBar = {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.35f),
                shape = RoundedCornerShape(bottomStart = 25.dp, bottomEnd = 25.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerHigh)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .windowInsetsPadding(WindowInsets.statusBars)
                        .padding(16.dp),
                ) {
                    Button(
                        modifier = Modifier
                            .align(Alignment.TopEnd),
                        onClick = { navController.navigate("login_screen") }
                    ) {
                        Text("Login")
                    }

                    Column(
                        modifier = Modifier
                            .align(Alignment.Center)
                    ) {
                        Text(
                            modifier = Modifier,
                            text = "Selamat Datang",
                            fontFamily = jakartaSansFontFamily,
                            fontWeight = FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Center,
                            maxLines = 1,
                            style = MaterialTheme.typography.headlineLarge
                        )
                    }
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(top = 55.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SquareButton(
                    image = painterResource(R.drawable.kaaba_icon),
                    title = "Sub Tata Usaha"
                ) { navController.navigate("subbag_tu_screen") }
                SquareButton(
                    image = painterResource(R.drawable.kaaba_icon),
                    title = "Haji dan Umrah"
                ) { navController.navigate("haji_screen") }
                SquareButton(
                    image = painterResource(R.drawable.kaaba_icon),
                    title = "Bimbingan Masyarakat"
                ) { navController.navigate("bimas_screen") }
                SquareButton(
                    image = painterResource(R.drawable.kaaba_icon),
                    title = "Pondok Pesantren"
                ) { navController.navigate("pontren_screen") }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SquareButton(
                    image = painterResource(R.drawable.kaaba_icon),
                    title = "Pendidikan Madrasah"
                ) { navController.navigate("haji_screen") }
                SquareButton(
                    image = painterResource(R.drawable.kaaba_icon),
                    title = "Zakat dan Wakaf"
                ) { navController.navigate("haji_screen") }
                SquareButton(
                    image = painterResource(R.drawable.kaaba_icon),
                    title = "Pendidikan Agama Islam"
                ) { navController.navigate("pai_screen") }
            }

            Spacer(modifier = Modifier.height(20.dp))

            AboutButton(profilKemenag = profilKemenag, isLoading = isLoading)
        }
    }
}
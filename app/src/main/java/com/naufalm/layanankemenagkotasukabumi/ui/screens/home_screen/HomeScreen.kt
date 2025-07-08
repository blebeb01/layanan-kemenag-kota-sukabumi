package com.naufalm.layanankemenagkotasukabumi.ui.screens.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.naufalm.layanankemenagkotasukabumi.R
import com.naufalm.layanankemenagkotasukabumi.components.SquareButton
import com.naufalm.layanankemenagkotasukabumi.ui.theme.jakartaSansFontFamily

@Composable
fun HomeScreen(navController: NavController) {
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
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .windowInsetsPadding(WindowInsets.statusBars),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
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
        },
        floatingActionButton = {
            Button(
                modifier = Modifier.size(width = 150.dp, height = 60.dp),
                onClick = { navController.navigate("profil_kemenag_screen") },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                contentPadding = PaddingValues(3.dp)
            ) {
                Text(
                    text = "Profil Kemenag Kota Sukabumi",
                    fontFamily = jakartaSansFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    textAlign = TextAlign.Center
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(top = 55.dp),
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
                ) { navController.navigate("haji_screen") }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
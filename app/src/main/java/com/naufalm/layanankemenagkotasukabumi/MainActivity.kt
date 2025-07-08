package com.naufalm.layanankemenagkotasukabumi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.naufalm.layanankemenagkotasukabumi.ui.screens.Navigation
import com.naufalm.layanankemenagkotasukabumi.ui.theme.LayananKemenagKotaSukabumiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayananKemenagKotaSukabumiTheme {
                Navigation()
            }
        }
    }
}
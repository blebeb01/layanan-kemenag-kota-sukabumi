package com.naufalm.layanankemenagkotasukabumi.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.naufalm.layanankemenagkotasukabumi.ui.theme.MintGreen01
import com.naufalm.layanankemenagkotasukabumi.ui.theme.MintGreen02
import com.naufalm.layanankemenagkotasukabumi.ui.theme.jakartaSansFontFamily

/**
 * @param title Top app bar title
 * @param scrollBehavior Top app bar scroll behavior
 * @param navigateBack Callback to navigate back
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyLargeTopAppBar(
    title: String,
    scrollBehavior: TopAppBarScrollBehavior,
    navigateBack: () -> Unit
) {
    LargeTopAppBar(
        title = {
            Text(
                title,
                fontFamily = jakartaSansFontFamily,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                maxLines = 1,
                style = MaterialTheme.typography.headlineLarge
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MintGreen01,
            scrolledContainerColor = MintGreen02,
            titleContentColor = Color.Black
        ),
        navigationIcon = {
            IconButton(
                onClick = navigateBack
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}
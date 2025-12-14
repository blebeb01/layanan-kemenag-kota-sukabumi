package com.naufalm.layanankemenagkotasukabumi.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = MintGreen01,
    onPrimary = Color.Black,
    primaryContainer = MintGreen03,
    onPrimaryContainer = Color.White,
    secondary = MintGreen02,
    onSecondary = Color.White,
    secondaryContainer = MintGreen02,
    onSecondaryContainer = Color.Black,
    tertiary = Pink40,
    onTertiary = Color.White,
    background = Color.White,
    onBackground = Color.Black,
    surface = MintGreen01,
    surfaceContainerHigh = MintGreen01,
    onSurface = Color.Black
)

private val LightColorScheme = lightColorScheme(
    primary = MintGreen01,
    onPrimary = Color.Black,
    primaryContainer = MintGreen03,
    onPrimaryContainer = Color.White,
    secondary = MintGreen02,
    onSecondary = Color.White,
    secondaryContainer = MintGreen02,
    onSecondaryContainer = Color.Black,
    tertiary = Pink40,
    onTertiary = Color.White,
    background = Color.White,
    onBackground = Color.Black,
    surface = MintGreen01,
    surfaceContainerHigh = MintGreen01,
    onSurface = Color.Black
)

@Composable
fun LayananKemenagKotaSukabumiTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
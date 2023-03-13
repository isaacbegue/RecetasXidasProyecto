package com.isaacbeguedevs.recetasxidas.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = NaranjitaClaro,
    onPrimary = Blanco,
    background = BackgroundDark,
    onBackground = Blanco,
    surface = SurfaceDark,
    onSurface = Blanco
)

private val LightColorPalette = lightColors(
    primary = NaranjitaClaro,
    onPrimary = Blanco,
    background = Blanco,
    onBackground = NoTanNegro,
    surface = Blanco,
    onSurface = NoTanNegro

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun RecetasXidasTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
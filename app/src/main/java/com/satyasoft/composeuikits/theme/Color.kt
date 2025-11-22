package com.satyasoft.composeuikits.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// Brand Colors
val PrimaryBlue = Color(0xFF007AFF)
val SecondaryPurple = Color(0xFF5E5CE6)
val AccentGreen = Color(0xFF34C759)

val ErrorRed = Color(0xFFFF3B30)
//val WarningYellow = Color(0xFFFFCC00)

// Light Theme Colors
val LightColorScheme = lightColorScheme(
    primary = PrimaryBlue,
    onPrimary = Color.White,

    secondary = SecondaryPurple,
    onSecondary = Color.White,

    tertiary = AccentGreen,
    onTertiary = Color.White,

    error = ErrorRed,
    onError = Color.White,

    background = Color(0xFFFDFDFD),
    onBackground = Color(0xFF1B1B1B),

    surface = Color.White,
    onSurface = Color(0xFF1B1B1B),

    surfaceVariant = Color(0xFFE5E5E5),
    onSurfaceVariant = Color(0xFF494949),

    outline = Color(0xFF7C7C7C),

)

// Dark Theme Colors
val DarkColorScheme = darkColorScheme(
    primary = PrimaryBlue,
    onPrimary = Color.Black,

    secondary = SecondaryPurple,
    onSecondary = Color.Black,

    tertiary = AccentGreen,
    onTertiary = Color.Black,

    error = ErrorRed,
    onError = Color.Black,

    background = Color(0xFF121212),
    onBackground = Color(0xFFE3E3E3),

    surface = Color(0xFF1A1A1A),
    onSurface = Color(0xFFE3E3E3),

    surfaceVariant = Color(0xFF2A2A2A),
    onSurfaceVariant = Color(0xFFBBBBBB),

    outline = Color(0xFF8E8E8E),
)

package com.yigittepe.nearcampus1.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

internal val Ink = Color(0xFF002045)
internal val Navy = Color(0xFF1A365D)
internal val Gold = Color(0xFFFED488)
internal val GoldText = Color(0xFF775A19)
internal val Canvas = Color(0xFFF8F9FA)
internal val Muted = Color(0xFF74777F)
internal val Border = Color(0xFFE1E3E4)

@Composable
internal fun NearCampusTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Ink,
            secondary = GoldText,
            surface = Color.White,
            background = Canvas,
            onPrimary = Color.White,
            onSurface = Color(0xFF191C1D)
        ),
        content = content
    )
}

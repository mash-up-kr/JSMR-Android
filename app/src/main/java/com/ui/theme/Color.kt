package com.ui.theme

import androidx.compose.ui.graphics.Color

object Color {
    val Black = Color(0xFF000000)
    val White = Color(0xFFFFFFFF)

    val Grey100 = getThemeStateColor(DarkColor.Grey100, LightColor.Grey100)
    val Grey200 = getThemeStateColor(DarkColor.Grey200, LightColor.Grey200)
    val Grey300 = getThemeStateColor(DarkColor.Grey300, LightColor.Grey300)
    val Grey400 = getThemeStateColor(DarkColor.Grey400, LightColor.Grey400)
    val Grey500 = getThemeStateColor(DarkColor.Grey500, LightColor.Grey500)
    val Grey600 = getThemeStateColor(DarkColor.Grey600, LightColor.Grey600)
    val Grey700 = getThemeStateColor(DarkColor.Grey700, LightColor.Grey700)
    val Grey800 = getThemeStateColor(DarkColor.Grey800, LightColor.Grey800)

    val Main100 = getThemeStateColor(DarkColor.Main100, LightColor.Main100)
    val Main200 = getThemeStateColor(DarkColor.Main200, LightColor.Main200)
    val Main300 = getThemeStateColor(DarkColor.Main300, LightColor.Main300)

    val SubBlue = getThemeStateColor(DarkColor.SubBlue, LightColor.SubBlue)
    val SubPurple = getThemeStateColor(DarkColor.SubPurple, LightColor.SubPurple)
    val SubGreen = getThemeStateColor(DarkColor.SubGreen, LightColor.SubGreen)
    val SubYellow = getThemeStateColor(DarkColor.SubYellow, LightColor.SubYellow)
    val ErrorRed = getThemeStateColor(DarkColor.ErrorRed, LightColor.ErrorRed)

    val DarkBackground = Color(0xFF242424)
    val LightBackground = Color(0xFFF7F7F7)

    private fun getThemeStateColor(
        darkColor: Color,
        lightColor: Color
    ): Color {
        fun getDarkTheme(): Boolean {
            return ThemeState.darkModeState.value
        }

        return if (getDarkTheme()) {
            darkColor
        } else {
            lightColor
        }
    }
}

package com.ui.theme

import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.marryting.app.R

@OptIn(ExperimentalTextApi::class)
val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

@OptIn(ExperimentalTextApi::class)
val MontserratFont = GoogleFont(name = "Montserrat")

@OptIn(ExperimentalTextApi::class)
val MontserratFontFamily = FontFamily(
    Font(googleFont = MontserratFont, fontProvider = provider),
    Font(resId = R.font.montserrat_regular),
    Font(googleFont = MontserratFont, fontProvider = provider, weight = FontWeight.Light),
    Font(resId = R.font.montserrat_light, weight = FontWeight.Light),
    Font(googleFont = MontserratFont, fontProvider = provider, weight = FontWeight.Medium),
    Font(
        resId = R.font.montserrat_medium,
        weight = FontWeight.Medium
    ),
    Font(googleFont = MontserratFont, fontProvider = provider, weight = FontWeight.SemiBold),
    Font(
        resId = R.font.montserrat_semibold,
        weight = FontWeight.SemiBold
    ),
)

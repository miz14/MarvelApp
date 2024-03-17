package com.example.marvel.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.marvel.R
// Set of Material typography styles to start with
val Typography = Typography(
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_extra_bold)),
        fontWeight = FontWeight.Normal,
        color = White,
        fontSize = 28.sp,
        lineHeight = 32.sp,

    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_extra_bold)),
        fontWeight = FontWeight.Normal,
        color = White,
        fontSize = 34.sp,
        lineHeight = 38.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter_extra_bold)),
        fontWeight = FontWeight.Normal,
        color = White,
        fontSize = 22.sp,
        lineHeight = 30.sp,
        letterSpacing = 0.02.sp
    ),
)
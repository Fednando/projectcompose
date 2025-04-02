package br.com.core


import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val none: Dp = 0.dp,
    val spaceExtraSmall: Dp = 4.dp,
    val spaceExtraSmallMedium: Dp = 6.dp,
    val spaceSmall: Dp = 8.dp,
    val spaceMediumSmall: Dp = 12.dp,
    val spaceMedium: Dp = 16.dp,
    val spaceMediumLarge: Dp = 24.dp,
    val spaceLargeSmall: Dp = 32.dp,
    val spaceLarge: Dp = 40.dp,
    val spaceLargeMedium : Dp = 56.dp,
    val spaceExtraLarge: Dp = 64.dp,
    val spaceDoubleExtraLarge: Dp = 128.dp,
    val spaceTripleExtraLarge: Dp = 256.dp
)

val LocalSpacing = compositionLocalOf { Dimensions() }
package br.com.design_system.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Immutable
data class ButtonSizes(
    val textStyle: TextStyle,
    val minWidth: Dp,
    val height: Dp,
    val iconSize: Dp,
    val contentPadding: PaddingValues
)


object CvpButtonSizes {

    @Composable
    fun large(
        fontSize: TextStyle = MaterialTheme.typography.labelLarge
            .copy(fontSize = MaterialTheme.typography.bodyLarge.fontSize),
        minWidth: Dp = 84.dp,
        height: Dp = 56.dp,
        iconSize: Dp = 24.dp,
        contentPadding: PaddingValues = PaddingValues(start = 40.dp, end = 40.dp)
        ) : ButtonSizes = remember(
        fontSize,
        minWidth,
        height,
        iconSize,
        contentPadding
    ) {
        ButtonSizes(
            textStyle = fontSize,
            minWidth = minWidth,
            height = height,
            iconSize = iconSize,
            contentPadding = contentPadding
        )
    }

    @Composable
    fun medium(
        fontSize: TextStyle = MaterialTheme.typography.labelLarge
            .copy(fontSize = MaterialTheme.typography.bodyMedium.fontSize),
        minWidth: Dp = 120.dp,
        height: Dp = 48.dp,
        iconSize: Dp = 20.dp,
        contentPadding: PaddingValues = PaddingValues(start = 24.dp, end = 24.dp)
    ) : ButtonSizes = remember(
        fontSize,
        minWidth,
        height,
        iconSize,
        contentPadding
    ) {
        ButtonSizes(
            textStyle = fontSize,
            minWidth = minWidth,
            height = height,
            iconSize = iconSize,
            contentPadding = contentPadding
        )
    }
}
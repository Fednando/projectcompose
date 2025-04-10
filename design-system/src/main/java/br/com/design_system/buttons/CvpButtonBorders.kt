package br.com.design_system.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class ButtonBorders(
    val stroke: BorderStroke? = null,
    val disabled: BorderStroke? = stroke
)

object CvpButtonBorders{

    @Composable
    fun primary(
        width: Dp = 2.dp,
        strokeColor: Color = MaterialTheme.colorScheme.primary,
        disabled: Color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
    ) : ButtonBorders = remember(
        width,
        strokeColor,
        disabled
    ) {
        ButtonBorders(
            stroke = BorderStroke(width, strokeColor),
            disabled = BorderStroke(width, disabled)
        )
    }

    @Composable
    fun none() : ButtonBorders = remember {
        ButtonBorders()
    }
}
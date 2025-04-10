package br.com.design_system.buttons

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object CvpButtonsColors {
    @Composable
    fun primary(
        backgroundColor: Color = MaterialTheme.colorScheme.primary,
        contentColor: Color = MaterialTheme.colorScheme.onPrimary,
        disabledBackgroundColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
        disabledContentColor: Color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.3f)
    ) : ButtonColors = ButtonDefaults.buttonColors(
        containerColor = backgroundColor,
        contentColor = contentColor,
        disabledContainerColor = disabledBackgroundColor,
        disabledContentColor = disabledContentColor
    )

    @Composable
    fun secondary(
        backgroundColor: Color = MaterialTheme.colorScheme.primary,
        contentColor: Color = MaterialTheme.colorScheme.onPrimary,
        disabledBackgroundColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
        disabledContentColor: Color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.3f)
    ) : ButtonColors = ButtonDefaults.buttonColors(
        containerColor = backgroundColor,
        contentColor = contentColor,
        disabledContainerColor = disabledBackgroundColor,
        disabledContentColor = disabledContentColor
    )
}
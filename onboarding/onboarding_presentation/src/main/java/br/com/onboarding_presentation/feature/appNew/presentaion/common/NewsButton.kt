package br.com.onboarding_presentation.feature.appNew.presentaion.common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import br.com.core.LocalSpacing

@Composable
fun NewsButton(
    text: String,
    onClick: () -> Unit
) {

    val spacing = LocalSpacing.current

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(spacing.spaceExtraSmallMedium)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Composable
@Preview(showBackground = true, device = "id:pixel_7")
fun NewButtonPreview() {
    NewsButton(
        text = "Button",
        onClick = {}
    )
}
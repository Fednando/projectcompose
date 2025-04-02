package br.com.onboarding_presentation.feature.appNew.presentaion.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.com.calorietracker.ui.theme.BlueGray
import br.com.core.LocalSpacing

@Composable
fun PageIndicator(
    modifier: Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unSelectedColor: Color = BlueGray
) {

    val spacing = LocalSpacing.current

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        repeat(pageSize) { page ->
            Box(
                modifier = Modifier
                    .size(spacing.spaceMedium)
                    .clip(CircleShape)
                    .background(color = if (page == selectedPage)
                        selectedColor else unSelectedColor)
            )
        }
    }
}

@Composable
@Preview(showBackground = true, device = "id:pixel_7")
fun PageIndicatorPreview() {
    PageIndicator(
        modifier = Modifier,
        pageSize = 3,
        selectedPage = 1
    )
}

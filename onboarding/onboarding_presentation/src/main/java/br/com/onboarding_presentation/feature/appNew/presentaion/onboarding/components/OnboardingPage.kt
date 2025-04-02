package br.com.onboarding_presentation.feature.appNew.presentaion.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import br.com.core.LocalSpacing
import br.com.onboarding_presentation.R
import br.com.onboarding_presentation.feature.appNew.presentaion.onboarding.Page
import br.com.onboarding_presentation.feature.appNew.presentaion.onboarding.pages

@Composable
fun OnboardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {

    val spacing = LocalSpacing.current

    Column(modifier = modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(spacing.spaceMediumLarge))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = spacing.spaceMediumLarge),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = spacing.spaceMediumLarge),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(R.color.text_medium)
        )
    }
}

@Composable
@Preview(showBackground = true, device = "id:pixel_7")
fun OnboardingPagePreview() {
    OnboardingPage(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        page = pages.first()
    )
}
package br.com.onboarding_presentation.feature.calorie.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import br.com.onboarding_presentation.feature.calculator.CalculatorActivity
import br.com.core.LocalSpacing
import br.com.core.R
import br.com.onboarding_presentation.feature.appNew.AppNewActivity
import br.com.onboarding_presentation.feature.calorie.components.ActionButton

@Composable
fun WelcomeScreen(
    onNavigationToGender: () -> Unit
) {

    val spacing = LocalSpacing.current
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceMedium),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.welcome_text),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displayLarge
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = { onNavigationToGender() },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            isEnabled = true
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        ActionButton(
            text = stringResource(id = R.string.calculator),
            onClick = {
                context.startActivity(CalculatorActivity.newIntent(context))
            },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            isEnabled = true
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        ActionButton(
            text = stringResource(id = R.string.app_news),
            onClick = {
                context.startActivity(AppNewActivity.newIntent(context))
            },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            isEnabled = true
        )

    }
}
package br.com.onboarding_presentation.feature.appNew.presentaion.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.core.LocalSpacing
import br.com.onboarding_presentation.feature.appNew.presentaion.common.NewsButton
import br.com.onboarding_presentation.feature.appNew.presentaion.onboarding.components.OnboardingPage
import br.com.onboarding_presentation.feature.appNew.presentaion.onboarding.components.PageIndicator
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen() {

    val pageState = rememberPagerState(initialPage = 0)
    val spacing = LocalSpacing.current

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        val buttonState = remember {
            derivedStateOf {
                when (pageState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        HorizontalPager(pageCount = 3, state = pageState) { pageIndex ->
            OnboardingPage(page = pages[pageIndex])
        }

        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = spacing.spaceMedium),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator(
                modifier = Modifier.width(spacing.spaceLargeMedium),
                pageSize = pages.size,
                selectedPage = pageState.currentPage
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                val scope = rememberCoroutineScope()
                if (buttonState.value[0].isNotEmpty()) {
                    NewsButton(
                        text = buttonState.value[0],
                        onClick = {
                            scope.launch {
                                pageState.animateScrollToPage(
                                    page = pageState.currentPage - 1
                                )
                            }
                        }
                    )
                }
            }
        }

    }
}

@Composable
@Preview(showBackground = true, device = "id:pixel_7")
fun OnboardingScreenPreview() {
    OnboardingScreen()
}
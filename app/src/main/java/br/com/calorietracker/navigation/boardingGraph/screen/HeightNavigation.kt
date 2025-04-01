package br.com.calorietracker.navigation.boardingGraph.screen

import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.core.navigation.Route
import br.com.onboarding_presentation.feature.calorie.height.HeightScreen

fun NavGraphBuilder.heightScreen(
    onNavigationToWeight: () -> Unit,
    snackBarHostState: SnackbarHostState
) {
    composable(Route.HEIGHT) {
        HeightScreen(
            onNavigationToWeight = onNavigationToWeight,
            snackBarHostState = snackBarHostState
        )
    }
}

fun NavHostController.navigationToWeight() {
    navigate(Route.WEIGHT)
}
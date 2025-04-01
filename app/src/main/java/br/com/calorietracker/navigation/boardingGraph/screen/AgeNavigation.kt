package br.com.calorietracker.navigation.boardingGraph.screen

import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.core.navigation.Route
import br.com.onboarding_presentation.feature.calorie.age.AgeScreen

fun NavGraphBuilder.ageScreen(
    onNavigationToHeight: () -> Unit,
    snackBarHostState: SnackbarHostState
) {
    composable(Route.AGE) {
        AgeScreen(
            onNavigationToHeight = onNavigationToHeight,
            snackBarHostState = snackBarHostState
        )
    }
}

fun NavHostController.navigationToHeight() {
    navigate(Route.HEIGHT)
}
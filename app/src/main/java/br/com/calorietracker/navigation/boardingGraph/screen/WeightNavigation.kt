package br.com.calorietracker.navigation.boardingGraph.screen

import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.core.navigation.Route
import br.com.onboarding_presentation.feature.calorie.weight.WeightScreen

fun NavGraphBuilder.weightScreen(
    onNavigationToActivity: () -> Unit,
    snackBarHostState: SnackbarHostState
) {
    composable(Route.WEIGHT) {
        WeightScreen(
            onNavigationToActivity = onNavigationToActivity,
            snackBarHostState = snackBarHostState
        )
    }
}

fun NavHostController.navigationToActivity() {
    navigate(Route.ACTIVITY)
}
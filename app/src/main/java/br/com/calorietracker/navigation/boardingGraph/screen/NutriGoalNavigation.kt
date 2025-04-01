package br.com.calorietracker.navigation.boardingGraph.screen

import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.core.navigation.Route
import br.com.onboarding_presentation.feature.calorie.nutrient.NutrientScreen

fun NavGraphBuilder.nutrientGoalScreen(
    snackBarHostState: SnackbarHostState,
    onNavigationTrackerOverview: () -> Unit
) {
    composable(Route.NUTRIENT_GOAL) {
        NutrientScreen(
            onNavigationTrackerOverview = onNavigationTrackerOverview,
            snackBarHostState = snackBarHostState
        )
    }
}
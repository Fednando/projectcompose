package br.com.calorietracker.navigation.boardingGraph.screen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.core.navigation.Route
import br.com.onboarding_presentation.feature.calorie.activity.ActivityScreen

fun NavGraphBuilder.activityScreen(
    onNavigationToGoal: () -> Unit,
) {

    composable(Route.ACTIVITY) {
        ActivityScreen(
            onNavigationToGoal = onNavigationToGoal
        )
    }
}

fun NavHostController.navigationToGoal() {
    navigate(Route.GOAL)
}
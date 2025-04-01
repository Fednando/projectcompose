package br.com.calorietracker.navigation.boardingGraph.screen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.core.navigation.Route
import br.com.onboarding_presentation.feature.calorie.goal.GoalScreen

fun NavGraphBuilder.goalScreen(
    onNavigationToNutrientGoal: () -> Unit) {
    composable(Route.GOAL) {
        GoalScreen(
            onNavigationToNutrientGoal = onNavigationToNutrientGoal
        )
    }
}

fun NavHostController.navigationToNutrientGoal() {
    navigate(Route.NUTRIENT_GOAL)
}
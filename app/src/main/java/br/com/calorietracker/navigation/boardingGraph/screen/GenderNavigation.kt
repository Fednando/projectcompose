package br.com.calorietracker.navigation.boardingGraph.screen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.core.navigation.Route
import br.com.onboarding_presentation.feature.calorie.gender.GenderScreen

fun NavGraphBuilder.genderScreen(onNavigationToAge: () -> Unit) {
    composable(Route.GENDER) {
        GenderScreen(onNavigationToAge = onNavigationToAge)
    }
}

fun NavHostController.navigationToAge() {
    navigate(Route.AGE)
}
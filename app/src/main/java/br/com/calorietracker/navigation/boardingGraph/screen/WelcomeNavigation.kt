package br.com.calorietracker.navigation.boardingGraph.screen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.core.navigation.Route
import br.com.onboarding_presentation.feature.calorie.welcome.WelcomeScreen

fun NavGraphBuilder.welcomeScreen(
    onNavigationToGender: () -> Unit) {
    composable(Route.WELCOME) {
        WelcomeScreen(onNavigationToGender = onNavigationToGender)
    }
}

fun NavHostController.navigationToGender() {
    navigate(Route.GENDER)
}
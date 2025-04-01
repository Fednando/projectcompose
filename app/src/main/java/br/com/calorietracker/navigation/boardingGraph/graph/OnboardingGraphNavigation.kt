package br.com.calorietracker.navigation.boardingGraph.graph

import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import br.com.calorietracker.navigation.boardingGraph.screen.activityScreen
import br.com.calorietracker.navigation.boardingGraph.screen.ageScreen
import br.com.calorietracker.navigation.boardingGraph.screen.genderScreen
import br.com.calorietracker.navigation.boardingGraph.screen.goalScreen
import br.com.calorietracker.navigation.boardingGraph.screen.heightScreen
import br.com.calorietracker.navigation.boardingGraph.screen.nutrientGoalScreen
import br.com.calorietracker.navigation.boardingGraph.screen.weightScreen
import br.com.calorietracker.navigation.boardingGraph.screen.welcomeScreen
import br.com.core.navigation.Route

fun NavGraphBuilder.onBoardingGraph(
    snackBarHostState: SnackbarHostState,
    onNavigationToAge: () -> Unit,
    onNavigationToGender: () -> Unit,
    onNavigationToHeight: () -> Unit,
    onNavigationToWeight: () -> Unit,
    onNavigationToActivity: () -> Unit,
    onNavigationToGoal: () -> Unit,
    onNavigationToNutrientGoal: () -> Unit,
    onNavigationToTrackerOverview: () -> Unit
) {
    navigation(
        route = Route.ONBOARDING_GRAPH,
        startDestination = Route.WELCOME
    ) {
        welcomeScreen(onNavigationToGender = {
            onNavigationToGender()
        })
        genderScreen(onNavigationToAge = {
            onNavigationToAge()
        })
        ageScreen(
            snackBarHostState = snackBarHostState,
            onNavigationToHeight = {
                onNavigationToHeight()
            }
        )
        heightScreen(
            snackBarHostState = snackBarHostState,
            onNavigationToWeight = {
                onNavigationToWeight()
            }
        )
        weightScreen(
            snackBarHostState = snackBarHostState,
            onNavigationToActivity = {
                onNavigationToActivity()
            }
        )
        nutrientGoalScreen(
            snackBarHostState,
            onNavigationTrackerOverview = {
                onNavigationToTrackerOverview()
            }
        )
        activityScreen(onNavigationToGoal = {
            onNavigationToGoal()
        })
        goalScreen(onNavigationToNutrientGoal = {
            onNavigationToNutrientGoal()
        })
    }
}




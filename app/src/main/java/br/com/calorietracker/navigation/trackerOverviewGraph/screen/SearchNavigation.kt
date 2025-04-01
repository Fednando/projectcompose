package br.com.calorietracker.navigation.trackerOverviewGraph.screen

import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.core.navigation.Route
import br.com.tracker_presentation.search.SearchScreen

fun NavGraphBuilder.searchScreen(
    snackBarHostState: SnackbarHostState,
    onNavigateUp: () -> Unit
) {
    composable(
        route = Route.SEARCH + "/{mealName}/{dayOfMonth}/{month}/{year}",
        arguments = listOf(
            navArgument("mealName") {
                type = NavType.StringType
            },
            navArgument("dayOfMonth") {
                type = NavType.IntType
            },
            navArgument("month") {
                type = NavType.IntType
            },
            navArgument("year") {
                type = NavType.IntType
            },
        )
    ) {
        val mealName = it.arguments?.getString("mealName")!!
        val dayOfMonth = it.arguments?.getInt("dayOfMonth")!!
        val month = it.arguments?.getInt("month")!!
        val year = it.arguments?.getInt("year")!!
        SearchScreen(
            snackBarHostState = snackBarHostState,
            mealName = mealName,
            dayOfMonth = dayOfMonth,
            month = month,
            year = year,
            onNavigateUp = {
                onNavigateUp()
            }
        )
    }
}
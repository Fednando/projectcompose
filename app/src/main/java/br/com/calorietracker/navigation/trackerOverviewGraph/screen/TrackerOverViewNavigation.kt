package br.com.calorietracker.navigation.trackerOverviewGraph.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.core.navigation.Route
import br.com.tracker_presentation.trackeroverview.TrackerOverviewScreen

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.trackerOverviewScreen(
    onNavigateToSearch: (String, Int, Int, Int) -> Unit
) {
    composable(Route.TRACKER_OVERVIEW) {
        TrackerOverviewScreen(
            onNavigateToSearch = onNavigateToSearch
        )
    }
}

fun NavHostController.navigationToSearch(
    mealName: String,
    day: Int,
    month: Int,
    year: Int
) {
    navigate(
        Route.SEARCH + "/$mealName" +
                "/$day" +
                "/$month" +
                "/$year"
    )
}
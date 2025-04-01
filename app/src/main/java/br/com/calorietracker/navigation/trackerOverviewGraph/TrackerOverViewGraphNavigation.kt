package br.com.calorietracker.navigation.trackerOverviewGraph

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import br.com.calorietracker.navigation.trackerOverviewGraph.screen.searchScreen
import br.com.calorietracker.navigation.trackerOverviewGraph.screen.trackerOverviewScreen
import br.com.core.navigation.Route

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.trackerOverviewGraph(
    snackBarHostState: SnackbarHostState,
    onNavigateToSearch: (String, Int, Int, Int) -> Unit,
    onNavigateUp: () -> Unit
) {
    navigation(
        route = Route.TRACKER_OVERVIEW_GRAPH,
        startDestination = Route.TRACKER_OVERVIEW
    )
    {
        trackerOverviewScreen(
            onNavigateToSearch = onNavigateToSearch
        )
        searchScreen(
            snackBarHostState = snackBarHostState,
            onNavigateUp = onNavigateUp
        )
    }
}

fun NavHostController.navigationToTrackerOverviewGraph() {
    navigate(Route.TRACKER_OVERVIEW_GRAPH) {
        popUpTo(Route.ONBOARDING_GRAPH) {
            inclusive = true
        }
    }
}
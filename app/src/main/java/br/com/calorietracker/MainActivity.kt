package br.com.calorietracker

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import br.com.calorietracker.navigation.boardingGraph.graph.onBoardingGraph
import br.com.calorietracker.navigation.boardingGraph.screen.navigationToActivity
import br.com.calorietracker.navigation.boardingGraph.screen.navigationToAge
import br.com.calorietracker.navigation.boardingGraph.screen.navigationToGender
import br.com.calorietracker.navigation.boardingGraph.screen.navigationToGoal
import br.com.calorietracker.navigation.boardingGraph.screen.navigationToHeight
import br.com.calorietracker.navigation.boardingGraph.screen.navigationToNutrientGoal
import br.com.calorietracker.navigation.boardingGraph.screen.navigationToWeight
import br.com.calorietracker.navigation.trackerOverviewGraph.navigationToTrackerOverviewGraph
import br.com.calorietracker.navigation.trackerOverviewGraph.screen.navigationToSearch
import br.com.calorietracker.navigation.trackerOverviewGraph.trackerOverviewGraph
import br.com.calorietracker.ui.theme.CaloryTrackerTheme
import br.com.core.navigation.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val shouldShowOnboarding = viewModel.state

        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                val snackBarHostState = remember { SnackbarHostState() }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackBarHostState) }
                ) { innerPadding ->

                    NavHost(
                        navController = navController,
                        startDestination = if (shouldShowOnboarding) Route.ONBOARDING_GRAPH
                        else Route.TRACKER_OVERVIEW_GRAPH,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        onBoardingGraph(
                            snackBarHostState = snackBarHostState,
                            onNavigationToGender = {
                                navController.navigationToGender()
                            },
                            onNavigationToAge = {
                                navController.navigationToAge()
                            },
                            onNavigationToHeight = {
                                navController.navigationToHeight()
                            },
                            onNavigationToWeight = {
                                navController.navigationToWeight()
                            },
                            onNavigationToActivity = {
                                navController.navigationToActivity()
                            },
                            onNavigationToGoal = {
                                navController.navigationToGoal()
                            },
                            onNavigationToNutrientGoal = {
                                navController.navigationToNutrientGoal()
                            },
                            onNavigationToTrackerOverview = {
                                navController.navigationToTrackerOverviewGraph()
                            }
                        )
                        trackerOverviewGraph(
                            snackBarHostState = snackBarHostState,
                            onNavigateUp = {
                                navController.navigateUp()
                            },
                            onNavigateToSearch = { mealName, day, month, year ->
                                navController.navigationToSearch(mealName, day, month, year)
                            }
                        )
                    }
                }
            }
        }
    }
}
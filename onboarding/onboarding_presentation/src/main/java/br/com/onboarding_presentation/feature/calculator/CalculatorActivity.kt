package br.com.onboarding_presentation.feature.calculator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.calorietracker.calculator.presentation.CalculatorScreen
import br.com.calorietracker.ui.theme.MaterialCalculatorTheme
import br.com.core.navigation.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalculatorActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialCalculatorTheme {
                val navController = rememberNavController()
                val snackBarHostState = remember { SnackbarHostState() }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackBarHostState) }
                ) { innerPadding ->

                    NavHost(
                        navController = navController,
                        startDestination = Route.CALCULATOR,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Route.CALCULATOR) {
                            CalculatorScreen()
                        }
                    }
                }
            }
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CalculatorActivity::class.java)
        }
    }
}
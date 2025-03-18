package br.com.calorietracker.calculator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import br.com.calorietracker.MainViewModel
import br.com.calorietracker.ui.theme.CaloryTrackerTheme

class CalculatorActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            CaloryTrackerTheme {
            }
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, CalculatorActivity::class.java)
        }
    }
}
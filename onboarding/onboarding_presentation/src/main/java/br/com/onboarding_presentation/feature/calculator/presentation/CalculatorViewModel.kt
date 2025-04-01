package br.com.calorietracker.calculator.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import br.com.calorietracker.calculator.domain.CalculatorAction
import br.com.calorietracker.calculator.domain.ExpressionWriter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor() : ViewModel() {


    private val write: ExpressionWriter = ExpressionWriter()

    var expression by mutableStateOf("")
        private set

    fun onAction(action: CalculatorAction) {
        write.processAction(action)
        this.expression = write.expression
    }
}
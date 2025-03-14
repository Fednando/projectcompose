package br.com.calorietracker.navigation

import androidx.navigation.NavController
import br.com.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}
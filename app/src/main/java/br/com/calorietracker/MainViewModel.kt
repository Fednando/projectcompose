package br.com.calorietracker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import br.com.core.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    preferences: Preferences
) : ViewModel() {
    private val route = preferences.loadShouldShowOnboarding()
    var state by mutableStateOf(route)
        private set
}
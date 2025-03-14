package br.com.tracker_presentation.search

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.core.R
import br.com.core.domain.preferences.Preferences
import br.com.core.util.UiEvent
import br.com.core.util.UiText
import br.com.tracker_domain.model.TrackableFood
import br.com.tracker_domain.usecase.TrackerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val trackerUseCases: TrackerUseCases
) : ViewModel() {
    var state by mutableStateOf(SearchState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()


    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.OnQueryChange -> onQueryChange(event)
            is SearchEvent.OnSearch -> onSearch()
            is SearchEvent.OnToggleTrackableFood -> onToggleTrackableFood(event)
            is SearchEvent.OnAmountForFoodChange -> onAmountForFoodChange(event)
            is SearchEvent.OnTrackFoodClick -> trackFood(event)
            is SearchEvent.OnSearchFocusChange -> onSearchFocusChange(event)
        }
    }

    private fun onSearch() {
        viewModelScope.launch {
            state = state.copy(
                isSearching = true,
                trackableFood = emptyList()
            )
            trackerUseCases
                .searchFood(state.query)
                .onSuccess { onSuccess(it) }
                .onFailure { onFailure() }
        }
    }

    private fun onSuccess(foods: List<TrackableFood>) {
        state = state.copy(
            trackableFood = foods.map {
                TrackableFoodUiState(it)
            },
            isSearching = false,
            query = "",
        )
    }

    private suspend fun onFailure() {
        _uiEvent.send(
            UiEvent.ShowSnackBar(
                UiText.StringResource(R.string.error_something_went_wrong)
            )
        )
    }

    private fun onQueryChange(event: SearchEvent.OnQueryChange) {
        state = state.copy(query = event.query)
    }

    private fun trackFood(event: SearchEvent.OnTrackFoodClick) {
        viewModelScope.launch {
            val uiState = state.trackableFood.find { it.food == event.food }
            trackerUseCases.trackFood(
                food = uiState?.food ?: return@launch,
                amount = uiState.amount.toIntOrNull() ?: return@launch,
                mealType = event.mealType,
                date = event.date
            )
            _uiEvent.send(UiEvent.NavigateUp)
        }
    }

    private fun onSearchFocusChange(event: SearchEvent.OnSearchFocusChange) {
        state = state.copy(
            isHintVisible = !event.isFocused && state.query.isBlank()
        )
    }

    private fun onToggleTrackableFood(event: SearchEvent.OnToggleTrackableFood) {
        state = state.copy(
            trackableFood = state.trackableFood.map {
                if (it.food == event.food) {
                    it.copy(isExpanded = !it.isExpanded)
                } else it
            }
        )
    }

    private fun onAmountForFoodChange(event: SearchEvent.OnAmountForFoodChange) {
        state = state.copy(
            trackableFood = state.trackableFood.map {
                if (it.food == event.food) {
                    it.copy(amount = event.amount.filter { it.isDigit() })
                } else it
            }
        )
    }
}
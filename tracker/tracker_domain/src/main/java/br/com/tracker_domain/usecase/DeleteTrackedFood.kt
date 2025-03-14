package br.com.tracker_domain.usecase

import br.com.tracker_domain.model.TrackedFood
import br.com.tracker_domain.repository.TrackerRepository

class DeleteTrackedFood(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(
        trackedFood: TrackedFood
    ) {
        repository.deleteTrackerFood(trackedFood)
    }
}